package page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxResultModal {


    public void verifyResult(String key, String value) {
        SelenideElement outputData = $("#output");
        outputData.$(byText(key))
                .parent().shouldHave(text(value));
    }
}
