package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private By comboboxDepartDate = By.name("Date");
    private By comboboxDepartFrom = By.name("DepartStation") ;
    private By comboboxArriveAt =  By.name("ArriveStation");
    private By comboboxSeatType = By.name("SeatType");
    private By comboboxTicketAmount = By.name("TicketAmount");
    private By btnBookTicket = By.xpath("//div[@id='content']//form//input[@type='submit']");
    private By lblBookTicketSuccess = By.xpath("//div[@id='content']//h1[contains(.,'Booked Successfully')]");
    private String tdAfterBookTicket = "//div[@id='content']//table//tr[@class='OddRow']//td[%d]";
    private static BookTicketPage bookTicketPage = null;

    public String getCellTextTableBookTicket(int position){
        By tdAfterBookTicketFormat = By.xpath(String.format(tdAfterBookTicket,position));
        return WebDriverManage.getInstance().getDriver().findElement(tdAfterBookTicketFormat).getText();
    }

    private WebElement getLblBookTicketSuccess(){
        return WebDriverManage.getInstance().getDriver().findElement(lblBookTicketSuccess);
    }

    private Select getComboboxDepartDate(){
        Select comboboxDepartDate = new Select(WebDriverManage.getInstance().getDriver().findElement(this.comboboxDepartDate));
        return comboboxDepartDate;
    }

    private Select getComboboxDepartFrom(){
        Select comboboxDepartFrom = new Select(WebDriverManage.getInstance().getDriver().findElement(this.comboboxDepartFrom));
        return comboboxDepartFrom;
    }

    private Select getComboboxArriveAt(){
        Select comboboxArriveAt = new Select(WebDriverManage.getInstance().getDriver().findElement(this.comboboxArriveAt));
        return comboboxArriveAt;
    }

    private Select getComboboxSeatType(){
        Select comboboxSeatType = new Select(WebDriverManage.getInstance().getDriver().findElement(this.comboboxSeatType));
        return comboboxSeatType;
    }

    private Select getComboboxTicketAmount(){
        Select comboboxTicketAmount = new Select(WebDriverManage.getInstance().getDriver().findElement(this.comboboxTicketAmount));
        return comboboxTicketAmount;
    }

    public String getDepartFromSelectText(){
        return this.getComboboxDepartFrom().getFirstSelectedOption().getText();
    }

    public String getArriveAtSelectText(){
        return this.getComboboxArriveAt().getFirstSelectedOption().getText();
    }

    public WebElement getBtnBookTicket(){
        return WebDriverManage.getInstance().getDriver().findElement(btnBookTicket);
    }

    public String getBookTicketSuccessMessage(){
        return this.getLblBookTicketSuccess().getText();
    }

    public void BookTicket(String DepartDate,String DepartFrom,String ArriveAt,String SeatType,String TicketAmount){
        this.getComboboxDepartDate().selectByVisibleText(DepartDate);
        this.getComboboxDepartFrom().selectByVisibleText(DepartFrom);
        this.getComboboxArriveAt().selectByVisibleText(ArriveAt);
        this.getComboboxSeatType().selectByVisibleText(SeatType);
        this.getComboboxTicketAmount().selectByVisibleText(TicketAmount);
        WebDriverManage.getInstance().ScrollTo(this.getBtnBookTicket());
        this.getBtnBookTicket().click();
    }
}
