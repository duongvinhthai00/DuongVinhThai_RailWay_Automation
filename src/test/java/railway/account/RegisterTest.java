package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.railway.*;
import railway.TestBase;

public class RegisterTest extends TestBase {

    HomePage homePage = HomePage.getNewInstance();
    RegisterPage registerPage = RegisterPage.getNewInstance();
    GeneralPage generalPage = GeneralPage.getNewInstance();

    @Test(description = "User can create new account")
    public void TC07() {
        homePage.open();
        homePage.goToRegisterPage();
        String email = Constant.EMAIL_RANDOM;
        registerPage.Register(email,Constant.PASSWORD,Constant.PASSWORD,Constant.PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), Constant.REGISTER_MESSAGE_SUCCESS);
        if (generalPage.CheckTabLogoutExist()){
            homePage.Logout();
        }
    }
}
