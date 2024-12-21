package au.com.carsguide.pages;

import au.com.carsguide.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchCarsPage extends Utility {

    private static final Logger log = LogManager.getLogger(SearchCarsPage.class.getName());

    public SearchCarsPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement headingText;

    @CacheLookup
    @FindBy(id = "make")
    WebElement makeDropDown;

//    @CacheLookup
//    @FindBy(id = "model")
    WebElement modelDropDown;

    @CacheLookup
    @FindBy(id = "state")
    WebElement locationDropDown;

    @CacheLookup
    @FindBy(id = "priceFrom")
    WebElement priceMin;

    @CacheLookup
    @FindBy(id = "priceTo")
    WebElement priceMax;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@id, 'SearchFormBtn')]")
    WebElement showUsedVehiclesBtn;

    public void verifyHeadingText(String expected) {
        String actual = headingText.getText().trim();
        boolean expectedResult = actual.contains(expected);
        log.info("Verifying heading text. '" + actual + "'");
        Assert.assertTrue(expectedResult);
    }

    public void selectMake(String make) {
        selectByVisibleTextFromDropDown(makeDropDown, make);
        log.info("select make: '" + make + "'");
    }

    public void selectModel(String model) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try{
            modelDropDown = driver.findElement(By.id("model"));
            modelDropDown.click();
            selectByVisibleTextFromDropDown(modelDropDown, model);
        }catch (StaleElementReferenceException e){
            selectByValueFromDropDown(modelDropDown, model);
        }
        log.info("select model: '" + model + "'");
    }

    public void selectLocation(String location) {
        selectByVisibleTextFromDropDown(locationDropDown, location);
        log.info("select location: '" + location + "'");
    }

    public void selectPriceMin(String priceTo) {
        selectByVisibleTextFromDropDown(priceMin, priceTo);
        log.info("select priceMin: '" + priceTo + "'");
    }

    public void selectPriceMax(String priceFrom) {
        selectByVisibleTextFromDropDown(priceMax, priceFrom);
        log.info("select priceMax: '" + priceFrom + "'");
    }

    public void clickOnFindMyNextCarButton() {
        clickOnElement(showUsedVehiclesBtn);
        log.info("clicking on Find my next car button. ");
    }

}
