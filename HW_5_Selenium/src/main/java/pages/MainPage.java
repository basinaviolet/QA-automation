package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement topNavigatorOptionLink;

    public CatalogPage topNavigationOptionClick(String text) {
        topNavigatorOptionLink = $x("//li[@class='b-main-navigation__item']//span[text()='" + text + "']");
        topNavigatorOptionLink.click();
        return page(CatalogPage.class);
    }
}
