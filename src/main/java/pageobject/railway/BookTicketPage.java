package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private String comboboxDepartDate = "Date";
    private String comboboxDepartFrom = "DepartStation";
    private String comboboxArriveAt = "ArriveStation";
    private String comboboxSeatType = "SeatType";
    private String comboboxTicketAmount = "TicketAmount";
    private String btnBookTicket = "//div[@id='content']//form//input[@type='submit']";
    private String lblBookTicketSuccess = "//div[@id='content']//h1";
    private String tdAfterBookTicket = "//div[@id='content']//table//tr[@class='OddRow']//td[%d]";
    private static BookTicketPage bookTicketPage = null;

    public static BookTicketPage getNewInstance(){
        bookTicketPage = new BookTicketPage();
        return bookTicketPage;
    }

    public String getCellTextTableBookTicket(int position){
        String tdAfterBookTicketFormat = String.format(tdAfterBookTicket,position);
        return WebDriverManage.getInstance().findElementByXpath(tdAfterBookTicketFormat).getText();
    }

    private WebElement getLblBookTicketSuccess(){
        return WebDriverManage.getInstance().findElementByXpath(lblBookTicketSuccess);
    }

    private Select getComboboxDepartDate(){
        Select comboboxDepartDate = new Select(WebDriverManage.getInstance().findElementByName(this.comboboxDepartDate));
        return comboboxDepartDate;
    }

    private Select getComboboxDepartFrom(){
        Select comboboxDepartFrom = new Select(WebDriverManage.getInstance().findElementByName(this.comboboxDepartFrom));
        return comboboxDepartFrom;
    }

    private Select getComboboxArriveAt(){
        Select comboboxArriveAt = new Select(WebDriverManage.getInstance().findElementByName(this.comboboxArriveAt));
        return comboboxArriveAt;
    }

    private Select getComboboxSeatType(){
        Select comboboxSeatType = new Select(WebDriverManage.getInstance().findElementByName(this.comboboxSeatType));
        return comboboxSeatType;
    }

    private Select getComboboxTicketAmount(){
        Select comboboxTicketAmount = new Select(WebDriverManage.getInstance().findElementByName(this.comboboxTicketAmount));
        return comboboxTicketAmount;
    }

    public String getDepartFromSelectText(){
        return this.getComboboxDepartFrom().getFirstSelectedOption().getText();
    }

    public String getArriveAtSelectText(){
        return this.getComboboxArriveAt().getFirstSelectedOption().getText();
    }

    public WebElement getBtnBookTicket(){
        return WebDriverManage.getInstance().findElementByXpath(btnBookTicket);
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
