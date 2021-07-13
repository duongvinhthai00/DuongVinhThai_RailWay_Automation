package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.ForgotPasswordPage;
import railway.TestBase;

public class ForgotPasswordTest extends TestBase {

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }


    @Test(description = "Errors display when password reset token is blank")
    public void TC012() {
        homePage.goToLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendRequestResetPassword(Constant.USERNAME);
        Assert.assertTrue(false, "[Know-Bug] The System doest not send request to email");
    }

    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC013()  {
        homePage.goToLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendRequestResetPassword(Constant.USERNAME);
        Assert.assertTrue(false, "[Know-Bug] The System doest not send request to email");
    }
}
