package junit5Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.logination.AtlassianPage;
import pages.logination.LoginPage;
import pages.logination.StartPage;
import utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterExtension.class)
public class BaseTest {

    public static String baseUrl = "https://trello.com";

    @BeforeAll
    public static void setUp() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");

        //authorization block
        StartPage startPage = open(baseUrl, StartPage.class);
        LoginPage loginPage = startPage.loginButtonClick().setRusLanguage();
        AtlassianPage atlassianPage = loginPage.ifLoginPage()
                .enterTextToLoginString("email", ConfProperties.getProperty("email"))
                .enterTextToLoginString("password", ConfProperties.getProperty("password"))
                .loginButtonClick("login");
        atlassianPage.enterTextToLoginString(ConfProperties.getProperty("password"));

    //    MainPage mainPage =
                atlassianPage.loginButtonClick().getMainPage();
    }
}
