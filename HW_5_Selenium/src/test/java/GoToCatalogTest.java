import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CatalogPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterExtension.class)
public class GoToCatalogTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"Каталог, onliner.by"})
    public void testFindCatalog(String actualPage, String actualPageLink) {
        MainPage mainPage = open("https://" + actualPageLink, MainPage.class);
        CatalogPage catalogPage = mainPage
                .topNavigationOptionClick(actualPage);
        Assertions.assertTrue(catalogPage.getItemName().contains(actualPage),
                "link for clicking is not correct");
    }
}
