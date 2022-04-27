package forms;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormTests extends BaseTests {


    /*When running both the test then comment the first "Login()" function line
    in testRequiredNameField() test*/
    @Test(description = "DotCMS_07 - Verify Name field is a required field when creating a new Persona from")
    public void testRequiredNameField() throws InterruptedException {
        var homePage = login("admin@dotcms.com", "admin");
        var searchPage = homePage.goToSearchPage();
        var personaPage = searchPage.setType("Persona");
        personaPage.openForm();
        personaPage.toInteractWithForm();
        personaPage.clickSaveButton();
        assertEquals(personaPage.getNameRequiredError(), "The field Name is required.", "Assertion Failed");
        personaPage.closeForm();
        personaPage.logOut();
    }

    @Test(description = "DotCMS_16 - Verify that the form should be saved with valid data in Name and Key Tag field as it is a required field")
    public void testSuccessfullySaved() throws InterruptedException {
        var homePage = login("admin@dotcms.com", "admin");
        homePage.clickArrow();
        var searchPage = homePage.goToSearchPage();
        var personaPage = searchPage.setType("Persona");
        personaPage.openForm();
        personaPage.toInteractWithForm();
        personaPage.setName("Syed Ali1");
        personaPage.clickSaveButton();
        assertEquals(personaPage.getContentSavedMessage(), "Content saved", "This is an error");
    }
}
