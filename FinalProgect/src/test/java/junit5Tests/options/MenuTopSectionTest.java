package junit5Tests.options;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.utils.LogUtils;
import pages.utils.MenuCheckObject;
import junit5Tests.BaseTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(ScreenShooterExtension.class)
public class MenuTopSectionTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    static Stream<Arguments> dataForCheckOfTopMenu() {
        return Stream.of(
                Arguments.of("top",
                        Arrays.asList("������� ������������", "��������", "� ���������", "�������", "�������"),
                        "Top menu list does not match"),
                Arguments.of("drop-down",
                        Arrays.asList("������� ������������", "��������", "� ���������", "�������"),
                        "Top menu drop-down list does not match"),
                Arguments.of("TopButton",
                        Arrays.asList("InformationIcon", "NotificationIcon", "BusinessClassIcon"),
                        "List of top menu buttons does not match"),
                Arguments.of("search",
                        Arrays.asList("search"),
                        "Search string was not found")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCheckOfTopMenu")
    public void testTopMenu(String typeOfSearch,
                            List<String> listForCheck,
                            String errorMessage){
 //       MainPage mainPage = new MainPage();

        //top menu block: checking existing and list of elements
        MenuCheckObject topMenuList = mainPage.getExistsItem(typeOfSearch);
        System.out.println (topMenuList.getFoundList().toString());

        Assertions.assertTrue(topMenuList.isExist(), "item not found");
        Assertions.assertTrue(LogUtils.compareItemsCheck(topMenuList.getFoundList(), listForCheck), errorMessage);
    }
}
