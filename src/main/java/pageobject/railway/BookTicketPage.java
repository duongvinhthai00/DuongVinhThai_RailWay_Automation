package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By comboboxDepartDate = By.name("Date");
    private final By comboboxDepartFrom = By.name("DepartStation");
    private final By comboboxArriveAt = By.name("ArriveStation");
    private final By comboboxSeatType = By.name("SeatType");
    private final By comboboxTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//div[@id='content']//form//input[@type='submit']");
    private final By lblBookTicketSuccess = By.xpath("//div[@id='content']//h1[contains(.,'Booked Successfully')]");
    String tdAfterBookTicket = "//div[@id='content']//table//tr[@class='OddRow']//td[%d]";

    public String getCellTextTableBookTicket(int position) {
        By tdAfterBookTicketFormat = By.xpath(String.format(tdAfterBookTicket, position));
        return WebDriverManage.getDriver().findElement(tdAfterBookTicketFormat).getText();
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
