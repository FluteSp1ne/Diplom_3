package testsclass;

import PageObjectStellarBurgers.AuthorizationPageStellarBurgers;
import PageObjectStellarBurgers.ConstructorPageStellarBurgers;
import PageObjectStellarBurgers.PersonalAccountPageStellarBurgers;
import dataclass.DriverFactory;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stepsclass.UserSteps;
import static org.junit.Assert.assertEquals;

public class FromPersonalAccountToConstructorTest {

    private DriverFactory factory;
    private String accessToken;

    @Before
    public void initDriver(){
        factory = new DriverFactory();
        factory.initDriver();
        WebDriver driver = factory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        UserSteps.createUser("OhoRom@yandex.ru", "Kerolain", "Edward");
        AuthorizationPageStellarBurgers objAuthorizationPage = new AuthorizationPageStellarBurgers(driver);
        objAuthorizationPage.checkHeadLineSignInPage();
        objAuthorizationPage.setEmail();
        objAuthorizationPage.setPassword();
        objAuthorizationPage.clickSingInButton();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.checkHeadLineConstructorPage();
        objConstructorPage.clickPersonalAccountButton();
    }

    @Test
    @Step("Переход из личного кабинета в конструктор по клику на Конструктор")
    public void fromPersonalAccountToConstructorTest(){
        WebDriver driver = factory.getDriver();
        PersonalAccountPageStellarBurgers objPersonalAccountPage = new PersonalAccountPageStellarBurgers(driver);
        objPersonalAccountPage.clickConstructorButton();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.checkHeadLineConstructorPage();
    }

    @Test
    @Step("Переход из личного кабинета в конструктор по клику на Лого")
    public void fromPersonalAccountToConstructorLogoTest(){
        WebDriver driver = factory.getDriver();
        PersonalAccountPageStellarBurgers objPersonalAccountPage = new PersonalAccountPageStellarBurgers(driver);
        objPersonalAccountPage.clickStellarBurgersLogo();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.checkHeadLineConstructorPage();
    }

    @After
    public void deleteAccount() {
        accessToken = UserSteps.loginUser("OhoRom@yandex.ru", "Kerolain");

        if (accessToken != null) {
            Response response = UserSteps.deleteUser(accessToken);
            assertEquals(202, response.statusCode());
        }
    }

    @After
    public void tearDown(){
        factory.getDriver().quit();
    }
}