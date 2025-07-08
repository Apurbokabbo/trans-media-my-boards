package testcases;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;
import org.testng.Assert;
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

    @Test (groups = {"smoke", "regression"}, priority = 2)
    public void deleteListandAssertion() throws InterruptedException {
        homePageobj.fluentWaitClickOnElement(homePageobj.HOME_PAGE_TITTLE_TEXT_LOCATOR,8);
        homePageobj.fluentWaitClickOnElement(homePageobj.HOME_PAGE_FIRST_BOARD_LOCATOR, 2);
        Thread.sleep(1000);
        boardPageobj.isElementVisible(boardPageobj.BOARD_LIST_1_3_DOT_BUTTON_LOCATOR, 8);
        boardPageobj.findElement(boardPageobj.BOARD_LIST_1_3_DOT_BUTTON_LOCATOR).click();
        boardPageobj.isElementVisible(boardPageobj.BOARD_LIST_3_DOT_MODAL_TITTLE_LOCATOR, 4);
        boardPageobj.fluentWaitClickOnElement(boardPageobj.BOARD_LIST_3_3_DOT_DELETE_LIST_BUTTON, 2);
        try {
            boardPageobj.isElementVisible(boardPageobj.BOARD_LIST_ADD_ANOTHER_LIST_BUTTON, 4);
        }
        catch (Exception e) {
            boardPageobj.isElementVisible(boardPageobj.BOARD_LIST_ADD_BUTTON, 4);

        }
        boardPageobj.takeScreenShotAllureAttach("Delete list and assertion");
    }
}
