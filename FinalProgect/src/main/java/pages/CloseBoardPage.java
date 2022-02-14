package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CloseBoardPage {
    private final SelenideElement closeBoardButton = $(By.xpath("//button[@data-test-id='close-board-delete-board-button']"));
    private final SelenideElement closeBoardConfirm = $(By.xpath("//button[@data-test-id='close-board-delete-board-confirm-button']"));


    public MainPage closeBoard (){
        closeBoardButton.click();
        closeBoardConfirm.click();
        return page(MainPage.class);
    }
}
