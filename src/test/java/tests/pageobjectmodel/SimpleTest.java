package tests.pageobjectmodel;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest extends TestBase {
    @Test
    void fullFormTest() {
        open("/text-box");



        $("#userName").setValue("Alex Ivanov");
        $("#userEmail").setValue("AIvanov@mail.ru");
        $("#currentAddress").setValue("Russia, MSK");
        $("#permanentAddress").setValue("Russia, MSK");

        $("#submit").pressEnter();
        $("#output").shouldHave(text("Alex Ivanov"), text("AIvanov@mail.ru"), text("Russia, MSK"), text("Russia, MSK"));

    }
}
