package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final String tabLogin = "//div[@id='menu']//a[@href='/Account/Login.cshtml']";
    private final String tabLogout = "//div[@id='menu']//a[@href='/Account/Logout']";
    private final String lblWelcomeMessages = "//div[@class='account']/strong";
    private final String tabBookTicket = "//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']";

    protected WebElement getTabLogin(){
        return WebDriverManage.getInstance().findElementByXpath(tabLogin);
    }

    protected WebElement getTabLogout(){
        return WebDriverManage.getInstance().findElementByXpath(tabLogout);
    }

    protected WebElement getLblWelcomeMessages(){
        return WebDriverManage.getInstance().findElementByXpath(lblWelcomeMessages);
    }

    protected WebElement getTabBookTicket(){
        return WebDriverManage.getInstance().findElementByXpath(tabBookTicket);
    }

    public String getWelcomeMessage(){
        return this.getLblWelcomeMessages().getText();
    }

    public LoginPage goToLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket().click();
    }
}
