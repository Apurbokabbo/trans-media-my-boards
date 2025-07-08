package pages;

import org.openqa.selenium.By;

import java.util.Random;

public class HomePage extends BasePage{
    public String HOME_PAGE_TITTLE_TEXT = "My Boards";
    public String HOME_PAGE_BOARD_CREATE_INPUT_FIELD_PLACEHOLDER_TEXT = "Add board title";
    public String HOME_PAGE_BOARD_CREATE_BUTTON_NAME_TEXT = "Create new board";


    public By HOME_PAGE_TITTLE_TEXT_LOCATOR = By.xpath("//h1[normalize-space()='My Boards']");
    public By HOME_PAGE_FIRST_BOARD_LOCATOR = By.xpath("//div[@class='board' and @id='board-1']");
    public By HOME_PAGE_CREATE_BOARD_INPUT_FIELD = By.xpath("//input[@placeholder='Add board title']");
    public By HOME_PAGE_BOARD_CREATE_BUTTON = By.xpath("//h1[normalize-space()='Create new board']");
    public By HOME_PAGE_BOARD_CREATE_CANCEL_BUTTON = By.xpath("//div[@class='active']//*[name()='svg']");
    public By HOME_PAGE_BOARD_FAV_BUTTON_FIRST = By.xpath("(//div[@class='star']//*[name()='svg'])[1]");
    public By HOME_PAGE_BOARD_FAV_BUTTON_SECOND = By.xpath("(//div[@class='star']//*[name()='svg'])[2]");
    public By HOME_PAGE_BOARD_FAV_BUTTON_THIRD = By.xpath("(//div[@class='star']//*[name()='svg'])[3]");
        public By HOME_PAGE_BOARD_FAV_BUTTON_FOURTH = By.xpath("(//div[@class='star']//*[name()='svg'])[4]");

    private static final String[] adjectives = {
            "Quick", "Bright", "Silent", "Happy", "Agile", "Smart", "Cool", "Bold"
    };

    private static final String[] nouns = {
            "Project", "Board", "Task", "Sprint", "Workflow", "Plan", "Roadmap"
    };

    public  String randomBoardNameGenerator() {
        Random rand = new Random();
        String adjective = adjectives[rand.nextInt(adjectives.length)];
        String noun = nouns[rand.nextInt(nouns.length)];
        int number = rand.nextInt(1000);  // adds 0-999

        return adjective + noun + number;
    }
}
