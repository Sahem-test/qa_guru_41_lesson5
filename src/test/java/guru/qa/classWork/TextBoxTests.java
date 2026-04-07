package guru.qa.classWork;

import guru.qa.TestBase;
import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static guru.qa.testData.TestData.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    void successfulFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void submitWithMinimalDataTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .submitForm()
                .checkField("name", userName);
    }

}
