package tests.pageobjectmodel;

import org.junit.jupiter.api.Test;
import page.PracticeFormPages;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPages practiceFormPages = new PracticeFormPages();

    String username = "Alex";
    String lastName = "Ivanov";
    String email = "AIvanov@mail.ru";
    String gender = "Male";
    String mobileNumber = "9601390099";
    String[] birthday = new String[] {"25", "August", "1982"};
    String subjects = "Math";
    String hobbies = "Sports";
    String uploadFile = "Photo.png";
    String address = "Some address 1";
    String[] stateAndCity = new String[] {"NCR", "Delhi"};


    @Test
    void fillFormTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(username)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobileNumber)
                .setDateOfBirth(birthday[0], birthday[1], birthday[2])
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(uploadFile)
                .setAddress(address)
                .selectStateAndCity(stateAndCity[0], stateAndCity[1])
                .submitForm();

        practiceFormPages.verifyResultModalAppears()
                .verifyResult("Student Name", username + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobileNumber)
                .verifyResult("Date of Birth", birthday[0] + " " + birthday[1] + "," + birthday[2])
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", uploadFile)
                .verifyResult("Address", address)
                .verifyResult("State and City", stateAndCity[0] + " " + stateAndCity[1]);
    }
}
