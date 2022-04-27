package forms;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormTests extends BaseTests {


    /*When running both the test then comment the first "Login()" function line
    in testRequiredNameField() test*/
    @Test
    public void testRequiredNameField() throws InterruptedException {
        var homePage = login();
        var searchPage = homePage.goToSearchPage();
        var personaPage = searchPage.setType();
        personaPage.openForm();
        personaPage.toInteractWithForm();
        personaPage.clickSaveButton();
        assertEquals(personaPage.getNameRequiredError(), "The field Name is required.", "Assertion Failed");
    }

    @Test
    public void testSuccessfullySaved() throws InterruptedException {
        var homePage = login();
        var searchPage = homePage.goToSearchPage();
        var personaPage = searchPage.setType();
        personaPage.openForm();
        personaPage.toInteractWithForm();
        personaPage.setName("Syed Ali");
        personaPage.clickSaveButton();
        assertEquals(personaPage.getContentSavedMessage(), "Content saved", "This is an error");
    }
}
