import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CatalogPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterExtension.class)
public class CheckOptionPointItemsTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");
    }

    //@Uladislav, у меня этот тест отрабатывает очень долго, не пойму почему
    @ParameterizedTest
    @CsvSource({"Компьютеры и сети, catalog.onliner.by, Комплектующие"})
    public void testOptionPointItems(String actualOptionFull, String actualPageLink, String actualPoint) {
        CatalogPage catalogPage = open("https://" + actualPageLink, CatalogPage.class);

        catalogPage.selectOption(actualOptionFull).getNavigationOptionPointsList(actualPoint);

        Object[] itemsDescFromPage = Logic.getItemListFromPageList(catalogPage.getPointItemsDesc().toArray());
        Object[] itemsTitlesFromPage = Logic.getItemListFromPageList(catalogPage.getPointItemsTitles().toArray());

        Assertions.assertEquals(Logic.getNumCheckItemsOfOptionPoint(itemsDescFromPage), itemsTitlesFromPage.length,
                "One or more items of " + actualPoint + " do not contain count of product or price");
    }
}
