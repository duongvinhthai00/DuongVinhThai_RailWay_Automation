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

    protected GeneralPage generalPage = new GeneralPage();
    protected HomePage homePage = new HomePage();
    protected LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void beforeClass(){
        WebDriverManage.setDriver();
    }

    @AfterClass
    public void afterClass(){
        WebDriverManage.closeBrowser();
    }

}
