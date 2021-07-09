package constant;


import org.apache.commons.lang3.RandomStringUtils;

public class Constant {
    public static final String RAILWAY_URL="http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME="thai00458@gmail.com";
    public static final String VALID_PASSWORD="a01645901060";
    public static final String NEW_PASSWORD="a01645901060A";
    public static final String PATH_DRIVER_DIRECTION = "src\\main\\executables\\chromedriver.exe";
    public static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";
    public static final String WELCOME_MSG = "Welcome %s";
    public static final String INVALID_LOGIN_MSG = "There was a problem with your login and/or errors exist in your form.";
    public static final String INVALID_PASSWORD = "a123456789";
    public static final String INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static final String LOGIN_PAGE_NOT_EXIST = "Login Page Is Not Exist.";
    public static final String MSG_LOGIN_ERROR_SEVERAL_TIME = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static String EMAIL_RANDOM = "test+" + RandomStringUtils.randomAlphabetic(8)+ "@gmail.com";
    public static final String PID = "123456789";
    public static final String REGISTER_MESSAGE_SUCCESS = "Thank you for registering your account";
    public static final String CHANGE_PASSWORD_MESSAGE_SUCCESS = "Your password has been updated!";
    public static final String INVALID_CONFIRM_PASSWORD = "a1234568789";
    public static final String VALID_CONFIRM_PASSWORD = "a01645901060";
    public static final String EMPTY_PASSWORD = "";
    public static final String EMPTY_CONFIRM_PASSWORD = "";
    public static final String EMPTY_PID = "";
    public static final String PASSWORD_EMPTY_MESSAGE = "Invalid password length";
    public static final String PID_EMPTY_MESSAGE = "Invalid ID length";
    public static final String REGISTER_MESSAGE_FAILED = "There're errors in the form. Please correct the errors and try again.";
    public static final String DEPART_DATE = "7/20/2021";
    public static final String DEPART_FROM = "Sài Gòn";
    public static final String ARRIVE_AT = "Nha Trang";
    public static final String SEAT_TYPE = "Soft bed with air conditioner";
    public static final String TICKET_AMOUNT = "1";
    public static final String BOOK_TICKET_SUCCESS_MESSAGE = "Ticket Booked Successfully!";
    public static final String DEPART_FROM_TIME_ABLE = "Huế";
    public static final String ARRIVE_AT_TIME_ABLE = "Sài Gòn";
    public static final String DEPART_TIME = "7:30";
    public static final String ARRIVE_TIME = "21:00";


}
