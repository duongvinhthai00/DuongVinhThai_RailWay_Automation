package railway;

import common.WebDriverManage;
import constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject.railway.GeneralPage;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;

public class TestBase {

    WebDriverManage webDriverManage = WebDriverManage.getInstance();
    protected GeneralPage generalPage = new GeneralPage();
    protected HomePage homePage = new HomePage();
    protected LoginPage loginPage = new LoginPage();
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        this.driver = new ChromeDriver();
        webDriverManage.setDriver(driver);
        this.driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        WebDriverManage.getInstance().getDriver().quit();
    }

}
