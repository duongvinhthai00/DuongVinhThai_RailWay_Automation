package railway;

import constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.HomePage;
import pageobject.railway.LoginPage;

public class LoginTest {

    @BeforeMethod
    public void beforemethod() {
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\USER\\IdeaProjects\\RailwayTest\\src\\main\\executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }


    @AfterMethod
    public void aftermethod() {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01(){
        System.out.println("TC01 - User Can Login Into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME,Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
    }


    @Test
    public void TC02(){
        System.out.println("TC02 - User Can not Login Into Railway with blank username");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("",Constant.PASSWORD);
        String actualMsg = loginPage.getLblLoginError().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg,expectedMsg,"Message is not showing");
    }

    @Test
    public void TC03(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME,"a012456");
        String actualMsg = loginPage.getLblLoginError().getText();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Message is not showing");
    }

}
