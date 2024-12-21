package au.com.carsguide.steps;

import au.com.carsguide.pages.HomePage;
import au.com.carsguide.pages.SearchCarsPage;
import au.com.carsguide.pages.SearchCarsResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCarsSteps {
    @When("I click {string} link")
    public void iClickLink(String subMenuItem) {
        new HomePage().selectFromSubMenu(subMenuItem);
    }

    @Then("I navigate to {string} page")
    public void iNavigateToPage(String expectedContains) {
        new SearchCarsPage().verifyHeadingText(expectedContains);
    }

    @And("I select make {string}")
    public void iSelectMake(String make) throws InterruptedException {
        new SearchCarsPage().selectMake(make);
        Thread.sleep(5000);
    }

    @And("I select model {string}")
    public void iSelectModel(String model) throws InterruptedException {
        new SearchCarsPage().selectModel(model);
    }

    @And("I select location {string}")
    public void iSelectLocation(String location) {
        new SearchCarsPage().selectLocation(location);
    }

    @And("I select min price {string}")
    public void iSelectMinPrice(String priceMin) {
        new SearchCarsPage().selectPriceMin(priceMin);
    }

    @And("I select max price {string}")
    public void iSelectMaxPrice(String priceMax) {
        new SearchCarsPage().selectPriceMax(priceMax);
    }

    @And("I click on Find My Next Car tab")
    public void iClickOnFindMyNextCarTab() throws InterruptedException {
        new SearchCarsPage().clickOnFindMyNextCarButton();
        Thread.sleep(5000);
    }


    @Then("I should see the make {string} in results")
    public void iShouldSeeTheMakeInResults(String make) {
        new SearchCarsResultPage().verifySearchFilter(make);
    }

}
