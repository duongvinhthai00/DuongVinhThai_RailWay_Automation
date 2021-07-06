package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final String _txtUsername = "//input[@id='username']";
    private final String _txtPassword = "//input[@id='password']";
    private final String _btnLogin = "//input[@value='Login']";
    private final String _lblLoginError = "//p[@class='message error LoginForm']";
    private static LoginPage loginPage = null;

    public static LoginPage getNewInstance(){
        loginPage = new LoginPage();
        return loginPage;
    }

   public WebElement getTxtUsername(){
       return WebDriverManage.getInstance().findElementByXpath(_txtUsername);
   }

   public WebElement getTxtPassword(){
        return WebDriverManage.getInstance().findElementByXpath(_txtPassword);
   }

   public WebElement getBtnLogin(){
        return WebDriverManage.getInstance().findElementByXpath(_btnLogin);
   }

   public WebElement getLblLoginError(){
        return WebDriverManage.getInstance().findElementByXpath(_lblLoginError);
   }

   public String getLoginErrorMessage(){
        return this.getLblLoginError().getText();
   }

   public HomePage login(String username,String password){
       this.getTxtUsername().sendKeys(username);
       this.getTxtPassword().sendKeys(password);
       this.getBtnLogin().click();
       return new HomePage();
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

   public void loginInvalid(int numberRepeat,String UserName,String Password){
        for (int i = 0;i<numberRepeat;i++){
            login(UserName,Password);
        }
   }
}
