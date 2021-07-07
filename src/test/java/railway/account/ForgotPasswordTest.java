package railway.account;

import common.WebDriverManage;
import constant.Constant;
import org.testng.annotations.Test;
import pageobject.railway.ForgotPasswordPage;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;
import railway.TestBase;

public class ForgotPasswordTest extends TestBase {
    HomePage homePage = HomePage.getNewInstance();
    LoginPage loginPage = LoginPage.getNewInstance();
    ForgotPasswordPage forgotPasswordPage = ForgotPasswordPage.getNewInstance();

    @Test(description = "Errors display when password reset token is blank")
    public void TC012(){
        homePage.open();
        homePage.goToLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendRequestResetPassword(Constant.USERNAME);
        WebDriverManage.getInstance().getWebDriver().navigate().to("https://mail.google.com/mail/u/0/#inbox");
        forgotPasswordPage.ClickLink();
    }

    public void TC013(){
        homePage.open();
        homePage.goToLoginPage();
        loginPage.goToForgotPasswordPage();
        forgotPasswordPage.SendRequestResetPassword(Constant.USERNAME);
        WebDriverManage.getInstance().getWebDriver().navigate().to("https://mail.google.com/mail/u/0/#inbox");
        forgotPasswordPage.ClickLink();
    }
}
