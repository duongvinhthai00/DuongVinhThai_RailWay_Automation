package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        By elementLocator = By.xpath(locator);
        WebElement element = driver.findElement(elementLocator);
        return element;
    }

}
