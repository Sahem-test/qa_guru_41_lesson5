package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class PracticeFormPages {

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement setGender = $("#gender-radio-1");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement openCalendar = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement setUserHobbies = $("#hobbies-checkbox-1");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement button = $("#submit");
    private SelenideElement modalWindow = $(".modal-dialog");
    private SelenideElement modalWindowText = $("#example-modal-sizes-title-lg");
    private SelenideElement formError = $("#formError");


    public PracticeFormPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPages removeAds() {
        executeJavaScript("document.getElementById('fixedban')?.remove();");
        executeJavaScript("document.querySelector('footer')?.remove();");
        return this;
    }

    public PracticeFormPages setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPages setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPages setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPages setGender() {
        setGender.click();
        return this;
    }

    public PracticeFormPages setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPages setDateOfBirth(String day, String month, String year) {
        openCalendar.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPages setHobbies() {
        setUserHobbies.click();
        return this;
    }

    public PracticeFormPages setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPages uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPages setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PracticeFormPages setStateAndCite(String state, String city) {
        stateSelect.click();
        stateCityContainer.$(byText(state)).click();
        citySelect.click();
        stateCityContainer.$(byText(city)).click();
        return this;
    }

    public PracticeFormPages submitForm() {
        button.click();
        return this;
    }

    public PracticeFormPages modalWindowShouldBeVisible() {
        modalWindow.shouldBe(visible);
        return this;
    }

    public PracticeFormPages modalWindowShouldNotBeVisible() {
        modalWindow.shouldNotBe(visible);
        return this;
    }

    public PracticeFormPages checkGreetingTextModalWindow() {
        modalWindowText.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public PracticeFormPages checkResult(String key, String value) {
        checkResultComponent.checkResult(key, value);
        return this;
    }

    public PracticeFormPages requirementFillFormTest() {
        formError.shouldHave(text(("Please fill required fields and enter a valid 10-digit mobile number.")));
        return this;
    }

}
