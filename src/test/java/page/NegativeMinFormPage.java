package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NegativeMinFormPage {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement genderMale = $("label[for='gender-radio-1']");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement phoneNumberField = $("#userNumber");

    public NegativeMinFormPage openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public NegativeMinFormPage removeAds() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }

    public NegativeMinFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public NegativeMinFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public NegativeMinFormPage setGender() {
        genderMale.click();
        return this;
    }

    public NegativeMinFormPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public NegativeMinFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public NegativeMinFormPage verifyPhoneFieldValidationError() {
        phoneNumberField.shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));

        return this;
    }

}