package pages;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static utilities.BaseDriver.getDriver;

public class BasePage {

    public File DATA_FILE_PATH = new File("src/test/resources/dashboardChangePassword.txt");
    public static SoftAssert softAssert = new SoftAssert();

    public WebElement findElement(By locator)
    {
        return getDriver().findElement(locator);
    }

    public void clickOn(By locator)
    {
        findElement(locator).click();
    }

    public void writeText(By locator , String text) throws InterruptedException
    {
        findElement(locator).click();
        hardTextClear(locator);
        findElement(locator).sendKeys(text);
        Thread.sleep(500);
    }

    public void hardTextClear(By locator){
        findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all existing text
        findElement(locator).sendKeys(Keys.DELETE); // Delete existing text
    }

    public String getText(By locator)
    {
        return findElement(locator).getText();
    }

    public String getUrl()
    {
        return getDriver().getCurrentUrl();
    }

    public void hover(By locator)
    {
        Actions action =  new Actions(getDriver());
        action.moveToElement(findElement(locator)).perform();
    }

    public void assertionHard(By locator, String expected)
    {
        assertEquals(getText(locator), expected);
    }

    public void assertionURL(String expected)
    {
        softAssert.assertEquals(getUrl(), expected);
    }

    public void assertionSoft(By locator, String expected)
    {
        softAssert.assertEquals(getText(locator), expected, "Text did not match!");
    }

    public void alertAccept(By locator)
    {
        clickOn(locator);
        getDriver().switchTo().alert().accept();
    }

    public void alertCancel(By locator)
    {
        clickOn(locator);
        getDriver().switchTo().alert().dismiss();
    }

    public void alertInput(By locator, String text)
    {
        clickOn(locator);
        getDriver().switchTo().alert().sendKeys(text);

    }

    public void newTab()
    {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public void newWindow()
    {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    public List<String> windowHandling()
    {
        Set<String> windowHandles = getDriver().getWindowHandles();
        ArrayList<String> windowHandlesList = new ArrayList<String>(windowHandles);
        int size = windowHandlesList.size();
        System.out.println("Window/Tab numbers: "+size);
        return windowHandlesList;
    }

    public void windowSwitch(int tabnumber)
    {
        try
        {
            getDriver().switchTo().window(windowHandling().get(tabnumber));
        }
        catch (Exception e)
        {
            System.out.println("Window tab number not exist!!!" +"Tab number is given :"+ tabnumber);
        }

    }

    public void navigaterForward()
    {
        getDriver().navigate().forward();
    }

    public void navigaterBack()
    {
        getDriver().navigate().back();
    }

    public void navigaterRefresh()
    {

        getDriver().navigate().refresh();
    }

    public void navigaterTo(String url)
    {

        getDriver().navigate().to(url);
    }


    public void keyboardTab()
    {
        Actions action =  new Actions(getDriver());
        action.sendKeys(Keys.TAB);
        action.build().perform();
    }

    public void tabOnEnterOnKeyboard()
    {
        Actions action =  new Actions(getDriver());
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }

    public void keyboardSelectAll(By locator)
    {
        Actions action =  new Actions(getDriver());
        findElement(locator).click();
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

    }

    public void keyboardBackspace()
    {
        Actions action =  new Actions(getDriver());
        action.keyDown(Keys.BACK_SPACE);
        action.build().perform();
    }

    public void keyboardCopy(By locator)
    {
        Actions action =  new Actions(getDriver());
        keyboardSelectAll(locator);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

    }

    public void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void keyboardPaste()
    {
        Actions action =  new Actions(getDriver());
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
    }

    public void scrollUntilElementFound(By targetLocator, By... optionalContainerLocator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement container = null;
        boolean isContainerScroll = optionalContainerLocator.length > 0;

        if (isContainerScroll) {
            container = findElement(optionalContainerLocator[0]);
        }

        int maxScrolls = 30;
        int scrollStep = 200;
        boolean elementFound = false;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElement target = findElement(targetLocator);
                if (target.isDisplayed()) {
                    elementFound = true;
                    break;
                }
            } catch (java.util.NoSuchElementException e) {
                // element not yet in DOM or not visible
            }

            if (isContainerScroll) {
                js.executeScript("arguments[0].scrollTop += arguments[1];", container, scrollStep);
            } else {
                js.executeScript("window.scrollBy(0, arguments[0]);", scrollStep);
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!elementFound) {
            throw new RuntimeException("Element not found after scrolling: " + targetLocator.toString());
        }
    }




    public void scrollHorizontallyLeft(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", getDriver().findElement(locator));

    }

    public void scrollHorizontallyUntilVisible(By containerLocator, By targetLocator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement container = getDriver().findElement(containerLocator);
        WebElement target = getDriver().findElement(targetLocator);

        int maxScroll = container.getSize().width * 10; // Avoid infinite loops
        int scrolled = 0;
        int step = 50;

        while (!isElementInView(container, target) && scrolled < maxScroll) {
            js.executeScript("arguments[0].scrollLeft += arguments[1];", container, step);
            scrolled += step;
        }
    }

    private boolean isElementInView(WebElement container, WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (Boolean) js.executeScript(
                "const container = arguments[0], elem = arguments[1];" +
                        "const containerRect = container.getBoundingClientRect();" +
                        "const elemRect = elem.getBoundingClientRect();" +
                        "return elemRect.left >= containerRect.left && elemRect.right <= containerRect.right;"
                , container, target);
    }

    public void scrollToElement(By locator) {
        WebElement element = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void takeScreenShotAllureAttach(String screenshotname) {
        Allure.addAttachment(screenshotname, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


    public void fluentWaitClickOnElement(By locator, int holdInSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(holdInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(java.util.NoSuchElementException.class);

        WebElement element = wait.until(driver -> {
            WebElement el = driver.findElement(locator);
            return (el != null && el.isDisplayed() && el.isEnabled()) ? el : null;
        });

        element.click();
    }

    public static WebElement fluentWaitForElement(By locator, int timeoutInSeconds, int pollingTimeInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingTimeInMillis))
                .ignoring(java.util.NoSuchElementException.class); // Ignore NoSuchElementException

        return wait.until(driver -> {
            WebElement element = driver.findElement(locator);
            return (element.isDisplayed()) ? element : null;
        });
    }

    public boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void saveToFile(String value ,File FILE_PATH) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(String.valueOf(value));

        }
        catch (IOException e) {

            System.err.println("Error saving balance to file: " + e.getMessage());

        }
    }

    public String readFile(File filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine(); // Read and return only the first line
        }
    }


    public void assertContains(By locator, String partialText){
        softAssert.assertTrue(findElement(locator).getText().contains(partialText), "Text does not contain!");
    }

    public  void assertPlaceholderText(By locator, String expectedText) {

        try{
            String actualPlaceholder = getDriver().findElement(locator).getAttribute("placeholder");
            Assert.assertEquals(actualPlaceholder, expectedText, "Placeholder text does not match!");
        } catch (Exception e) {
            assertionHard(locator,expectedText);
        }
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

}
