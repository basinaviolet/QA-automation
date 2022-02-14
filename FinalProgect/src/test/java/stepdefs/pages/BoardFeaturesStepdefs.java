package stepdefs.pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.BoardPage;
import pages.CloseBoardPage;
import pages.MainPage;
import pages.logination.AtlassianPage;
import pages.logination.LoginPage;
import pages.logination.StartPage;
import utils.ConfProperties;

import java.util.stream.Stream;

public class BoardFeaturesStepdefs {
    private final StartPage startPage = new StartPage();
    private final LoginPage loginPage = new LoginPage();

    private final MainPage mainPage = new MainPage();
    private final BoardPage boardPage = new BoardPage();
    private final CloseBoardPage closeBoardPage = new CloseBoardPage();

    private final String url = "https://trello.com/mishazninja/boards";
    private final String boardMenuItem = "Äîñêè";
    private final String mainPageCheck = "ÂÀØÈ ÐÀÁÎ×ÈÅ ÏÐÎÑÒÐÀÍÑÒÂÀ";
    private int startBoardCount;

//    @Test
//    public void testNewTemplateBoardCreation() {
//        String boardName = "MyTemplateBoard";
//        ///     MainPage mainPage = new MainPage();
//        BoardPage boardPage = mainPage
//                .createNewTemplateBoard(boardName);
//
//        Assertions.assertTrue(boardPage.ifTemplateBoardPage(boardName), "The board was not created");
//
//        mainPage = boardPage.returnToMain();
//        Assertions.assertTrue(mainPage.ifMainPage(mainPageCheck), "The main page was not found");
//    }

//    @Given("start Trello page is open")
//    public void startTrelloPageIsOpen() {
//        startPage.loginButtonClick().setRusLanguage();
//    }

    @Given("user has authorization and is located on the Mian Page")
    public void userHasAuthorizationAndIsLocatedOnTheMianPage() {
        startPage.loginButtonClick().setRusLanguage()
                .ifLoginPage()
                .enterTextToLoginString("email", ConfProperties.getProperty("email"))
                .enterTextToLoginString("password", ConfProperties.getProperty("password"))
                .loginButtonClick("login")
                .enterTextToLoginString(ConfProperties.getProperty("password"))
                .loginButtonClick()
                .getMainPage();
    }

    @When("click on the point of menu {string} get start count of existing boards")
    public void clickOnThePointOfMenuGetStartCountOfExistingBoards(String arg0) {
        startBoardCount = mainPage.leftMenuPointClick(arg0).getBoardCount();
    }

    @Then("click the Create new Board button")
    public void clickTheCreateNewBoardButton() {
        mainPage.boardCreateClick();
    }

    @Then("fill in the fields: board name={word}, type of board background={word}, color of board background={word}")
    public void fillInTheFieldsBoardNameBoardNameTypeOfBoardBackgroundBoardViewTypeColorOfBoardBackgroundColor(String arg0, String arg1, String arg2) {
        mainPage.createNewBoard(arg0, arg1, arg2);
    }

    @And("click Create new Board button")
    public void clickCreateNewBoardButton() {
    }

    @Then("open Board page and check the name of board={word}")
    public void openBoardPageAndCheckTheNameOfBoard(String arg0) {
        Assertions.assertTrue(boardPage.ifBoardPage(arg0), "The board was not created");
    }

    @And("return to Main page and check that the count of pages is changed by {int}")
    public void returnToMainPageAndCheckThatTheCountOfPagesChangedBy(int arg0) {
        boardPage.returnToMain();
        int endBoardCount = mainPage.leftMenuPointClick(boardMenuItem).getBoardCount();
        Assertions.assertEquals(arg0, (endBoardCount - startBoardCount), "Count of boards on the main page does not match");
    }

    @Then("click on the board={word} and move into it")
    public void clickOnTheBoardBoardNameAndMoveIntoIt(String arg0) {
        mainPage.openBoardPage(arg0);
    }

    @And("click step-by-step Menu, more, close and confirm buttons")
    public void clickStepByStepMenuMoreCloseAndConfirmButtons() {
        boardPage.closeBoardPage().closeBoard();
    }
}
