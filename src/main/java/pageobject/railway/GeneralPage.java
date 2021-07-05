package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private final String tabLogin = "//div[@id='menu']//a[@href='/Account/Login.cshtml']";
    private final String tabLogout = "//div[@id='menu']//a[@href='/Account/Logout']";
    private final String lblWelcomeMessages = "//div[@class='account']/strong";
    private final String tabBookTicket = "//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']";

    private static GeneralPage generalPage = null;

    public static GeneralPage getInstance() {
        if (generalPage == null) {
            generalPage = new GeneralPage();
        }
        return generalPage;
    }

    public String getXpathOfTab(String href) {
        return (new StringBuilder()).append("//div[@id='menu']//a[@href=").append(href).append("]").toString();
    }

    protected WebElement getTabMyTicket() {
        return WebDriverManage.getInstance().findElementByXpath(getXpathOfTab("'/Page/ManageTicket.cshtml'"));
    }

    protected WebElement getTabChangePassword() {
        return WebDriverManage.getInstance().findElementByXpath(getXpathOfTab("'/Account/ChangePassword.cshtml'"));
    }

    protected WebElement getTabRegister() {
        return WebDriverManage.getInstance().findElementByXpath(getXpathOfTab("'/Account/Register.cshtml'"));
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
        boolean present;
        try {
            getTabLogout();
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }
}
