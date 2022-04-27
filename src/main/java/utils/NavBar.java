package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SearchPage;

public class NavBar {

    private WebDriver driver;
    private WebElement element;
    private By contentSearch = By.xpath("//a[text()='Search']");

    public NavBar(WebDriver driver, WebElement element){
        this.driver = driver;
        this.element = element;
    }

    public SearchPage clickContentSearch(){
        clickLink(contentSearch);
        return new SearchPage(driver);
    }

    private void clickLink(By link){
        driver.findElement(link).click();
    }
}
