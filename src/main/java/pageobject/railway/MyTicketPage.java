package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    private String tdMyTicketTable = "//table[@class='MyTable']//tr[td='%s' and td='%s' and td='%s' and td='%s' and td='%s']//input";
    private static MyTicketPage myTicketPage = null;

    public static MyTicketPage getNewInstance() {
        myTicketPage = new MyTicketPage();
        return myTicketPage;
    }

    public WebElement getTdMyTicketTable(String DepartDate,String DepartFrom,String ArriveAt,String SeatType,String Amount) {
        String tdMyTicketTable = String.format(this.tdMyTicketTable, DepartDate, DepartFrom, ArriveAt, SeatType, Amount);
        return WebDriverManage.getInstance().findElementByXpath(tdMyTicketTable);
    }

    public void cancelTicket(String DepartDate,String DepartFrom,String ArriveAt,String SeatType,String Amount) {
        WebDriverManage.getInstance().ScrollTo(this.getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount));
        this.getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount).click();
        WebDriverManage.getInstance().getWebDriver().switchTo().alert().accept();
    }

    public boolean CancelTicketDisappeared(String DepartDate,String DepartFrom,String ArriveAt,String SeatType,String Amount){
        boolean present = false;
        try {
            getTdMyTicketTable(DepartFrom, ArriveAt, SeatType, DepartDate, Amount);
            present =true;
        }catch (StaleElementReferenceException e){
            present = false;
        }catch (NoSuchElementException e) {
            present = false;
        }
        return false;
    }
}
