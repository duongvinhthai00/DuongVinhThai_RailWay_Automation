package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By comboboxDepartDate = By.name("Date");
    private final By comboboxDepartFrom = By.name("DepartStation");
    private final By comboboxArriveAt = By.name("ArriveStation");
    private final By comboboxSeatType = By.name("SeatType");
    private final By comboboxTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//div[@id='content']//input[@type='submit' and @value='Book ticket']");
    private final By lblBookTicketSuccess = By.xpath("//div[@id='content']//h1[contains(.,'Booked Successfully')]");
    String tdAfterBookTicket = "//tr[@class='OddRow' and td[text()='%s'] and td[text()='%s'] and td[text()='%s'] and td[text()='%s'] and td[text()='%s']]";
    String tdAfterBookTicket2 = "//tr[@class='OddRow' and td[text()='%s'] and td[text()='%s'] and td[text()='%s']]";

    public boolean checkInfomationAfterBookTicket(String departDate, String departStation, String arriveStation, String seatType, String amount) {
        By tdAfterBookTicketFormat = By.xpath(String.format(tdAfterBookTicket, departDate, departStation, arriveStation, seatType, amount));
        try {
            WebDriverManage.getDriver().findElement(tdAfterBookTicketFormat);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkInfomationAfterBookTicketFromTicketPrice(String departStation, String arriveStation, String seatType) {
        By tdAfterBookTicketFormat = By.xpath(String.format(tdAfterBookTicket2, departStation, arriveStation, seatType));
        try {
            WebDriverManage.getDriver().findElement(tdAfterBookTicketFormat);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    private WebElement getElementBookTicketSuccess() {
        return WebDriverManage.getDriver().findElement(lblBookTicketSuccess);
    }

    private Select getElementDepartDate() {
        return new Select(WebDriverManage.getDriver().findElement(this.comboboxDepartDate));
    }

    private Select getElementDepartFrom() {
        return new Select(WebDriverManage.getDriver().findElement(this.comboboxDepartFrom));
    }

    private Select getElementArriveAt() {
        return new Select(WebDriverManage.getDriver().findElement(this.comboboxArriveAt));
    }

    private Select getElementSeatType() {
        return new Select(WebDriverManage.getDriver().findElement(this.comboboxSeatType));
    }

    private Select getElementTicketAmount() {
        return new Select(WebDriverManage.getDriver().findElement(this.comboboxTicketAmount));
    }

    public String getDepartFromSelectText() {
        return this.getElementDepartFrom().getFirstSelectedOption().getText();
    }

    public String getArriveAtSelectText() {
        return this.getElementArriveAt().getFirstSelectedOption().getText();
    }

    public WebElement getElementBookTicketSubmit() {
        return WebDriverManage.getDriver().findElement(btnBookTicket);
    }

    public String getBookTicketSuccessMessage() {
        return this.getElementBookTicketSuccess().getText();
    }

    public void BookTicket(String DepartDate, String DepartFrom, String ArriveAt, String SeatType, String TicketAmount) {
        this.getElementDepartDate().selectByVisibleText(DepartDate);
        this.getElementDepartFrom().selectByVisibleText(DepartFrom);
        this.getElementArriveAt().selectByVisibleText(ArriveAt);
        this.getElementSeatType().selectByVisibleText(SeatType);
        this.getElementTicketAmount().selectByVisibleText(TicketAmount);
        WebDriverManage.ScrollTo(this.getElementBookTicketSubmit());
        this.getElementBookTicketSubmit().click();
    }
}
