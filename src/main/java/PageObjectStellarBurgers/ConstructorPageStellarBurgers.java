package PageObjectStellarBurgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstructorPageStellarBurgers {

    private WebDriver driver;

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By bunTabButton = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    private By sauceTabButton = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    private By fillingsTabButton = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
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
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(bunTabButton, "class", "current"));
    }
    public void checkNotActiveBunList(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.attributeContains(bunTabButton, "class", "current")));
    }
    public void checkSauceList(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(sauceTabButton, "class", "current"));
    }
    public void checkFillingsList(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(fillingsTabButton, "class", "current"));
    }
    public void checkHeadLineConstructorPage(){
        driver.findElement(headLineConstructorPage);
    }
}