package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameBox = By.cssSelector("#inputtext");
    private By passwordBox = By.xpath("//input[@type='password']");
    private By signInButton = By.xpath("//span[text()='Sign In']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(userNameBox).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    public HomePage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }

}
