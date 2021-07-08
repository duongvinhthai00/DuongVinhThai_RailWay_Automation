package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.RegisterPage;
import railway.TestBase;

public class RegisterTest extends TestBase {

    RegisterPage registerPage = RegisterPage.getNewInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }


    @AfterMethod
    public void afterMethod() {
        if (generalPage.CheckTabLogoutExist()){
            homePage.Logout();
        }
    }

    @Test(description = "User can create new account")
    public void TC07() {
        homePage.goToRegisterPage();
        String email = Constant.EMAIL_RANDOM;
        registerPage.Register(email,Constant.VALID_PASSWORD,Constant.VALID_CONFIRM_PASSWORD,Constant.PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), Constant.REGISTER_MESSAGE_SUCCESS);
    }

    @Test(description = "User can't create account with Confirm password is not the same with Password")
    public void TC10(){
        homePage.goToRegisterPage();
        String email = Constant.EMAIL_RANDOM;
        registerPage.Register(email,Constant.VALID_PASSWORD,Constant.INVALID_CONFIRM_PASSWORD,Constant.PID);
        Assert.assertEquals(registerPage.getRegisterFailedMessage(),Constant.REGISTER_MESSAGE_FAILED);
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11(){
        homePage.goToRegisterPage();
        String email = Constant.EMAIL_RANDOM;
        registerPage.Register(email,Constant.EMPTY_PASSWORD,Constant.EMPTY_CONFIRM_PASSWORD,Constant.EMPTY_PID);
        Assert.assertEquals(registerPage.getRegisterFailedMessage(),Constant.REGISTER_MESSAGE_FAILED);
        Assert.assertEquals(registerPage.getPasswordEmptyMessage(),Constant.PASSWORD_EMPTY_MESSAGE);
        Assert.assertEquals(registerPage.getPidEmptyMessage(),Constant.PID_EMPTY_MESSAGE);
    }
}
