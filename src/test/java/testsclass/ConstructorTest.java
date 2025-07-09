package testsclass;

import PageObjectStellarBurgers.ConstructorPageStellarBurgers;
import dataclass.DriverFactory;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {

    private DriverFactory factory;

    @Before
    public void initDriver() {
        factory = new DriverFactory();
        factory.initDriver();
        WebDriver driver = factory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @Test
    @Step("Переходы к разделам конструктора")
    public void checkTabsButtonsTest(){
        WebDriver driver = factory.getDriver();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickSauceTabButton();
        objConstructorPage.checkSauceList();
        objConstructorPage.clickBunTabButton();
        objConstructorPage.checkBunList();
        objConstructorPage.clickFillingsTabButton();
        objConstructorPage.checkFillingsList();
    }

    @After
    public void tearDown(){
        factory.getDriver().quit();
    }
}