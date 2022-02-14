package pages.logination;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleLoginPage {

    String insertLoginPageCheckStr = "https://trello.com/login";
    private SelenideElement emailInput = $(By.name("identifier")); //"//input[@name='identifier']"
    private SelenideElement nextButton = $(By.id("identifierNext"));

    public MainPage enterTextToInputString(String text) {
                emailInput.setValue(text);
        return page(MainPage.class);
    }
}
