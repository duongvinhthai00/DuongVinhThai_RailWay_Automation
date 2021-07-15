package pageobject.railway;

import common.WebDriverManage;
import constant.Constant;

public class HomePage extends GeneralPage {

    public HomePage open() {
        System.out.println(WebDriverManage.getDriver() + " - ID Thread" + Thread.currentThread().getId());
        WebDriverManage.getDriver().navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public void Logout() {
        if (getTabLogout() != null) {
            getTabLogout().click();
        }
    }
}
