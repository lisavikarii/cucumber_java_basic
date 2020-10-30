package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^Navigate to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) throws Throwable {
        driver.get(url);

    }

    @When("^I enter number : \"([^\"]*)\"$")
    public void iEnterNumber(String arg0) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(arg0);
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String arg0) throws Throwable {
        assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());

    }

    @When("^I enter a correct number : \"([^\"]*)\"$")
    public void iEnterACorrectNumber(String correctNumber) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(correctNumber));

    }


    @Then("^I see alert message: \"([^\"]*)\"$")
    public void iSeeAlertMessage(String arg0) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 66 is 8.12", alert.getText());
        alert.accept();
    }


    @Given("^Navigate to People with jobs url \"([^\"]*)\"$")
    public void navigateToPeopleWithJobsUrl(String url) throws Throwable {
       driver.get(url);
    }

    @When("^I click add Person button$")
    public void iClickAddPersonButton() {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I fill in name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void iFillInNameAndJob(String name, String job) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("job")).sendKeys(job);

    }

    @And("^I click Add button$")
    public void iClickAddButton(){
        driver.findElement(By.id("modal_button")).click();

    }

    @Then("^I check that new person appeared in the list$")
    public void iCheckThatNewPersonAppearedInTheList() {
        assertEquals("Lisa",driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]")).getText());
        assertEquals("QA",driver.findElement(By.xpath("//*[@id=\"person3\"]/span[4]")).getText());
    }


    @And("^I click on first person pencil-editor$")
    public void iClickOnFirstPersonPencilEditor() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
        Thread.sleep(2000);
    }

    @And("^I change the name of first person to \"([^\"]*)\"$")
    public void iChangeTheNameOfFirstPersonTo(String arg0) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(arg0);

    }

    @And("^I change the job of first person to \"([^\"]*)\"$")
    public void iChangeTheJobOfFirstPersonTo(String arg0) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(arg0);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() {
        driver.findElement(By.id("modal_button")).click();
    }


    @Then("^I check that the list contains a person with changed credentials$")
    public void iCheckThatTheListContainsAPersonWithChangedCredentials() throws Throwable {
        assertEquals("Michael",driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals("Student",driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText());
        Thread.sleep(2000);
    }

    @And("^I click on second person remove sign$")
    public void iClickOnSecondPersonRemoveSign() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person1\"]/span[1]")).click();
        Thread.sleep(3000);
    }

    @Then("^I check that removed person is not in updated list$")
    public void iCheckThatRemovedPersonIsNotInUpdatedList() {
        assertNotEquals("Jill",driver.findElement(By.xpath("//*[@id=\"person2\"]/span[3]")).getText());
        assertNotEquals("Support",driver.findElement(By.xpath("//*[@id=\"person2\"]/span[4]")).getText());
    }

    @And("^I click to reset the list$")
    public void iClickToResetTheList() throws Throwable {
        driver.findElement(By.xpath("//*[contains(@onclick, 'resetListOfPeople()')]")).click();

    }


    @Then("^I check that list looks like before changes$")
    public void iCheckThatListLooksLikeBeforeChanges() {
        assertNotEquals("Lisa",driver.findElement(By.xpath("//*[@id=\"person2\"]/span[3]")).getText());
        assertNotEquals("QA",driver.findElement(By.xpath("//*[@id=\"person2\"]/span[4]")).getText());
    }

    @Then("^I check that list doesn't has edited person$")
    public void iCheckThatListDoesnTHasEditedPerson()throws Throwable {
        assertNotEquals("Michael", driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertNotEquals("Student",driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText());
        Thread.sleep(2000);
    }


    @Then("^I check that list became original$")
    public void iCheckThatListBecameOriginal() {
        assertEquals("Jill",driver.findElement(By.xpath("//*[@id=\"person1\"]/span[3]")).getText());
        assertEquals("Support",driver.findElement(By.xpath("//*[@id=\"person1\"]/span[4]")).getText());
    }

    @And("^I click clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
        Thread.sleep(2000);
    }

    @Then("^I check that all fields are empty$")
    public void iCheckThatAllFieldsAreEmpty() {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());
    }
}



