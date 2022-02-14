package junit5Tests.action;

import junit5Tests.BaseTest;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.stream.Stream;

@ExtendWith(ScreenShooterExtension.class)
public class BoardDeleteTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"MyTemplateBoard Agile Board"})
    public void testNewBoardCreation(String boardName) {
        String boardMenuItem = "Доски";
        MainPage mainPage = new MainPage();
        int startBoardCount = mainPage.leftMenuPointClick(boardMenuItem).getBoardCount();
        mainPage = mainPage.openBoardPage(boardName)
                .closeBoardPage().closeBoard();

        // new count of boards on the main paige
        int endBoardCount = mainPage.leftMenuPointClick(boardMenuItem).getBoardCount();
        Assertions.assertEquals(1, (startBoardCount - endBoardCount), "Count of boards on the main page does not match");
    }
}
