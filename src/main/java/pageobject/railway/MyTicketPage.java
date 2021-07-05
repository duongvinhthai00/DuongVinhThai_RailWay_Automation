package pageobject.railway;

import common.WebDriverManage;

public class MyTicketPage extends GeneralPage {
    private static MyTicketPage myTicketPage = null;

    public static MyTicketPage getInstance(){
        if(myTicketPage == null){
            myTicketPage = new MyTicketPage();
        }
        return myTicketPage;
    }


}
