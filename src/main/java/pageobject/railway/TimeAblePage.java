package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeAblePage extends GeneralPage {
    private String tdTimeAble = "//tr[td='%s' and td = '%s' and td='%s' and td='%s']//a[text()='book ticket']";
    private static TimeAblePage timeAblePage = null;
    private WebElement getTdTimeAble(String DepartFrom, String ArriveAt, String DepartTime, String ArriveTime) {
        By tdTimeAble = By.xpath(String.format(this.tdTimeAble, DepartFrom, ArriveAt, DepartTime, ArriveTime));
        return WebDriverManage.getInstance().getDriver().findElement(tdTimeAble);
    }

    public void BookTicketFromTimeAble(String DepartFrom, String ArriveAt, String DepartTime, String ArriveTime) {
        WebDriverManage.getInstance().ScrollTo(this.getTdTimeAble(DepartFrom, ArriveAt, DepartTime, ArriveTime));
        this.getTdTimeAble(DepartFrom, ArriveAt, DepartTime, ArriveTime).click();
    }

}
