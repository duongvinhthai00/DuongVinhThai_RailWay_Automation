package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverManage {
    private WebDriver driver;
    private static WebDriverManage webDriverManage = null;
    public static WebDriverManage getInstance(){
        if (webDriverManage == null) {
            return webDriverManage = new WebDriverManage();
        }
        return webDriverManage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void ScrollTo(WebElement element){
        ((JavascriptExecutor) WebDriverManage.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true)",element);
    }
}
