package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginError = By.xpath("//p[@class='message error LoginForm']");
    private final By linkForgotPassword = By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']");
    private static LoginPage loginPage = null;

    public WebElement getLinkForgotPassword() {
        return WebDriverManage.getInstance().getDriver().findElement(linkForgotPassword);
    }

    private WebElement getTxtUsername() {
        return WebDriverManage.getInstance().getDriver().findElement(_txtUsername);
    }

    private WebElement getTxtPassword() {
        return WebDriverManage.getInstance().getDriver().findElement(_txtPassword);
    }

    private WebElement getBtnLogin() {
        return WebDriverManage.getInstance().getDriver().findElement(_btnLogin);
    }

    private WebElement getLblLoginError() {
        return WebDriverManage.getInstance().getDriver().findElement(_lblLoginError);
    }

    public String getLoginErrorMessage() {
        return this.getLblLoginError().getText();
    }

    public HomePage login(String username, String password) {
        WebDriverManage.getInstance().ScrollTo(this.getTxtUsername());
        this.getTxtUsername().sendKeys(username);
        WebDriverManage.getInstance().ScrollTo(this.getTxtPassword());
        this.getTxtPassword().sendKeys(password);
        WebDriverManage.getInstance().ScrollTo(this.getBtnLogin());
        this.getBtnLogin().click();
        return new HomePage();
    }

    public void goToForgotPasswordPage() {
        this.getLinkForgotPassword().click();
    }

    public Boolean checkLoginPageExist() {
        Boolean isUserNameExist = this.getTxtUsername().isDisplayed();
        Boolean isPasswordExist = this.getTxtPassword().isDisplayed();
        Boolean isBtnLoginExist = this.getBtnLogin().isDisplayed();
        if (isBtnLoginExist == false || isPasswordExist == false || isUserNameExist == false) {
            return false;
        }
        return true;
    }

    public boolean isLoginErrorMessageExist() {
        try {
            getLblLoginError();
            return true;
        }catch (NoSuchElementException error){
            return false;
        }
    }

    public void loginInvalid(int numberRepeat, String UserName, String Password) {
        for (int i = 0; i < numberRepeat; i++) {
            login(UserName, Password);
        }
    }
}
