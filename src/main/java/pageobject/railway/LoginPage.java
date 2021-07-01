package pageobject.railway;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblLoginError = By.xpath("//p[@class='message error LoginForm']");


   public WebElement getTxtUsername(){
       return Constant.WEBDRIVER.findElement(_txtUsername);
   }

   public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
   }

   public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
   }

   public WebElement getLblLoginError(){
        return Constant.WEBDRIVER.findElement(_lblLoginError);
   }

   public HomePage login(String username,String password){
       this.getTxtUsername().sendKeys(username);
       this.getTxtPassword().sendKeys(password);
       this.getBtnLogin().click();
       return new HomePage();
   }
}
