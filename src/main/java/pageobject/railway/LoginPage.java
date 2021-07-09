package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final String _txtUsername = "//input[@id='username']";
    private final String _txtPassword = "//input[@id='password']";
    private final String _btnLogin = "//input[@value='Login']";
    private final String _lblLoginError = "//p[@class='message error LoginForm']";
    private final String linkForgotPassword = "//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']";
    private static LoginPage loginPage = null;

    public static LoginPage getNewInstance(){
        loginPage = new LoginPage();
        return loginPage;
    }

    public WebElement getLinkForgotPassword(){
        return WebDriverManage.getInstance().findElementByXpath(linkForgotPassword);
    }

    private WebElement getTxtUsername(){
       return WebDriverManage.getInstance().findElementByXpath(_txtUsername);
   }

    private WebElement getTxtPassword(){
        return WebDriverManage.getInstance().findElementByXpath(_txtPassword);
   }

    private WebElement getBtnLogin(){
        return WebDriverManage.getInstance().findElementByXpath(_btnLogin);
   }

    private WebElement getLblLoginError(){
        return WebDriverManage.getInstance().findElementByXpath(_lblLoginError);
   }

   public String getLoginErrorMessage(){
        return this.getLblLoginError().getText();
   }

   public HomePage login(String username,String password){
       WebDriverManage.getInstance().ScrollTo(this.getTxtUsername());
       this.getTxtUsername().sendKeys(username);
       WebDriverManage.getInstance().ScrollTo(this.getTxtPassword());
       this.getTxtPassword().sendKeys(password);
       WebDriverManage.getInstance().ScrollTo(this.getBtnLogin());
       this.getBtnLogin().click();
       return new HomePage();
   }

   public void goToForgotPasswordPage(){
        this.getLinkForgotPassword().click();
   }

   public Boolean checkLoginPageExist(){
        Boolean isUserNameExist = this.getTxtUsername().isDisplayed();
        Boolean isPasswordExist = this.getTxtPassword().isDisplayed();
        Boolean isBtnLoginExist = this.getBtnLogin().isDisplayed();
        if(isBtnLoginExist == false || isPasswordExist == false || isUserNameExist == false){
            return false;
        }
        return true;
   }

   public boolean isLoginErrorMessageExist(){
        if (this.getLblLoginError() == null){
            return false;
        }
        return true;
   }

   public void loginInvalid(int numberRepeat,String UserName,String Password){
        for (int i = 0;i<numberRepeat;i++){
            login(UserName,Password);
        }
   }
}
