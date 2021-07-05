package railway.login;

import common.WebDriverManage;
import constant.Constant;
import javafx.scene.control.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.railway.GeneralPage;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;
import railway.TestBase;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        HomePage.getInstance().open();
    }


    @AfterMethod
    public void afterMethod() {
        if (GeneralPage.getInstance().CheckTabLogoutExist()){
            HomePage.getInstance().Logout();
        }
    }

    @Test(description = "TC01 - User Can Login Into Railway with valid username and password")
    public void TC01(){
        System.out.println("TC01 - User Can Login Into Railway with valid username and password");
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login(Constant.USERNAME,Constant.PASSWORD);
        String actualMsg = HomePage.getInstance().getWelcomeMessage();
        String expectedMsg = String.format(Constant.WELCOME_MSG,Constant.USERNAME);
        Assert.assertEquals(actualMsg,expectedMsg);
    }


    @Test(description = "TC02 - User Can not Login Into Railway with blank username")
    public void TC02(){
        System.out.println("TC02 - User Can not Login Into Railway with blank username");
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login("",Constant.PASSWORD);
        String actualMsg = LoginPage.getInstance().getLoginErrorMessage();
        String expectedMsg = Constant.INVALID_LOGIN_MSG;
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password ")
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().login(Constant.USERNAME,Constant.INVALID_PASSWORD);
        String actualMsg = LoginPage.getInstance().getLoginErrorMessage();
        String expectedMsg = Constant.INVALID_USERNAME_PASSWORD;
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on Book ticket tab");
        HomePage.getInstance().gotoBookTicketPage();
        Assert.assertTrue(LoginPage.getInstance().checkLoginPageExist(),Constant.LOGIN_PAGE_NOT_EXIST);
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage.getInstance().goToLoginPage();
        LoginPage.getInstance().loginInvalid(4,Constant.USERNAME,Constant.INVALID_PASSWORD);
        String actualMsg = LoginPage.getInstance().getLoginErrorMessage();
        String expectedMsg = Constant.MSG_LOGIN_ERROR_SEVERAL_TIME;
        Assert.assertEquals(actualMsg,expectedMsg);
    }


}
