package railway;

import common.WebDriverManage;
import constant.Constant;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject.railway.GeneralPage;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;

public class TestBase {

    protected HomePage homePage = HomePage.getNewInstance();
    protected GeneralPage generalPage = GeneralPage.getNewInstance();
    protected LoginPage loginPage = LoginPage.getNewInstance();

    @BeforeClass
    public void beforeClass(){
        WebDriverManage.getInstance().setDriverProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        WebDriverManage.getInstance().newWebDriver();
        WebDriverManage.getInstance().maximizeBrowser();
    }

    @AfterClass
    public void afterClass(){
        WebDriverManage.getInstance().closeBrowser();
    }

}
