package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private By type = By.cssSelector("#structure_inode");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public PersonaPage setType() throws InterruptedException {

        Thread.sleep(30);
        driver.switchTo().frame("detailFrame");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(type));
        {
            driver.findElement(type).clear();
            driver.findElement(type).sendKeys("Persona" + Keys.ENTER);
            return new PersonaPage(driver);
        }
    }
}
