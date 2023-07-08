package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddLanguage extends CommonMethods {

    @And("selects Qualifications and selects Languages")
    public void selects_Qualifications_and_selects_Languages() {

        Actions actions = new Actions(driver);
        actions.moveToElement(addLanguagePage.ddnQual);
        actions.moveToElement(addLanguagePage.languages);
        actions.click().build().perform();
    }
    @Then("user clicks on add language button and inserts valid {string}")
    public void user_clicks_on_add_language_button_and_inserts_valid(String language) {
        doClick(addLanguagePage.addBtn);
        sendText(addLanguagePage.languageNameTextBox, language);
    }
}