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
public class MenuLeftSectionTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    static Stream<Arguments> dataForCheckOfLeftMenu() {
        return Stream.of(
                Arguments.of("left",
                        Arrays.asList("?????", "???????", "??????? ????????",
                        "??????? ???????????? Trello", "?????", "?????? ???????", "??????? ???????? ????????????", "?????????", "?????????"),
                        "List of left menu buttons does not match"),
                Arguments.of("leftButtonStart",
                        Arrays.asList("?????? ??????? ?????????? ??????"),
                        "The start button does not found"),
                Arguments.of("leftButtonWorkSpace",
                        Arrays.asList("???????? ??????? ????????????"),
                        "The workspace creation button was not found"),
                Arguments.of("leftButtonClose",
                        Arrays.asList("CloseIcon"),
                        "The close button does not found")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCheckOfLeftMenu")
    public void testTopMenu(String typeOfSearch,
                            List<String> listForCheck,
                            String errorMessage) {
  //      MainPage mainPage = new MainPage();

        //top menu block: checking existing and list of elements
        MenuCheckObject topMenuList = mainPage.getExistsItem(typeOfSearch);
        System.out.println (topMenuList.getFoundList().toString());

        Assertions.assertTrue(topMenuList.isExist(), "The item was not found");
        Assertions.assertTrue(LogUtils.compareItemsCheck(topMenuList.getFoundList(), listForCheck), errorMessage);
    }
}
