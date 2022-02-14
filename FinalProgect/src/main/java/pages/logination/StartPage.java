package pages.logination;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.webdriver.Url;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverConditions.url;

public class StartPage {

    private final SelenideElement loginButton = $(By.xpath("//a[contains(@href,'login')]"));
    //    private final SelenideElement loginButtonEng = $(By.linkText("Log in"));
    private final SelenideElement language = $(By.id("language-picker"));

    public LoginPage loginButtonClick() {
        try {
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Login button was not clicked. " + e.getMessage());
        }
        return page(LoginPage.class);
    }

    public boolean ifStartPage(String homePageUrl) {
        try {
            webdriver().shouldHave(url(homePageUrl));
            return true;
        } catch (Exception e) {
            System.out.println("Logout was failed. " + e.getMessage());
            return false;
        }
    }

    public StartPage setRusLanguage() {
        if (language.getValue() != "ru") {
            language.selectOptionByValue("ru");
        }
        return this;
    }
}
