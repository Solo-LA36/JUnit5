package page;

import com.codeborne.selenide.SelenideElement;
import page.components.TextBoxResultModal;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPages {

    TextBoxResultModal textBoxResultModal = new TextBoxResultModal();

    private SelenideElement
            userNameInput = $("#userName-wrapper #userName"),
            emailInput = $("#userEmail-wrapper #userEmail"),
            currentAddressInput = $("#currentAddress-wrapper #currentAddress"),
            permanentAddressInput = $("#permanentAddress-wrapper #permanentAddress"),
            submitTab = $("#submit");



    public TextBoxPages openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPages removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public TextBoxPages setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPages setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPages setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPages setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPages submitForm() {
        submitTab.click();

        return this;
    }

    public TextBoxPages verifyResult(String key, String value) {
        textBoxResultModal.verifyResult(key, value);

        return this;
    }

}
