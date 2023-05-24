package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.FastTrackRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FastTrackRegister extends Utility {
    
    FastTrackRegisterPage ftrp =  new FastTrackRegisterPage();

    @Then("I set cookie with {string} and {string}")
    public void iSetCookieWithAnd(String key, String value) {
        ftrp.setCookieWith(key, value);
    }

    @And("I fill candidate email field with random EmailId")
    public void userFillInWithCandidateEmailRandomly() {
        String emailText = generateRandomEmail();
        ftrp.fillEmailField(emailText);
    }

    @And("I fill candidate email with random EmailId")
    public void IFillCandidateEmailWithRandomEmailId() {
        String emailText = generateRandomEmail();
        ftrp.fillEmail(emailText);
    }

    @And("I Enters Firstname as {string}")
    public void iEntersFirstnameAs(String firstName) {
        ftrp.fillFirstName(firstName);
    }

    @And("I Enter field Firstname as {string}")
    public void userEntersFieldFirstnameAs(String firstName) {
        ftrp.fillFirstNameField(firstName);
    }

    @And("I Enter field Lastname as {string}")
    public void userEntersFieldLastnameAs(String firstName) {
        ftrp.fillLastNameField(firstName);
    }

    @And("I Enters Lastname as {string}")
    public void userEntersLastnameAs(String lastName) {
        ftrp.fillLastName(lastName);
    }

    @Then("I click on Apply now Link")
    public void iClickOnApplyNowLink() {
        ftrp.clickOnApplyButton();
    }

    @And("I Enters Password {string}")
    public void iEntersPassword(String password) {
        ftrp.enterPassword(password);
    }

    @And("I Enter field Password as {string}")
    public void userEntersFieldPasswordAs(String password) {
        ftrp.enterPasswordField(password);
    }

    @And("I Click on Job Title")
    public void userClickOnJobTitle() {
        ftrp.clickOnJobTitle();
    }

    @And("I Click on Link {string}")
    public void IClickOnLink(String arg0) {
        ftrp.clickOnApplyLink();
    }

    @Then("I click on More Link")
    public void iClickOnMoreLink() {
        ftrp.clickOnMoreLink();
    }

    @And("I switch tab")
    public void iSwitchTab() {
        ftrp.switchToNewTab();
    }
    @And("I switch tab2")
    public void iSwitchTab2() {
        ftrp.switchToNewTab2();
    }

    @And("I should see {string}")
    public void iShouldSee(String text) {
        ftrp.verifyTextP(text);
    }

    @And("I should see message {string}")
    public void iShouldSeeMessage(String text) {
        ftrp.verifyText(text);
    }

    @Then("I click on Button Apply now")
    public void iClickOnButtonApplyNow() {
        ftrp.clickOnApplyButton();
    }

    @When("I follow Login link")
    public void iFollowLoginLink() {
        ftrp.clickOnLoginLink();
    }

    @When("I Click on Create a jobseeker account link")
    public void iclickOnCreateAJobseekerAccount() {
        ftrp.clickOnJobSeeker();
    }

    @And("I Click on Link Register & Apply")
    public void iClickOnLinkRegisterApply() {
        ftrp.clickOnApplyNow();
    }

    @And("I follow {string} Link")
    public void iFollowLink(String id) {
        clickOnId(id);
    }

    @And("I fill acme candidate email with random EmailId")
    public void iFillAcmeCandidateEmailWithRandomEmailId() {
        String emailText = generateRandomEmail();
        ftrp.fillACMEEmail(emailText);
    }

    @And("I Enter acme Firstname as {string}")
    public void iEnterAcmeFirstnameAs(String firstName) {
        ftrp.fillACMEFirstName(firstName);
    }

    @And("I Enter acme Lastname as {string}")
    public void iEnterAcmeLastnameAs(String lastname) {
        ftrp.fillACMELastName(lastname);
    }

    @And("I Enter acme Password as {string}")
    public void iEnterAcmePasswordAs(String password) {
        ftrp.fillACMEPassword(password);
    }

    @And("I fill in the field where id is {string} with: {string}")
    public void iFillInTheFieldWhereIdIsWith(String id, String text) {
        fillFieldUsingIdAndText(id, text);
    }

    @And("I press and wait {string}")
    public void iPressAndWait(String id) {
       clickOnId(id);
       waitFor(2);
    }

    @Then("I follow link containing text {string}")
    public void iFollowLinkContangText(String arg0) {
        ftrp.clickOnMoreLink();
    }

    @When("I follow link Login")
    public void iFollowLinkLogin() {
        ftrp.clickOnLoginLink();
    }

    @And("I Click on Link Register & Quick Apply")
    public void iClickOnLinkRegisterQuickApply() {
        ftrp.clickOnApplyNow();
    }

    @When("I fill candidate email {string}")
    public void iFillCandidateEmail(String email) {
        ftrp.fillEmailField(email);
    }
}
