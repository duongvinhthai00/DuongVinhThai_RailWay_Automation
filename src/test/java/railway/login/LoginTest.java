package railway.login;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.TestBase;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        if (generalPage.CheckTabLogoutExist()) {
            homePage.Logout();
        }
    }

    @Test(description = "TC01 - User Can Login Into Railway with valid username and password")
    public void TC01() {
        System.out.println("TC01 - User Can Login Into Railway with valid username and password");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = String.format(Constant.WELCOME_MSG, Constant.USERNAME);
        Assert.assertEquals(actualMsg, expectedMsg);
    }


    @Test(description = "TC02 - User Can not Login Into Railway with blank username")
    public void TC02() {
        System.out.println("TC02 - User Can not Login Into Railway with blank username");
        homePage.goToLoginPage();
        loginPage.login("", Constant.VALID_PASSWORD);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.INVALID_LOGIN_MSG);
    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password ")
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.INVALID_USERNAME_PASSWORD);
    }

    @Test(description = "TC04 - Login page displays when un-logged User clicks on Book ticket tab")
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on Book ticket tab");
        homePage.gotoBookTicketPage();
        Assert.assertTrue(loginPage.checkLoginPageExist(), Constant.LOGIN_PAGE_NOT_EXIST);
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        homePage.goToLoginPage();
        loginPage.loginInvalid(4, Constant.USERNAME, Constant.INVALID_PASSWORD);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.MSG_LOGIN_ERROR_SEVERAL_TIME);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertEquals(loginPage.isLoginErrorMessageExist(), true);
        Assert.assertEquals(loginPage.getLoginErrorMessage(), Constant.INVALID_USERNAME_PASSWORD);
    }


}
