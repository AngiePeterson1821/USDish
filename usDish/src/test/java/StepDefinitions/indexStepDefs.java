package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import usDish.index;

public class indexStepDefs {
    WebDriver driver;
    Wait<WebDriver> wait;
    index Index = new index();

    @Given("Navigate the browser to: {string}")
    public void navigateTheBrowserTo(String arg0) {
        Index.navigate(arg0);
        System.out.println("This is our URL: " + arg0);
    }

    @After
    public void shutDownBrowser() {
        Index.driverCloses();
    }

    @When("I navigate to page I check header text")
    public void iNavigateToPageICheckHeaderText() {
        Index.getH1();

    }

    @Then("I check hero link url to verify it matches: {string}")
    public void iCheckHeroLinkUrlToVerifyItMatches(String arg0) {
        Index.clickHeroLink(arg0);
    }

//    @Then("I check galentines link and verify it matches: {string}")
//    public void iCheckGalentinesLinkAndVerifyItMatches(String arg0) throws InterruptedException {
//        Index.galentinesLink(arg0);
//    }

    @Then("I check free installation link and verify it matches: {string}")
    public void iCheckFreeInstallationLinkAndVerifyItMatches(String arg0) throws InterruptedException {
        Index.installLink(arg0);
    }

    @Then("I wait for page load")
    public void iWaitForPageLoad() {
        Index.waitForPageLoad();
    }

    @Then("I click galentines button")
    public void iClickGalentinesButton() throws InterruptedException {
        Index.galentinesLink();
    }

    @Then("I verify the url equals: {string}")
    public void iVerifyTheUrlEquals(String arg0) {
        Index.verifyGalentines(arg0);
    }
}
