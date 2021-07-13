package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeAblePage extends GeneralPage {
    String tdTableTimeAble = "//tr[td='%s' and td = '%s' and td='%s' and td='%s']//a[text()='book ticket']";

    private WebElement getElementInTableTimeAble(String DepartFrom, String ArriveAt, String DepartTime, String ArriveTime) {
        By tdTableTimeAble = By.xpath(String.format(this.tdTableTimeAble, DepartFrom, ArriveAt, DepartTime, ArriveTime));
        return WebDriverManage.getDriver().findElement(tdTableTimeAble);
    }

    public void BookTicketFromTimeAble(String DepartFrom, String ArriveAt, String DepartTime, String ArriveTime) {
        WebDriverManage.ScrollTo(this.getElementInTableTimeAble(DepartFrom, ArriveAt, DepartTime, ArriveTime));
        this.getElementInTableTimeAble(DepartFrom, ArriveAt, DepartTime, ArriveTime).click();
    }

}
