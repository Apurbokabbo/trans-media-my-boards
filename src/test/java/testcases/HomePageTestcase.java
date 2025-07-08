package testcases;

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




}
