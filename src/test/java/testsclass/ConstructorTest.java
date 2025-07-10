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
    @Step("Переход к разделу Соусы")
    public void checkTabSauceTest(){
        WebDriver driver = factory.getDriver();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickSauceTabButton();
        objConstructorPage.checkSauceList();
    }

    @Test
    @Step("Переход к разделу Булки")
    public void checkTabBunTest(){
        WebDriver driver = factory.getDriver();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickSauceTabButton();
        objConstructorPage.checkNotActiveBunList();
        objConstructorPage.clickBunTabButton();
        objConstructorPage.checkBunList();
    }

    @Test
    @Step("Переход к разделу Начинки")
    public void checkTabFillingTest(){
        WebDriver driver = factory.getDriver();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickFillingsTabButton();
        objConstructorPage.checkFillingsList();
    }

    @After
    public void tearDown(){
        factory.getDriver().quit();
    }
}