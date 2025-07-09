package PageObjectStellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPageStellarBurgers {

    private WebDriver driver;

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By bunTabButton = By.xpath(".//span[text() = 'Булки']");
    private By sauceTabButton = By.xpath(".//span[text() = 'Соусы']");
    private By fillingsTabButton = By.xpath(".//span[text() = 'Начинки']");
    private By bunIngredients = By.xpath(".//div/ul[1]");
    private By sauceIngredients = By.xpath(".//div/ul[2]");
    private By fillingsIngredients = By.xpath(".//div/ul[3]");
    private By headLineConstructorPage = By.xpath(".//h1[text() ='Соберите бургер']");

    public ConstructorPageStellarBurgers(WebDriver driver){
        this.driver = driver;
    }

    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    public void clickBunTabButton(){
        driver.findElement(bunTabButton).click();
    }
    public void clickSauceTabButton(){
        driver.findElement(sauceTabButton).click();
    }
    public void clickFillingsTabButton(){
        driver.findElement(fillingsTabButton).click();
    }
    public void checkBunList(){
        driver.findElement(bunIngredients);
    }
    public void checkSauceList(){
        driver.findElement(sauceIngredients);
    }
    public void checkFillingsList(){
        driver.findElement(fillingsIngredients);
    }
    public void checkHeadLineConstructorPage(){
        driver.findElement(headLineConstructorPage);
    }
}