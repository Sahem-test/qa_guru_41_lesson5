package guru.qa.homeWork;

import guru.qa.TestBase;
import guru.qa.pages.PracticeFormPages;
import org.junit.jupiter.api.Test;

import static guru.qa.testData.TestData.*;


public class PracticeFormTests extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();

    @Test
    void FillPracticeFormPositiveTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstNameInput(userName)
                .setLastNameInput(lastName)
                .setUserEmailInput(userEmail)
                .setGender()
                .setUserNumberInput(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbies()
                .uploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setStateAndCite(state, city)
                .submitForm()

                .modalWindowShouldBeVisible()
                .checkGreetingTextModalWindow()
                .checkResult("Student Name", userName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "1976-11-10")
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minimalRequiredFieldsPositiveTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstNameInput(userName)
                .setLastNameInput(lastName)
                .setGender()
                .setUserNumberInput(userNumber)
                .submitForm()

                .modalWindowShouldBeVisible()
                .checkGreetingTextModalWindow()
                .checkResult("Student Name", userName + " " + lastName)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", userNumber);
    }

    @Test
    void lessMinimalRequiredFieldsNegativeTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstNameInput(userName)
                .submitForm()

                .modalWindowShouldNotBeVisible();

    }

    @Test
    void lessMinimalSignPhoneNegativeTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstNameInput(userName)
                .setLastNameInput(lastName)
                .setGender()
                .setUserNumberInput(wrongNumber)
                .submitForm()

                .modalWindowShouldNotBeVisible();
    }

    @Test
    void EmptyFormTest() {
        practiceFormPages.openPage()
                .removeAds()
                .submitForm()

                .modalWindowShouldNotBeVisible()
                .requirementFillFormTest();

    }

}
