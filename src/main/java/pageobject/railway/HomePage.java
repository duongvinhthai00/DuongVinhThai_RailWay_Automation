package pageobject.railway;

import common.WebDriverManage;
import constant.Constant;

public class HomePage extends GeneralPage {
    private static HomePage homePage = null;

    public static HomePage getInstance(){
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public HomePage open(){
        WebDriverManage.getInstance().getWebDriver().navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public void Logout(){
        if(getTabLogout() != null){
            getTabLogout().click();
        }
    }
}
