package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static utilities.BaseDriver.getDriver;

import java.util.Random;

public class BoardPage extends BasePage {

    public String BOARD_3_DOT_OPTION_MODAL_TITTLE_TEXT = "Board actions";
    public String BOARD_LIST_NAME_INPUT_FIELD_PLACEHOLDER_TEXT = "Enter list title...";
    public String BOARD_TITTLE_LOCATOR_TEXT = "//div[@class='inline-block invisible px-3 font-bold']";


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
    public By BOARD_HOME_BUTTON = By.xpath("//button[@class='visible']");

    private static final String[] adjectives = {
            "Quick", "Bright", "Silent", "Happy", "Agile", "Smart", "Cool", "Bold"
    };

    private static final String[] nouns = {
            "Project", "Board", "Task", "Sprint", "Workflow", "Plan", "Roadmap"
    };

    public static String randomBoardNameGenerator() {
        Random rand = new Random();
        String adjective = adjectives[rand.nextInt(adjectives.length)];
        String noun = nouns[rand.nextInt(nouns.length)];
        int number = rand.nextInt(1000);  // adds 0-999

        return adjective + noun + number;
    }
    private static final String[] LIST_NAMES = {"BackLog", "To Do", "On Hold", "On Process", "QA Review", "Done","PM Review", "Re-Open"
    };

    private static final Random RANDOM = new Random();

    public static String randomNewListNameCreator() {
        return LIST_NAMES[RANDOM.nextInt(LIST_NAMES.length)];
    }

    public String getTextContentByLocator(String locator) {
        try {
            WebElement element = getDriver().findElement(By.xpath(locator));
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String text = (String) js.executeScript("return arguments[0].textContent;", element);
            return text.trim();
        } catch (Exception e) {
            System.out.println("Error getting textContent: " + e.getMessage());
            return null;
        }
    }

    public void createNewList(String listName) throws InterruptedException {
       assertPlaceholderText(BOARD_LIST_INPUT_FIELD,BOARD_LIST_NAME_INPUT_FIELD_PLACEHOLDER_TEXT);
        writeText(BOARD_LIST_INPUT_FIELD, listName);
        fluentWaitClickOnElement(BOARD_LIST_ADD_BUTTON, 2);
        isElementVisible(By.xpath("//div[normalize-space()='" + listName + "']"), 4);
        takeScreenShotAllureAttach("Create new list: " + listName);
    }




}
