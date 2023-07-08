package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddLanguagePage extends CommonMethods {

    @FindBy(id= "language_name")
    public WebElement languageNameTextBox;

    @FindBy (id = "menu_admin_viewAdminModule")
    public WebElement adminBtn;

    @FindBy (id = "menu_admin_Qualifications")
    public WebElement ddnQual;

    @FindBy(id = "menu_admin_viewLanguages")
    public WebElement languages;

    @FindBy(id="btnAdd")
    public WebElement addBtn;

    @FindBy(id="btnSave")
    public WebElement saveNameBtn;

    public AddLanguagePage(){
        PageFactory.initElements(driver, this);
    }
}

