package railway;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.BookTicketPage;
import pageobject.railway.MyTicketPage;
import pageobject.railway.TicketPricePage;

public class FinalTest extends TestBase {

    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.open();
    }

    @AfterMethod
    public void afterMethod() {
        if (generalPage.CheckTabLogoutExist()) {
            homePage.Logout();
        }
    }

    @Test(description = "User can book 1 ticket at a time")
    public void TC01() {
        homePage.goToLoginPage();
        loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_3);
        Assert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.BOOK_TICKET_SUCCESS_MESSAGE);
        Assert.assertTrue(bookTicketPage.checkInfomationAfterBookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_3));
    }

    @Test(description = "Manage ticket displays remaining available number of booking")
    public void TC02(){
        homePage.goToLoginPage();
        loginPage.login(Constant.VALID_USERNAME2, Constant.VALID_PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE1, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_1);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE2, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_1);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE3, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_1);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE4, Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_QUANG_NGAI, Constant.SEAT_TYPE_SOFT_BED, Constant.TICKET_AMOUNT_1);
        homePage.goToMyTicketPage();
        Assert.assertEquals(myTicketPage.getMessageNote(4,6),Constant.MESSAGE_NOTE);
    }

    @Test(description = "User can book ticket with known price")
    public void TC03(){
        homePage.goToLoginPage();
        loginPage.login(Constant.VALID_USERNAME3, Constant.VALID_PASSWORD);
        homePage.gotoTicketPricePage();
        ticketPricePage.bookTicketFromTicketPrice(Constant.DA_NANG_TO_HUE,Constant.SEAT_TYPE_HARD_SEAT);
        Assert.assertTrue(bookTicketPage.checkInfomationAfterBookTicketFromTicketPrice(Constant.DEPART_FROM_DA_NANG, Constant.ARRIVE_AT_HUE, Constant.SEAT_TYPE_HARD_SEAT));
    }
}
