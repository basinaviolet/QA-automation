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
public class SelectAndCheckOptionPointTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"Компьютеры и сети, catalog.onliner.by"})
    public void testSection(String actualOptionFull, String actualPageLink) throws FileNotFoundException {
        CatalogPage catalogPage = open("https://" + actualPageLink, CatalogPage.class);
        CatalogPage pageWithOptionList = catalogPage.selectOption(actualOptionFull);

        Assertions.assertTrue(pageWithOptionList.optionListIsVisible(), "list of option with points isn`t visible");

        Object[] pointsFromPage = Logic.getItemListFromPageList(catalogPage.getPointList().toArray());
        Object[] pointsForCheck = SectionsFileReader.getSections().get(actualOptionFull);

        Assertions.assertEquals(Logic.getNumComparedItems(pointsForCheck, pointsFromPage), pointsForCheck.length,
                "Point list does not match");
    }
}
