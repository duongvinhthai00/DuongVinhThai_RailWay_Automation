package pageobject.railway;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessages = By.xpath("//div[@class='account']/strong");

    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessages(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessages);
    }

    public String getWelcomeMessage(){
        return this.getLblWelcomeMessages().getText();
    }

    public LoginPage goToLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }
}
