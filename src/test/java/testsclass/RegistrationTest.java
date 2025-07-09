package testsclass;

import PageObjectStellarBurgers.AuthorizationPageStellarBurgers;
import PageObjectStellarBurgers.RegistrationPageStellarBurgers;
import dataclass.DriverFactory;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepsclass.UserSteps;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    DriverFactory factory;
    private String accessToken;
    public boolean registrationUser;

    @Before
    public void initDriver() {
        factory = new DriverFactory();
        factory.initDriver();
        WebDriver driver = factory.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @Step("Успешная регистрация")
    public void successfulRegistrationTest() {
        WebDriver driver = factory.getDriver();
        RegistrationPageStellarBurgers objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(objRegistrationPage.headLineRegistrationPage)));
        objRegistrationPage.setName();
        objRegistrationPage.setEmail();
        objRegistrationPage.setPassword();
        objRegistrationPage.clickRegistrationButton();
        AuthorizationPageStellarBurgers objAuthorizationPage = new AuthorizationPageStellarBurgers(driver);
        objAuthorizationPage.checkHeadLineSignInPage();
        registrationUser = true;
    }

    @Test
    @Step("Регистрация с некорректным паролем")
    public void failureRegistrationTest() {
        WebDriver driver = factory.getDriver();
        RegistrationPageStellarBurgers objRegistrationPage = new RegistrationPageStellarBurgers(driver);
        objRegistrationPage.setName();
        objRegistrationPage.setEmail();
        objRegistrationPage.setIncorrectPassword();
        objRegistrationPage.clickRegistrationButton();
        objRegistrationPage.checkIncorrectPasswordNotif();
        registrationUser = false;
    }

    @After
    public void deleteAccount() {
        if(registrationUser) {
            accessToken = UserSteps.loginUser("OhoRom@yandex.ru", "Kerolain");

            if (accessToken != null) {
                Response response = UserSteps.deleteUser(accessToken);
                assertEquals(202, response.statusCode());
            }
        }
    }

    @After
    public void tearDown(){
        factory.getDriver().quit();
    }
}