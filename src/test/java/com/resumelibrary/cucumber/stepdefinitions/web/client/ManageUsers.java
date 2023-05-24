package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ManageUsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ManageUsers extends Utility {
    ManageUsersPage mup = new ManageUsersPage();

    @When("I click on manage users active action one")
    public void iClickOnManageUsersActiveActionOne() {
        mup.clickOnManageUsersActiveActionOne();
    }

    @And("I should see text Deactivate User {string}")
    public void iShouldSeeTextDeactivateUser(String text) {
        Assert.assertEquals(mup.verifyTextDeactivateUser(text), text);
    }

    @Then("I click to activate the inactive user from the list")
    public void iClickToActivateTheInactiveUserFromTheList() {
        mup.clickOnManageUsersInactiveAction();
    }

    @Then("I select {string} from from client")
    public void iSelectFromFromClient(String fromValue) {
        mup.selectFromClient(fromValue);
    }

    @And("I select {string} from to client")
    public void iSelectFromToClient(String toValue) {
        mup.selectToClient(toValue);
    }

    @And("I fill in amount with {string}")
    public void iFillInAmountWith(String amount) {
        mup.enterAmount(amount);
    }

    @And("I click on Transfer button")
    public void iClickOnTransferButton() {
        mup.clickOnTransferButton();
    }

    @When("I enter client email address to reset password")
    public void iEnterClientEmailAddressToResetPassword() {
        mup.enterEmailAddressToResetPassword();
    }

    @And("I should see button {string}")
    public void iShouldSeeButton(String text) {
        mup.verifyButton(text);
    }

    @And("I should see message {string} in the manage users xpath")
    public void iShouldSeeMessageInTheManageUsersXpath(String text) {
        mup.shouldSeeMessageInTheManageUsersXpath(text);
    }

    @When("I click on Add User button")
    public void iClickOnAddUserButton() {
        mup.clickOnAddUserBtn();
    }

    @And("I click on Edit User button")
    public void iClickOnEditUserButton() {
        mup.clickOnAddUserBtn();
    }
}
