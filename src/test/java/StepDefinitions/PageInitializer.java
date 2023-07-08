package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.AddLanguagePage;
import Pages.AddMembershipPage;
import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public static AddEmployeePage addEmployeePage;
    public static AddMembershipPage addMembershipPage;
    public static AddLanguagePage addLanguagePage;
    public static void initializePageObjects(){
        login=new LoginPage();
        addEmployeePage=new AddEmployeePage();
        addMembershipPage=new AddMembershipPage();
        addLanguagePage=new AddLanguagePage();
    }
}
