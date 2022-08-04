package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingForm {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void checkForm() {

        open("/automation-practice-form");
        $("#firstName").setValue("Егор");
        $("#lastName").setValue("Варламов");
        $("#userEmail").setValue("varlamovE@ya.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9100000101");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("En").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("#currentAddress").setValue("г. Москва, ул. новый Арбат 1");
        $("#uploadPicture").uploadFile(new File("src/test/resources/qa.png"));
        $("#react-select-3-input").scrollTo().setValue("NC").pressEnter();
        $("#react-select-4-input").setValue("Gu").pressEnter();
        $("#submit").scrollIntoView(false).pressEnter();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Егор Варламов"),
                text("varlamovE@ya.ru"),
                text("Male"),
                text("9100000101"),
                text("10 May,1990"),
                text("English"),
                text("Reading"),
                text("qa.png"),
                text("г. Москва, ул. новый Арбат 1"),
                text("NCR Gurgaon"));

        $("#closeLargeModal").click();

    }
}
