package pages.logination;

import pages.MainPage;

import static com.codeborne.selenide.Selenide.page;

public class AtlassianAddPage {

    public MainPage getMainPage() {
        return page(MainPage.class);
    }

    public StartPage getStartPage() {
        return page(StartPage.class);
    }

}
