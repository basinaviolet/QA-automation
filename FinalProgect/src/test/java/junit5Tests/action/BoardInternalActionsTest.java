package junit5Tests.action;

import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import junit5Tests.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.BoardPage;
import pages.MainPage;

@ExtendWith(ScreenShooterExtension.class)
public class BoardInternalActionsTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"MyTestBoard, To do, task first, Первая задача для выполнения, Комментарий"})
    public void createNewListTest(String boardName, String listName, String cardName, String descriptionText, String commentText){
        MainPage mainPage = new MainPage();
        BoardPage boardPage = mainPage.openBoardPage(boardName);
        boardPage.ifBoardPage(boardName);
        boardPage.addNewList(listName);
        boardPage.addNewCard(cardName);
        boardPage.addCardDescription(descriptionText);
        boardPage.addCardComment(commentText);
    }

//    @ParameterizedTest
//    @CsvSource({"MyTestBoard, To do, task first, Первая задача для выполнения, Комментарий"})
//    public void addNewListTest(String boardName, String listName, String cardName, String descriptionText, String commentText){
//        MainPage mainPage = new MainPage();
//        BoardPage boardPage = mainPage.openBoardPage(boardName);
//        boardPage.ifBoardPage(boardName);
//        boardPage.addNewList(listName);
//        boardPage.addNewCard(cardName);
//        boardPage.addCardDescription(descriptionText);
//        boardPage.addCardComment(commentText);
//    }
}
