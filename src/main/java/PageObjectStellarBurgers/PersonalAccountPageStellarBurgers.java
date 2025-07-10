package PageObjectStellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPageStellarBurgers {

    private WebDriver driver;

    private By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    private By stellarBurgersLogo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");
    private By exitButton = By.xpath(".//button[text() = 'Выход']");

    public PersonalAccountPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickStellarBurgersLogo(){
        driver.findElement(stellarBurgersLogo).click();
    }
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
    public void checkExitButton(){
        driver.findElement(exitButton);
    }
}