package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonaPage {
    private WebDriver driver;
    private By plusButton = By.xpath("//div[@class='portlet-toolbar__actions-primary']");
    private By addNewContent = By.xpath("//td[text()='Add New Content']");
    private By frame1 = By.cssSelector("#detailFrame");
    private By formSaveButton = By.xpath("//div[@class='content-edit-actions']/a[1]");
    private By nameRequiredError = By.xpath("//li[text()='The field Name is required.']");
    private By formNameBox = By.cssSelector("#name");
    private By successfullySaveMessage = By.cssSelector(".systemMessages");
    private By modalCloseButton = By.xpath("//span[text()='Close']");
    private By closeFormButton = By.xpath("//i[text()='close']");
    private By closeFormModalButton = By.xpath("//button/span[text()='Close']");
    private By profileButton = By.xpath("//dot-avatar");
    private By logOutLink = By.xpath("//li/a[text()='Logout']");

    public PersonaPage(WebDriver driver){
        this.driver = driver;
    }

    public void openForm(){
        driver.findElement(plusButton).click();
        driver.findElement(addNewContent).click();
        driver.switchTo().parentFrame();
    }

    public void toInteractWithForm(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(frame1));
        {
            driver.switchTo().frame(driver.findElements(frame1).get(0));
        }
    }

    public void setName(String name){
        driver.findElement(formNameBox).clear();
        driver.findElement(formNameBox).sendKeys(name);
    }

    public void clickSaveButton(){
        driver.findElement(formSaveButton).click();
    }

    public void logOut(){
        driver.findElement(profileButton).click();
        driver.findElement(logOutLink).click();
    }

    public void closeForm(){
        driver.findElement(modalCloseButton).click();
        driver.switchTo().parentFrame();
        driver.findElement(closeFormButton).click();
//        driver.findElement(closeFormModalButton).click();
    }



    public String getNameRequiredError(){
        return driver.findElement(nameRequiredError).getText();
    }

    public String getContentSavedMessage(){
        return driver.findElement(successfullySaveMessage).getText();
    }
}
