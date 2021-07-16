package pageobject.railway;

import common.WebDriverManage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage {
    String linkCheckPriceDestination = "//td[li[text()='%s']]/following-sibling::td[a[text()='Check Price']]";
    String linkBookTicketFromTicketPrice = "//td[text()='%s']/following-sibling::td[a[text()='Book ticket']]";
    private final By btnBookTicket = By.xpath("//div[@id='content']//input[@value='Book ticket']");

    private WebElement getElementCheckPriceLink(String destination) {
        By linkCheckPriceDestination = By.xpath(String.format(this.linkCheckPriceDestination, destination));
        return WebDriverManage.getDriver().findElement(linkCheckPriceDestination);
    }

    private WebElement getElementBookTicketLink(String seatType) {
        By linkBookTicket = By.xpath(String.format(this.linkBookTicketFromTicketPrice, seatType));
        return WebDriverManage.getDriver().findElement(linkBookTicket);
    }

    private WebElement getElementBookTicketSubmit() {
        return WebDriverManage.getDriver().findElement(btnBookTicket);
    }

    public void bookTicketFromTicketPrice(String destination, String seatType) {
        WebDriverManage.ScrollTo(this.getElementCheckPriceLink(destination));
        this.getElementCheckPriceLink(destination).click();
        WebDriverManage.ScrollTo(this.getElementBookTicketLink(seatType));
        this.getElementBookTicketLink(seatType).click();
        WebDriverManage.ScrollTo(this.getElementBookTicketSubmit());
        this.getElementBookTicketSubmit().click();
    }

}
