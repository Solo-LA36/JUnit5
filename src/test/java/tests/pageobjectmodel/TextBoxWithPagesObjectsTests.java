package tests.pageobjectmodel;

import org.junit.jupiter.api.Test;
import page.TextBoxPages;

public class TextBoxWithPagesObjectsTests extends TestBase {
    TextBoxPages textBoxPages = new TextBoxPages();
    String userName = "Alex Ivanov";
    String email = "AIvanov@mail.ru";
    String currentAddress= "Russia, MSK";
    String permanentAddress= "Russia, MSK";

    @Test
    void successfulTextBoxTest() {
        textBoxPages.openPage()
                .removeAds()
                .setUserName(userName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(currentAddress)
                .submitForm();

        textBoxPages
                .verifyResult("Name:", userName)
                .verifyResult("Email:", email)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }
}
