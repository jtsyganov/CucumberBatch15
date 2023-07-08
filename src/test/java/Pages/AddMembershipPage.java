package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMembershipPage extends CommonMethods {

@FindBy(id= "membership_name")
public WebElement membershipNameTextBox;

@FindBy (id = "menu_admin_viewAdminModule")
public WebElement adminBtn;

@FindBy (id = "menu_admin_Qualifications")
public WebElement ddnQual;

@FindBy(id = "menu_admin_membership")
public WebElement membership;

@FindBy(id="btnAdd")
public WebElement addBtn;

@FindBy(id="btnSave")
public WebElement saveNameBtn;

    public AddMembershipPage(){
        PageFactory.initElements(driver, this);
    }
}
