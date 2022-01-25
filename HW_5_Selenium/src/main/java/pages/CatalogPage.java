package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement itemName = $("h1.catalog-navigation__title");
    private final SelenideElement catalogSectionPoints = $("div.catalog-navigation-list__wrapper");

    private final ElementsCollection catalogSectionItem = $$("span.catalog-navigation-classifier__item-title-wrapper");
    private final ElementsCollection catalogSectionPointsList = $$("div.catalog-navigation-list__wrapper div.catalog-navigation-list__aside-item");
    private final ElementsCollection catalogSectionPointItemsListTitle = $$("div.catalog-navigation-list__wrapper div.catalog-navigation-list__dropdown-list span.catalog-navigation-list__dropdown-title");
    private final ElementsCollection catalogSectionPointItemsListDesc = $$("div.catalog-navigation-list__wrapper div.catalog-navigation-list__dropdown-list span.catalog-navigation-list__dropdown-description");


    public String getItemName() {
        return itemName.text();
    }

    public List<String> getSectionList() {
        return catalogSectionItem.texts();
    }

    //@Uladislav, подскажите, пожалуйста, как лучше написать здесь локатор по обращению к родителю, что бы не было /../..
//    private SelenideElement topNavigatorOptionLink;
//    public String getSectionNum(String text) {
//        topNavigatorOptionLink = $x("//ul[@class='catalog-navigation-classifier']//span[starts-with(text(), '" + text + "')]/../..");
//        return topNavigatorOptionLink.getAttribute("data-id");
//    }

    public List<String> getPointList() {
        return catalogSectionPointsList.texts();
    }

    //@Uladislav, я так и не смогда разделить строку на части, поэтому пошла друим путем, но все же, вопрос остался, что я сделала не так?
//    public List<String> getPointItems() {
//        List<String> result = new ArrayList<>();
//        for (String item : catalogSectionPointItemsList.texts()) {
//            if (item.compareTo("") != 0) {
//                item.replaceAll("\n", "");
//                item.replaceAll("\t", "");
//                item.replaceAll("\\n", "");
//                item.replaceAll("\\t", "");
//                item.replaceAll("\r", "");
//                item.replaceAll("\\r", "");
//                item.replaceAll("\r\n", "");
//                item.replaceAll("\\r\\n", "");
//                result.add(item);
//            }
//        }
//        return result;
//    }

    public List<String> getPointItemsTitles() {
        return catalogSectionPointItemsListTitle.texts();
    }

    public List<String> getPointItemsDesc() {
        return catalogSectionPointItemsListDesc.texts();
    }


    //@Uladislav, я после нажатия на "компьютеры и сети" не смогла достучаться до элементов ниже обертки элементов
    // вертикального списока пунктов секции catalogSectionPoints = $("div.catalog-navigation-list__wrapper")
    // поэтому тоже пошла друим путем, но мой тест на проверку открытия списка проверяет есть ли обертка.
    // это некорректно.
    // Это был главный вопрос задержки данного ДЗ, потому что на этом месте я остановилась и не могла достучаться
    // ни до одного элемента в обертке со списком.
    // что я делала не так?
//    public CatalogPage navigationOptionClick(String text) {
//        navigatorOptionLink = $x("//" + navigatorOptionLinkLocator + "//span[starts-with(text(), '" + text + "')]");
//        navigatorOptionLink.parent().hover().click();
//        return page(CatalogPage.class);
//    }

    public CatalogPage selectOption(String text) {
        $(byText(text)).click();
        return page(CatalogPage.class);
    }

    //@Uladislav, я после нажатия на "компьютеры и сети" не смогла достучаться до элементов ниже обертки элементов
    // вертикального списока пунктов секции catalogSectionPoints = $("div.catalog-navigation-list__wrapper")
    // поэтому тоже пошла друим путем (вот так по заванию элемент нашелся), но мой тест на проверку открытия списка проверяет есть ли обертка.
    // это некорректно.
    // Это был главный вопрос задержки данного ДЗ, потому что на этом месте я остановилась и не могла достучаться
    // ни до одного элемента в обертке со списком.
    // что я делала не так?
    public void getNavigationOptionPointsList(String sectionPoint) {
        $(byText(sectionPoint)).click();
    }

    public boolean optionListIsVisible() {
        return catalogSectionPoints.scrollIntoView(false).exists();
    }
}
