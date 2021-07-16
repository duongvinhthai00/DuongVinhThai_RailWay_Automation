package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.*;

public class MyTicketPage extends GeneralPage {
    String tdMyTicketTable = "//table[@class='MyTable']//tr[td='%s' and td='%s' and td='%s' and td='%s' and td='%s']//input";
    private String lblMessageNote = "//div[@class='message']//li[text()='You currently book %d tickets, you can book %d more.']";

    private WebElement getElementInMyTicketTable(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String Amount) {
        By tdMyTicketTable = By.xpath(String.format(this.tdMyTicketTable, DepartDate, DepartFrom, ArriveAt, SeatType, Amount));
        return WebDriverManage.getDriver().findElement(tdMyTicketTable);
    }

    private WebElement getElementMessageNote(int number1,int number2){
        By lblMessageNote  = By.xpath(String.format(this.lblMessageNote,number1,number2));
        return WebDriverManage.getDriver().findElement(lblMessageNote);
    }

    public String getMessageNote(int number1,int number2){
        return this.getElementMessageNote(number1,number2).getText();
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
