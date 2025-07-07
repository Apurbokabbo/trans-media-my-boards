package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String HOME_PAGE_TITTLE_TEXT = "My Boards";
    public String HOME_PAGE_BOARD_CREATE_INPUT_FIELD_PLACEHOLDER_TEXT = "Add board title";
    public String HOME_PAGE_BOARD_CREATE_BUTTON_NAME_TEXT = "Create new board";


    public By HOME_PAGE_TITTLE_TEXT_LOCATOR = By.xpath("//h1[normalize-space()='My Boards']");
    public By HOME_PAGE_FIRST_BOARD_LOCATOR = By.xpath("//div[@class='board' and @id='board-1']");
    public By HOME_PAGE_CREATE_BOARD_INPUT_FIELD = By.xpath("//input[@placeholder='Add board title']");
    public By HOME_PAGE_BOARD_CREATE_BUTTON = By.xpath("//button[normalize-space()='Create board']");
    public By HOME_PAGE_BOARD_CREATE_CANCEL_BUTTON = By.xpath("//div[@class='active']//*[name()='svg']");
    public By HOME_PAGE_BOARD_FAV_BUTTON_FIRST = By.xpath("(//div[@class='star']//*[name()='svg'])[1]");
    public By HOME_PAGE_BOARD_FAV_BUTTON_SECOND = By.xpath("(//div[@class='star']//*[name()='svg'])[2]");
    public By HOME_PAGE_BOARD_FAV_BUTTON_THIRD = By.xpath("(//div[@class='star']//*[name()='svg'])[3]");
}
