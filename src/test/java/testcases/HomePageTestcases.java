package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.HomePage;
import utilities.BaseDriver;

public class HomePageTestcases extends BaseDriver {

    HomePage homepageObj = new HomePage();
    BoardPage boardPageObj = new BoardPage();

    @Test (groups = {"smoke", "regression"},priority = 1)
    public void appearHomePageAndVerifyHomePageTitle() {
        homepageObj.isElementVisible(homepageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR, 10);
        homepageObj.assertionHard (homepageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR,homepageObj.HOME_PAGE_TITTLE_TEXT);
    }

    @Test (groups = {"smoke", "regression"},priority = 2)
    public void createNewBoard() throws InterruptedException {
        homepageObj.isElementVisible(homepageObj.HOME_PAGE_TITTLE_TEXT_LOCATOR, 10);
        homepageObj.fluentWaitClickOnElement(homepageObj.HOME_PAGE_BOARD_CREATE_BUTTON,6);
        String boardName = homepageObj.randomBoardNameGenerator();
        homepageObj.writeText(homepageObj.HOME_PAGE_CREATE_BOARD_INPUT_FIELD,boardName);
        Thread.sleep(500);
        homepageObj.tabOnEnterOnKeyboard();
        boardPageObj.isElementVisible(boardPageObj.BOARD_FAV_ICON_LOCATOR, 10);
        Assert.assertFalse(homepageObj.isElementVisible(homepageObj.HOME_PAGE_BOARD_CREATE_BUTTON,2));
        Thread.sleep(500);
        Assert.assertEquals(boardPageObj.getTextContentByLocator(boardPageObj.BOARD_TITTLE_LOCATOR), boardName,"Given board name is not equal to created board name");
        homepageObj.takeScreenShotAllureAttach("Board created successfully: " + boardName);

    }
}
