package PageObjectStellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPageStellarBurgers {

    private WebDriver driver;

    private By headLineSignInPage = By.xpath("//h2[text() = 'Вход']");
    private By emailField = By.xpath(".//input[@name = 'name']");
    private By passwordField = By.xpath(".//input[@name = 'Пароль']");
    private By signInButton = By.xpath(".//button[text() = 'Войти']");
    private By recoverPasswordButton = By.xpath(".//a[text() = 'Восстановить пароль']");

    public AuthorizationPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void checkHeadLineSignInPage(){
        driver.findElement(headLineSignInPage);
    }
    public void setEmail(){
        driver.findElement(emailField).sendKeys("OhoRom@yandex.ru");
    }
    public void setPassword(){
        driver.findElement(passwordField).sendKeys("Kerolain");
    }
    public void setIncorrectEmail(){
        driver.findElement(emailField).sendKeys("OhoRom@yandex.ruu");
    }
    public void setIncorrectPassword(){
        driver.findElement(passwordField).sendKeys("Kerolainn");
    }
    public void clickSingInButton(){
        driver.findElement(signInButton).click();
    }
}