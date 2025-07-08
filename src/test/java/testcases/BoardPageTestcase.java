package testcases;

import org.testng.annotations.Test;
import pages.BoardPage;
import pages.HomePage;
import utilities.BaseDriver;

public class BoardPageTestcase extends BaseDriver {

    BoardPage boardPageobj = new BoardPage();
    HomePage homePageobj = new HomePage();

    @Test (groups = {"smoke", "regression"}, priority = 1)
    public void addTwoListAndAssertion() throws InterruptedException {
        homePageobj.fluentWaitClickOnElement(homePageobj.HOME_PAGE_TITTLE_TEXT_LOCATOR,8);
        homePageobj.fluentWaitClickOnElement(homePageobj.HOME_PAGE_FIRST_BOARD_LOCATOR, 2);
        boardPageobj.isElementVisible(boardPageobj.BOARD_HOME_BUTTON,8);
        boardPageobj.createNewList(boardPageobj.randomNewListNameCreator());
        boardPageobj.createNewList(boardPageobj.randomNewListNameCreator());
    }
}
