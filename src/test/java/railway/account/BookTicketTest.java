package railway.account;

import constant.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.railway.*;
import railway.TestBase;

public class BookTicketTest extends TestBase {

    HomePage homePage = HomePage.getNewInstance();
    GeneralPage generalPage = GeneralPage.getNewInstance();
    LoginPage loginPage = LoginPage.getNewInstance();
    BookTicketPage bookTicketPage = BookTicketPage.getNewInstance();
    TimeAblePage timeAblePage = TimeAblePage.getNewInstance();
    MyTicketPage myTicketPage = MyTicketPage.getNewInstance();

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
    public void TC014(){
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.VALID_PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        Assert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(),Constant.BOOK_TICKET_SUCCESS_MESSAGE);
        Assert.assertEquals(bookTicketPage.getCellTableBookTicket(1).getText(),Constant.DEPART_FROM);
        Assert.assertEquals(bookTicketPage.getCellTableBookTicket(2).getText(),Constant.ARRIVE_AT);
        Assert.assertEquals(bookTicketPage.getCellTableBookTicket(3).getText(),Constant.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.getCellTableBookTicket(4).getText(),Constant.DEPART_DATE);
        Assert.assertEquals(bookTicketPage.getCellTableBookTicket(7).getText(),Constant.TICKET_AMOUNT);
    }

    @Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC015(){
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.VALID_PASSWORD);
        homePage.gotoTimeAblePage();
        timeAblePage.BookTicketFromTimeAble(Constant.DEPART_FROM_TIME_ABLE,Constant.ARRIVE_AT_TIME_ABLE,Constant.DEPART_TIME,Constant.ARRIVE_TIME);
        Assert.assertEquals(bookTicketPage.getComboboxDepartFrom().getFirstSelectedOption().getText(),Constant.DEPART_FROM_TIME_ABLE);
        Assert.assertEquals(bookTicketPage.getComboboxArriveAt().getFirstSelectedOption().getText(),Constant.ARRIVE_AT_TIME_ABLE);
    }

    @Test(description = "User can cancel a ticket")
    public void TC016(){
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME,Constant.VALID_PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.BookTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        homePage.goToMyTicketPage();
        myTicketPage.cancelTicket(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);
        Assert.assertEquals(myTicketPage.CancelTicketDisappeared(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT),false);
    }

}
