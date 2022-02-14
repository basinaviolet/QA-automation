package junit5Tests.action;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;
import pages.logination.AtlassianPage;
import pages.logination.LoginPage;
import pages.logination.StartPage;
import utils.ConfProperties;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ScreenShooterExtension.class)
public class AuthorisationTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize="1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Violeta_B/bin/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=ru");    //en-US
//        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//        driver.get("https://google.com");
    }

    @Order(1)
    @Test
    public void Authorisation(String mainPageCheck) throws InterruptedException {
        StartPage startPage = open("https://trello.com", StartPage.class);
        LoginPage loginPage = startPage.loginButtonClick().setRusLanguage();
        AtlassianPage atlassianPage = loginPage.ifLoginPage()
                .enterTextToLoginString("email", ConfProperties.getProperty("email"))
                .enterTextToLoginString("password", ConfProperties.getProperty("password"))
                .loginButtonClick("login");
        atlassianPage.enterTextToLoginString(ConfProperties.getProperty("password"));

        MainPage mainPage = atlassianPage.loginButtonClick()
                       .getMainPage();
        Assertions.assertTrue(mainPage.ifMainPage(mainPageCheck), "The main page was not found");
    }

    @Order(2)
    @Test
    public void AuthorizationCheck() {
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.authorizationCheck(ConfProperties.getProperty("user"), ConfProperties.getProperty("email")),
                "The username or e-mail does not match.");
    }

    @Order(3)
    @ParameterizedTest
    @CsvSource({"https://trello.com/home"})
    public void AuthorizationOut(String homePage) {
        MainPage mainPage = new MainPage();
        StartPage startPage = mainPage.logOut().getStartPage();

        Assertions.assertTrue(startPage.ifStartPage(homePage),
                "Logout failed.");
    }
}
