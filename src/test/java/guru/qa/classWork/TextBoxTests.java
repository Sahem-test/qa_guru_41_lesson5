package guru.qa.classWork;

import guru.qa.TestBase;
import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;
import static guru.qa.testData.TestData.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
    }

    @Test
    void successfulFillFormWithoutAddressTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
    }

    @Test
    void submitWithMinimalDataTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.submitForm();
        textBoxPage.checkField("name", userName);
    }

}
