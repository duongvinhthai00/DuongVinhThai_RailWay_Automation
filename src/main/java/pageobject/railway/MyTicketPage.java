package pageobject.railway;

public class MyTicketPage extends GeneralPage {
    private static MyTicketPage myTicketPage = null;

    public static MyTicketPage getNewInstance(){
        myTicketPage = new MyTicketPage();
        return myTicketPage;
    }


}
