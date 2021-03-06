package junit5Tests.options;

import junit5Tests.BaseTest;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.utils.LogUtils;
import pages.utils.MenuCheckObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(ScreenShooterExtension.class)
public class MenuBoardSectionTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    static Stream<Arguments> dataForCheckOfLeftMenu() {
        return Stream.of(
                Arguments.of("boardsMenu",
                        Arrays.asList("?????", "??????? ???????? ????????????", "?????????", "?????????"),
                        "List of boards does not match"),
                Arguments.of("boardsHeader",
                        Arrays.asList("??????? ???????????? Trello"),
                        "Header of boards does not match"),
                Arguments.of("boardsMainHeader",
                        Arrays.asList("???? ??????? ????????????"),
                        "Header of boards does not match"),
                Arguments.of("boardsButton",
                        Arrays.asList("????????", "?????????? ???????? ?????"),
                        "List of buttons of Top menu does not match"),
                Arguments.of("boards",
                        Arrays.asList("??????? ?????"),
                        "List of buttons of Top menu does not match")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCheckOfLeftMenu")
    public void testTopMenu(String typeOfSearch,
                            List<String> listForCheck,
                            String errorMessage) throws InterruptedException {

        //top menu block: checking existing and list of elements
        MenuCheckObject topMenuList = mainPage.getExistsItem(typeOfSearch);
        System.out.println (topMenuList.getFoundList().toString());

        Assertions.assertTrue(topMenuList.isExist(), "The item was not found");
        Assertions.assertTrue(LogUtils.compareItemsCheck(topMenuList.getFoundList(), listForCheck), errorMessage);
    }
}
