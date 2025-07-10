package testsclass;

import PageObjectStellarBurgers.AuthorizationPageStellarBurgers;
import PageObjectStellarBurgers.ConstructorPageStellarBurgers;
import dataclass.DriverFactory;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stepsclass.UserSteps;
import static org.junit.Assert.assertEquals;

public class LoginTest {

    DriverFactory factory;
    private String accessToken;
    private static final String EMAIL = "OhoRom@yandex.ru";
    private static final String PASSWORD = "Kerolain";
    private static final String NAME = "Edward";

    @Before
    public void initDriver() {
        factory = new DriverFactory();
        factory.initDriver();
        WebDriver driver = factory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        UserSteps.createUser(EMAIL, PASSWORD, NAME);
    }

    @Test
    @Step("Успешный вход")
    public void successfulLoginTest(){
        WebDriver driver = factory.getDriver();
        AuthorizationPageStellarBurgers objAuthorizationPage = new AuthorizationPageStellarBurgers(driver);
        objAuthorizationPage.setEmail();
        objAuthorizationPage.setPassword();
        objAuthorizationPage.clickSingInButton();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.checkHeadLineConstructorPage();
    }

    @Test
    @Step("Вход с некорректным логином и паролем")
    public void incorrectLoginTest(){
        WebDriver driver = factory.getDriver();
        AuthorizationPageStellarBurgers objAuthorizationPage = new AuthorizationPageStellarBurgers(driver);
        objAuthorizationPage.setIncorrectEmail();
        objAuthorizationPage.setIncorrectPassword();
        objAuthorizationPage.checkHeadLineSignInPage();
    }

    @After
    public void deleteAccount() {
        accessToken = UserSteps.loginUser(EMAIL, PASSWORD);

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