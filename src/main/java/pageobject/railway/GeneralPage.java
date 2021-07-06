package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final String tabLogin = "//div[@id='menu']//a[@href='/Account/Login.cshtml']";
    private final String tabLogout = "//div[@id='menu']//a[@href='/Account/Logout']";
    private final String lblWelcomeMessages = "//div[@class='account']/strong";
    private final String tabBookTicket = "//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']";
    private final String tabMyTicket = "//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']";
    private final String tabChangePassword = "//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']";
    private final String tabRegister = "//div[@id='menu']//a[@href='/Account/Register.cshtml']";

    private static GeneralPage generalPage = null;

    public static GeneralPage getNewInstance() {
        generalPage = new GeneralPage();
        return generalPage;
    }

    protected WebElement getTabMyTicket() {
        return WebDriverManage.getInstance().findElementByXpath(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return WebDriverManage.getInstance().findElementByXpath(tabChangePassword);
    }

    protected WebElement getTabRegister() {
        return WebDriverManage.getInstance().findElementByXpath(tabRegister);
    }

    protected WebElement getTabLogin() {
        return WebDriverManage.getInstance().findElementByXpath(tabLogin);
    }

    protected WebElement getTabLogout() {
        return WebDriverManage.getInstance().findElementByXpath(tabLogout);
    }

    protected WebElement getLblWelcomeMessages() {
        return WebDriverManage.getInstance().findElementByXpath(lblWelcomeMessages);
    }

    protected WebElement getTabBookTicket() {
        return WebDriverManage.getInstance().findElementByXpath(tabBookTicket);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessages().getText();
    }

    public LoginPage goToLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void goToMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void goToChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public boolean CheckTabDisplayAfterLogin() {
        if (getTabMyTicket().isDisplayed() && getTabChangePassword().isDisplayed() && getTabLogout().isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean CheckPageOpen(String pageName) {
        String Title = WebDriverManage.getInstance().getWebDriver().getTitle();
        if (Title.contains(pageName)) {
            return true;
        }
        return false;
    }

    public boolean CheckTabLogoutExist(){
        if (getTabLogout() != null){
            return true;
        }
        return false;
    }
}
