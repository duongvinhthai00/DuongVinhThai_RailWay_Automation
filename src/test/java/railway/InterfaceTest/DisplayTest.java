package railway.InterfaceTest;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.railway.GeneralPage;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;
import railway.TestBase;

public class DisplayTest extends TestBase {

    HomePage homePage = HomePage.getNewInstance();
    GeneralPage generalPage = GeneralPage.getNewInstance();
    LoginPage loginPage = LoginPage.getNewInstance();


    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        homePage.open();
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        Assert.assertEquals(generalPage.CheckTabDisplayAfterLogin(), true);
        homePage.goToMyTicketPage();
        Assert.assertEquals(generalPage.CheckPageOpen("My Ticket"), true);
        homePage.goToChangePasswordPage();
        Assert.assertEquals(generalPage.CheckPageOpen("Change Password"), true);
        if (generalPage.CheckTabLogoutExist()){
            homePage.Logout();
        }
    }



}
