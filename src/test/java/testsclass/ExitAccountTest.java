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

public class ExitAccountTest{
    DriverFactory factory;
    private String accessToken;

    @Before
    public void initDriver() {
        factory = new DriverFactory();
        factory.initDriver();
        WebDriver driver = factory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        UserSteps.createUser("OhoRom@yandex.ru", "Kerolain", "Edward");
    }

    @Test
    @Step("Выход по кнопке [Выйти]")
    public void exitAccountTest(){
        WebDriver driver = factory.getDriver();

        AuthorizationPageStellarBurgers objAuthorizationPage = new AuthorizationPageStellarBurgers(driver);
        objAuthorizationPage.checkHeadLineSignInPage();
        objAuthorizationPage.setEmail();
        objAuthorizationPage.setPassword();
        objAuthorizationPage.clickSingInButton();

        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.checkHeadLineConstructorPage();
        objConstructorPage.clickPersonalAccountButton();

        PersonalAccountPageStellarBurgers objPersonaAccountPage = new PersonalAccountPageStellarBurgers(driver);
        objPersonaAccountPage.clickExitButton();
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