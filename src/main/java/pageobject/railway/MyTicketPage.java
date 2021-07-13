package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.*;

public class MyTicketPage extends GeneralPage {
    String tdMyTicketTable = "//table[@class='MyTable']//tr[td='%s' and td='%s' and td='%s' and td='%s' and td='%s']//input";

    private WebElement getElementInMyTicketTable(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        By tdMyTicketTable = By.xpath(String.format(this.tdMyTicketTable, DepartDate, DepartFrom, ArriveAt, SeatType, Amount));
        return WebDriverManage.getDriver().findElement(tdMyTicketTable);
    }

    public void cancelTicket(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        WebDriverManage.ScrollTo(this.getElementInMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount));
        this.getElementInMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount).click();
        WebDriverManage.getDriver().switchTo().alert().accept();
    }

    public boolean CancelTicketDisappeared(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        try {
            getElementInMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount);
            return true;
        } catch (StaleElementReferenceException ignored) {
            return false;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }
}
