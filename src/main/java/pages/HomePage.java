package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.NavBar;

public class HomePage {
    private WebDriver driver;
    private By menu = By.xpath("//i[text()='menu']");
    private By navBar = By.cssSelector(".dot-nav > li");
    private By searchOption = By.xpath("//a[text()='Search']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param index start at 1
     */
    public NavBar hoverOverNavBar(int index){
        WebElement navBarElement = driver.findElements(navBar).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(navBarElement).perform();

        return new NavBar(driver, driver.findElement(By.xpath("//dot-sub-nav")));
    }

    public SearchPage goToSearchPage(){
        driver.findElement(menu).click();
        driver.findElements(navBar).get(3).click();
        driver.findElement(searchOption).click();
        return new SearchPage(driver);
    }
}
