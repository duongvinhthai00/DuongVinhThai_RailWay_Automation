package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.*;

public class MyTicketPage extends GeneralPage {
    private String tdMyTicketTable = "//table[@class='MyTable']//tr[td='%s' and td='%s' and td='%s' and td='%s' and td='%s']//input";
    private static MyTicketPage myTicketPage = null;

    private WebElement getTdMyTicketTable(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        By tdMyTicketTable = By.xpath(String.format(this.tdMyTicketTable, DepartDate, DepartFrom, ArriveAt, SeatType, Amount));
        return WebDriverManage.getInstance().getDriver().findElement(tdMyTicketTable);
    }

    public void cancelTicket(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        WebDriverManage.getInstance().ScrollTo(this.getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount));
        this.getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount).click();
        WebDriverManage.getInstance().getDriver().switchTo().alert().accept();
    }

    public boolean CancelTicketDisappeared(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        boolean present = false;
        try {
            getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount);
            present = true;
        } catch (StaleElementReferenceException e) {
            present = false;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return false;
    }
}
