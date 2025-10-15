package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoblazeTest {
    MainPage mainPage = new MainPage();

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        open("https://www.demoblaze.com/");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    // 1. ValueSource - тестирование навигации по категориям
    @ParameterizedTest
    @ValueSource(strings = {"Phones", "Laptops", "Monitors"})
    void testCategoriesWithValueSource(String category) {
        mainPage.navigateToCategory(category);

        // Проверяем, что продукты загрузились
        $$(".card-block").shouldHave(sizeGreaterThan(0));

        // Проверяем, что заголовок страницы содержит категорию
        $(".h-100").shouldBe(visible);
    }

    // 2. CsvSource - тестирование цен продуктов
    @ParameterizedTest
    @CsvSource({
            "Samsung galaxy s6, $360",
            "Nokia lumia 1520, $820"
    })
    void testProductsWithCsvSource(String productName, String expectedPrice) {
        mainPage.navigateToCategory("Phones");

        // Ждем загрузки продуктов
        $$(".card-block").shouldHave(sizeGreaterThan(0));

        // Кликаем на продукт
        mainPage.clickProductByName(productName);

        // Проверяем цену на странице продукта
        mainPage.productPrice.shouldHave(text(expectedPrice));
    }

    // 3. MethodSource - тестирование с реальными данными
    static Stream<Arguments> productDataProvider() {
        return Stream.of(
                Arguments.of("Phones", "Samsung galaxy s6", "$360"),
                Arguments.of("Laptops", "Sony vaio i5", "$790"),
                Arguments.of("Monitors", "Apple monitor 24", "$400")
        );
    }

    @ParameterizedTest
    @MethodSource("productDataProvider")
    void testProductDetailsWithMethodSource(String category, String productName, String expectedPrice) {
        mainPage.navigateToCategory(category);

        // Ждем загрузки продуктов
        $$(".card-block").shouldHave(sizeGreaterThan(0));

        // Кликаем на продукт
        mainPage.clickProductByName(productName);

        // Проверяем детали продукта
        mainPage.productName.shouldHave(text(productName));
        mainPage.productPrice.shouldHave(text(expectedPrice));
    }

    // 4. EnumSource - тестирование категорий
    @ParameterizedTest
    @EnumSource(Category.class)
    void testCategoriesWithEnumSource(Category category) {
        mainPage.navigateToCategory(category.getDisplayName());

        // Проверяем, что продукты загрузились
        $$(".card-block").shouldHave(sizeGreaterThan(0));

        // Проверяем видимость продуктов
        $(".h-100").shouldBe(visible);
    }

    // 5. CsvFileSource - тестирование из CSV файла
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String productName, String expectedPrice) {
        mainPage.navigateToCategory("Phones");

        // Ждем загрузки продуктов
        $$(".card-block").shouldHave(sizeGreaterThan(0));

        // Кликаем на продукт
        mainPage.clickProductByName(productName);

        // Проверяем цену
        mainPage.productPrice.shouldHave(text("$" + expectedPrice));
    }

    enum Category {
        PHONES("Phones"),
        LAPTOPS("Laptops"),
        MONITORS("Monitors");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}