package PageObjectStellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageStellarBurgers {

    private WebDriver driver;

    public By headLineRegistrationPage = By.xpath(".//h2[text() = 'Регистрация']");
    private By nameField = By.xpath(".//label[text() = 'Имя']");
    private By activeNameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailField = By.xpath(".//label[text() = 'Email']");
    private By activeEmailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordField = By.xpath(".//label[text() = 'Пароль']");
    private By activePasswordField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By singInButtonRegistrationPage = By.xpath(".//a[text() = 'Войти']");
    private By incorrectPasswordNotif = By.xpath(".//p[text() ='Некорректный пароль']");

    public RegistrationPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void setName(){
        driver.findElement(nameField).click();
        driver.findElement(activeNameField).sendKeys("Edward");
    }
    public void setEmail(){
        driver.findElement(emailField).click();
        driver.findElement(activeEmailField).sendKeys("OhoRom@yandex.ru");
    }
    public void setPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(activePasswordField).sendKeys("Kerolain");
    }
    public void setIncorrectPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(activePasswordField).sendKeys("Tessa");
    }
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    public void checkIncorrectPasswordNotif(){
        driver.findElement(incorrectPasswordNotif);
    }
}