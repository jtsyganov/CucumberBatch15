package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddMembership extends CommonMethods {
    @Then("user clicks on admin")
    public void user_clicks_on_admin() {
        doClick(addMembershipPage.adminBtn);
    }
    @And("selects Qualifications and selects Membership")
    public void selects_Qualifications_and_selects_Membership() {

        Actions actions = new Actions(driver);
        actions.moveToElement(addMembershipPage.ddnQual);
        actions.moveToElement(addMembershipPage.membership);
        actions.click().build().perform();
                    }
    @Then("user clicks on add button and inserts valid {string}")
    public void user_clicks_on_add_button_and_inserts_valid(String name) {
        doClick(addMembershipPage.addBtn);
        sendText(addMembershipPage.membershipNameTextBox, name);
    }
    @And("admin clicks on save button")
    public void admin_clicks_on_save_button(){
        doClick(addMembershipPage.saveNameBtn);
    }
}
