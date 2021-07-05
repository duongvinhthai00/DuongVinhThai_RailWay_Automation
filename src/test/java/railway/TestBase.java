package railway;

import common.WebDriverManage;
import constant.Constant;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void beforeClass(){
        WebDriverManage.getInstance().setDriverProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        WebDriverManage.getInstance().getWebDriver();
        WebDriverManage.getInstance().maximizeBrowser();
    }

    @AfterClass
    public void afterClass(){
        WebDriverManage.getInstance().closeBrowser();
    }

}
