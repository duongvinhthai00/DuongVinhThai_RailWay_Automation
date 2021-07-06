package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManage {
    private static WebDriverManage webDriverManage = null;
    private WebDriver driver = null;

    public static WebDriverManage getInstance() {
        if (webDriverManage == null) {
            webDriverManage = new WebDriverManage();
        }
        return webDriverManage;
    }

    public WebDriver getWebDriver(){
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void newWebDriver(){
        this.driver = new ChromeDriver();
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void setDriverProperty(String driver, String pathDriver){
        System.setProperty(driver,pathDriver);
    }

    public WebElement findElementByXpath(String locator) {
        WebElement element = null;
        try {
            By elementLocator = By.xpath(locator);
            element = driver.findElement(elementLocator);
        }catch (StaleElementReferenceException e){
            element = null;
            e.printStackTrace();
        }catch (NoSuchElementException e1){
            element = null;
            e1.printStackTrace();
        }
        return element;
    }

    public WebElement findElementById(String id) {
        WebElement element = null;
        try {
            By elementLocator = By.id(id);
            element = driver.findElement(elementLocator);
        }catch (StaleElementReferenceException e){
            element = null;
            e.printStackTrace();
        }catch (NoSuchElementException e1){
            element = null;
            e1.printStackTrace();
        }
        return element;
    }

}
