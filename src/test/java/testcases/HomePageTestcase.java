package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.HomePage;
import utilities.BaseDriver;
import static utilities.URLs.BASE_URL;

public class HomePageTestcase extends BaseDriver {

    HomePage homePageObj = new HomePage();
    BoardPage boardPageObj = new BoardPage();

    @Test (groups = {"smoke", "regression"}, priority = 1)
    public void appearHomePageAndVerifyHomePageTitleURL() {
        homePageObj.isElementVisible(homePageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR,10);
        homePageObj.assertionURL(BASE_URL);
        homePageObj.assertionHard(homePageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR, homePageObj.HOME_PAGE_TITTLE_TEXT);
    }

    @Test (groups = {"smoke", "regression"}, priority = 2)
    public void createNewBoardAndVerifyBoardTitle() throws InterruptedException {
        homePageObj.fluentWaitClickOnElement(homePageObj.HOME_PAGE_BOARD_CREATE_BUTTON, 10);
        homePageObj.isElementVisible(homePageObj.HOME_PAGE_CREATE_BOARD_INPUT_FIELD, 4);
        String boardName = boardPageObj.randomBoardNameGenerator();
        homePageObj.writeText(homePageObj.HOME_PAGE_CREATE_BOARD_INPUT_FIELD, boardName);
        Thread.sleep(500);
        homePageObj.tabOnEnterOnKeyboard();
        homePageObj.isElementVisible(boardPageObj.BOARD_HOME_BUTTON,4);
        homePageObj.isElementVisible(boardPageObj.BOARD_LIST_ADD_BUTTON,4);
        Assert.assertFalse(homePageObj.isElementVisible(homePageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR,2), "Home page title is still visible after creating a new board.");
        Assert.assertEquals(boardPageObj.getTextContentByLocator(boardPageObj.BOARD_TITTLE_LOCATOR_TEXT), boardName, "Board title does not match the expected value.");
        homePageObj.takeScreenShotAllureAttach("Create new board and verify board title");


    }




}
