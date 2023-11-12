package task3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillRegistrationForm() {
        open("/automation-practice-form");
        executeJavaScript("document.querySelector('footer').remove();");
        $("#firstName").setValue("Авасян");
        $("#lastName").setValue("Котосян");
        $("#userEmail").setValue("bestkotik@gmail.com");
        $x("//label[@class='custom-control-label']").click();
        $("#userNumber").setValue("8799999999");
        $("#dateOfBirthInput").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption("June");
        $x("//select[@class='react-datepicker__year-select']").selectOption("1987");
        $x("//div[@class='react-datepicker__week']/div[@aria-label='Choose Friday, June 5th, 1987']").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo_cat.jpg");
        $("#currentAddress").setValue("Молочный край, город Мяу, улица Пушистая дом 7");
        $x("//div[@class=' css-1wa3eu0-placeholder']").click();
        $(byText("Uttar Pradesh")).click();
        $x("//div[@class=' css-1wa3eu0-placeholder']").click();
        $(byText("Lucknow")).click();
        $("#submit").click();

    }
}
