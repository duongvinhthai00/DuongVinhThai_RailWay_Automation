package common;

import constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManage {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void setDriver() {
        System.setProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void closeBrowser()
    {
        driver.get().close();
        driver.remove();
    }

    public static void ScrollTo(WebElement element){
        ((JavascriptExecutor) WebDriverManage.getDriver()).executeScript("arguments[0].scrollIntoView(true)",element);
    }
}