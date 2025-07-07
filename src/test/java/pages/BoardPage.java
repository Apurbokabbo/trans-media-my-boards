package pages;

import org.openqa.selenium.By;

import java.util.Random;

public class BoardPage extends BasePage {

    public String BOARD_3_DOT_OPTION_MODAL_TITTLE_TEXT = "Board actions";
    public String BOARD_LIST_NAME_INPUT_FIELD_PLACEHOLDER_TEXT = "Enter list title...";


    public String BOARD_TITTLE_LOCATOR ="//div[@class='inline-block invisible px-3 font-bold']";
    public By BOARD_FAV_ICON_LOCATOR = By.xpath("//div[@data-cy='star']");
    public By BOARD_3_DOT_OPTION_BUTTON = By.xpath("//button[@data-cy='board-options']");
    public By BOARD_3_DOT_OPTION_MODAL_TITTLE_LOCATOR = By.xpath("//div[normalize-space()='Board actions']");
    public By BOARD_3_DOT_OPTION_MODAL_DELETE_BUTTON = By.xpath("//div[@data-cy='delete-board']");
    public By BOARD_LIST_INPUT_FIELD = By.xpath("//input[@placeholder='Enter list title...']");
    public By BOARD_LIST_ADD_BUTTON = By.xpath("//button[normalize-space()='Add list']");
    public By BOARD_LIST_ADD_ANOTHER_LIST_BUTTON = By.xpath("//div[@data-cy='create-list' and contains(text(), 'Add another list')]");
    public By BOARD_LIST_1_3_DOT_BUTTON_LOCATOR = By.xpath("(//button[@data-cy='list-options']//*[name()='svg'])[1]");
    public By BOARD_LIST_2_3_DOT_BUTTON_LOCATOR = By.xpath("(//button[@data-cy='list-options']//*[name()='svg'])[2]");
    public By BOARD_LIST_3_3_DOT_ADD_ANOTHER_CARD_BUTTON = By.xpath("//div[@data-cy='card-add']");
    public By BOARD_LIST_3_3_DOT_DELETE_LIST_BUTTON = By.xpath("//div[@data-cy='delete-list']");




}
