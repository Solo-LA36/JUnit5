package tests.other;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class PracticeFormTest {


    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Ivanov");

        $("[id=userEmail]").setValue("AIvanov@mail.ru");

        $(byText("Male")).click();

        $("[id=userNumber]").setValue("9601390099");

        $("[id=dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1982");
        $$(".react-datepicker__day").findBy(text("25")).click();

        $("#subjectsInput").setValue("His");
        $$(".subjects-auto-complete__option").findBy(text("History")).click();
        $("#subjectsInput").setValue("Bio");
        $$(".subjects-auto-complete__option").findBy(text("Biology")).click();
        $("#subjectsInput").setValue("Math");
        $$(".subjects-auto-complete__option").findBy(text("Maths")).click();

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();


        $("[id=uploadPicture]").uploadFromClasspath("Photo.png");

        $("[id=currentAddress]")
                .scrollTo()
                .shouldBe(visible, enabled)
                .setValue("Russia, MSK");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").pressEnter();


        $(".table-responsive").shouldHave(text("Alex Ivanov"));
        $(".table-responsive").shouldHave(text("AIvanov@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9601390099"));
        $(".table-responsive").shouldHave(text("25 August,1982"));
        $(".table-responsive").shouldHave(text("History, Biology, Maths"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("Photo.png"));
        $(".table-responsive").shouldHave(text("Russia, MSK"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
