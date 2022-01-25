import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import file.SectionsFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CatalogPage;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterExtension.class)
public class SelectOptionInCatalogPageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");
    }

    //https://catalog.onliner.by/
    @ParameterizedTest
    @CsvSource({"catalog.onliner.by"})
    public void testCatalogPage(String actualPageLink) throws FileNotFoundException {
        CatalogPage catalogPage = open("https://" + actualPageLink, CatalogPage.class);
        Object[] sectionsFromPage = Logic.getItemListFromPageList(catalogPage.getSectionList().toArray());
        Object[] sectionsForCheck = SectionsFileReader.getSections().keySet().toArray();

        Assertions.assertEquals(Logic.getNumComparedItems(sectionsForCheck, sectionsFromPage), sectionsForCheck.length,
                "Section list does not match");
    }
}
