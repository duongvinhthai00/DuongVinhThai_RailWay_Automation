package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.*;


public class GeneralPage {
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessages = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabTimeAble =  By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");

    protected WebElement getTabMyTicket() {
        return WebDriverManage.getDriver().findElement(tabMyTicket);
    }

    protected WebElement getTabTimeAble() {
        return WebDriverManage.getDriver().findElement(tabTimeAble);
    }

    protected WebElement getTabChangePassword() {
        return WebDriverManage.getDriver().findElement(tabChangePassword);
    }

    protected WebElement getTabRegister() {
        return WebDriverManage.getDriver().findElement(tabRegister);
    }

    protected WebElement getTabLogin() {
        return WebDriverManage.getDriver().findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return WebDriverManage.getDriver().findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessages() {
        return WebDriverManage.getDriver().findElement(lblWelcomeMessages);
    }

    protected WebElement getTabBookTicket() {
        return WebDriverManage.getDriver().findElement(tabBookTicket);
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessages().getText();
    }

    public void goToLoginPage() {
        this.getTabLogin().click();
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

    public void gotoTimeAblePage() {
        this.getTabTimeAble().click();
    }

    public boolean CheckTabDisplayAfterLogin() {
        if (getTabMyTicket().isDisplayed() && getTabChangePassword().isDisplayed() && getTabLogout().isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean CheckPageOpen(String pageName) {
        String Title = WebDriverManage.getDriver().getTitle();
        if (Title.contains(pageName)) {
            return true;
        }
        return false;
    }

    public boolean CheckTabLogoutExist(){
        try {
            getTabLogout();
            return true;
        }catch (NoSuchElementException error){
            return false;
        }
    }

}
