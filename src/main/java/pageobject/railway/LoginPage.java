package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By fieldUsername = By.id("username");
    private final By fieldPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginError = By.xpath("//p[@class='message error LoginForm']");
    private final By linkForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");

    public WebElement getLinkForgotPassword() {
        return WebDriverManage.getDriver().findElement(linkForgotPassword);
    }

    private WebElement getElementUsername() {
        return WebDriverManage.getDriver().findElement(fieldUsername);
    }

    private WebElement getElementPassword() {
        return WebDriverManage.getDriver().findElement(fieldPassword);
    }

    private WebElement getElementLoginSubmit() {
        return WebDriverManage.getDriver().findElement(btnLogin);
    }

    private WebElement getElementLoginError() {
        return WebDriverManage.getDriver().findElement(lblLoginError);
    }

    public String getLoginErrorMessage() {
        return this.getElementLoginError().getText();
    }

    public HomePage login(String username, String password) {
        WebDriverManage.ScrollTo(this.getElementUsername());
        this.getElementUsername().sendKeys(username);
        WebDriverManage.ScrollTo(this.getElementPassword());
        this.getElementPassword().sendKeys(password);
        WebDriverManage.ScrollTo(this.getElementLoginSubmit());
        this.getElementLoginSubmit().click();
        return new HomePage();
    }

    public void goToForgotPasswordPage() {
        this.getLinkForgotPassword().click();
    }

    public boolean checkLoginPageExist() {
        boolean isUserNameExist = this.getElementUsername().isDisplayed();
        boolean isPasswordExist = this.getElementPassword().isDisplayed();
        boolean isBtnLoginExist = this.getElementLoginSubmit().isDisplayed();
        if (!isBtnLoginExist || !isPasswordExist || !isUserNameExist) {
            return false;
        }
        return true;
    }

    public boolean isLoginErrorMessageExist() {
        try {
            getElementLoginError();
            return true;
        } catch (NoSuchElementException error) {
            return false;
        }
    }

    public void loginInvalid(int numberRepeat, String UserName, String Password) {
        for (int i = 0; i < numberRepeat; i++) {
            login(UserName, Password);
        }
    }
}
