package pages.logination;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    String insertLoginPageCheckStr = "https://trello.com/login";
    private final SelenideElement language = $(By.id("language-picker"));
    private final SelenideElement insertLoginPageCheck = $(By.xpath("//h1[contains(text(),'Вход в Trello')]"));
    private SelenideElement emailInput = $(By.id("user"));
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement loginButton = $(By.id("login"));
    private SelenideElement ssoButton = $(By.id("use-sso-button"));
    private SelenideElement googleButton = $(By.id("googleButton"));
    private SelenideElement msButton = $(By.id("msftButton"));
    private SelenideElement appleButton = $(By.id("signInWithAppleButton"));
    private SelenideElement errorMessage = $(By.xpath("//p[@class='error-message']"));

    public LoginPage ifLoginPage() {
        try {
            insertLoginPageCheck.exists();
        }
        catch (Exception e) {
            System.out.println("Login page does not found. " + e.getMessage());
        }
        return this;
    }

    public AtlassianPage loginButtonClick(String loginAction) {
        switch (loginAction){
            case "Google":
                googleButton.click();
                break;
            case "Microsoft":
                msButton.click();
                break;
            case "Apple":
                appleButton.click();
                break;
            default: loginButton.click();
        }
        return page(AtlassianPage.class);
    }

    public boolean isErrorMessage() {
        return errorMessage.exists();
    }

    public LoginPage ssoClick() {
//        if (loginButton.getValue().compareTo("Вход с помощью SSO") == 0) {
//            //
//        }
        if (loginButton.getValue().compareTo("Войти") == 0) {
            ssoButton.click();
        }
        return this;
    }

    public LoginPage enterTextToLoginString(String inputElement, String text) {
        switch (inputElement) {
            case "email":
                emailInput.setValue(text);
                break;
            case "password":
                passwordInput.setValue(text);
                break;
        }
        return this;
    }

    public LoginPage setRusLanguage() {
        if (language.getValue() != "ru"){
            language.selectOptionByValue("ru");
        }
        return this;
    }
}
