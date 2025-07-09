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

public class GoToYourPersonalAccountTest {

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
    }

    @Test
    @Step("Переход в личный кабинет")
    public void goToPersonalAccountTest(){
        WebDriver driver = factory.getDriver();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickPersonalAccountButton();
        PersonalAccountPageStellarBurgers objAccountPage = new PersonalAccountPageStellarBurgers(driver);
        objAccountPage.checkExitButton();
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