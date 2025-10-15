package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Навигация по категориям
    public void navigateToCategory(String category) {
        $$(".list-group-item").findBy(text(category)).click();
    }

    // Элементы для логина
    public SelenideElement loginLink = $("#login2");
    public SelenideElement loginModal = $("#logInModal");
    public SelenideElement usernameInput = $("#loginusername");
    public SelenideElement passwordInput = $("#loginpassword");
    public SelenideElement loginButton = $("#logInModal .btn-primary");

    // Элементы продуктов
    public void clickProductByName(String productName) {
        $$(".card-title a").findBy(text(productName)).click();
    }

    public SelenideElement productPrice = $(".price-container");
    public SelenideElement productName = $(".name");

    // Элементы после логина
    public SelenideElement welcomeMessage = $("#nameofuser");

    // Заголовок категории
    public SelenideElement categoryTitle = $(".h-100");
}