package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By menu = By.xpath("//i[text()='menu']");
    private By navBar = By.cssSelector(".dot-nav > li");
    private By searchOption = By.xpath("//a[text()='Search']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage goToSearchPage(){
        driver.findElement(menu).click();
        driver.findElements(navBar).get(3).click();
        driver.findElement(searchOption).click();
        return new SearchPage(driver);
    }
}
