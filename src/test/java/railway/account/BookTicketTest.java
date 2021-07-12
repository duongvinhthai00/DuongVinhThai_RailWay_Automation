package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.BookTicketPage;
import pageobject.railway.MyTicketPage;
import pageobject.railway.TimeAblePage;
import railway.TestBase;

public class BookTicketTest extends TestBase {

    BookTicketPage bookTicketPage = new BookTicketPage();
    TimeAblePage timeAblePage = new TimeAblePage();
    MyTicketPage myTicketPage = new MyTicketPage();

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
    public void TC014() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        Assert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.BOOK_TICKET_SUCCESS_MESSAGE);
        Assert.assertEquals(bookTicketPage.getCellTextTableBookTicket(1), Constant.DEPART_FROM);
        Assert.assertEquals(bookTicketPage.getCellTextTableBookTicket(2), Constant.ARRIVE_AT);
        Assert.assertEquals(bookTicketPage.getCellTextTableBookTicket(3), Constant.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.getCellTextTableBookTicket(4), Constant.DEPART_DATE);
        Assert.assertEquals(bookTicketPage.getCellTextTableBookTicket(7), Constant.TICKET_AMOUNT);
    }

    @Test(description = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void TC015() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
        homePage.gotoTimeAblePage();
        timeAblePage.BookTicketFromTimeAble(Constant.DEPART_FROM_TIME_ABLE, Constant.ARRIVE_AT_TIME_ABLE, Constant.DEPART_TIME, Constant.ARRIVE_TIME);
        Assert.assertEquals(bookTicketPage.getDepartFromSelectText(), Constant.DEPART_FROM_TIME_ABLE);
        Assert.assertEquals(bookTicketPage.getArriveAtSelectText(), Constant.ARRIVE_AT_TIME_ABLE);
    }

    @Test(description = "User can cancel a ticket")
    public void TC016() {
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.VALID_PASSWORD);
//        homePage.gotoBookTicketPage();
//        bookTicketPage.BookTicket(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        homePage.goToMyTicketPage();
        myTicketPage.cancelTicket(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        Assert.assertEquals(myTicketPage.CancelTicketDisappeared(Constant.DEPART_DATE, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT), false);
    }

}
