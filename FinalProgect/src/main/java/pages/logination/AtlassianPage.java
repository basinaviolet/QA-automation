package pages.logination;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class AtlassianPage {
    private SelenideElement passwordInput = $(By.id("password"));
    private SelenideElement submitButton = $(By.id("login-submit"));
    private SelenideElement hiddenButton = $(By.xpath("//span[@role='presentation']"));

    public AtlassianPage enterTextToLoginString(String text) {
        hiddenButton.hover();
        while (passwordInput.getValue().compareTo(text) != 0) {
                     passwordInput.setValue(text);
        }
        hiddenButton.click();
        return this;
    }

    public AtlassianAddPage loginButtonClick() {
//        //        if (passwordInput.getValue().compareTo("Zninja11") == 0){

//    }
        submitButton.click();
        return page(AtlassianAddPage.class);
    }
}
