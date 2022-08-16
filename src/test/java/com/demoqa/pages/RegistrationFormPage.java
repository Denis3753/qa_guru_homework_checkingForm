package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;
import com.demoqa.components.CalendarComponent;
import com.demoqa.data.Data;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    /*
       * Locators
     */

    SelenideElement firstName = $("#firstName"),
                    lastName = $("#lastName"),
                    email = $("#userEmail"),
                    gender = $("#genterWrapper"),
                    phoneNumber = $("#userNumber"),
                    subject = $("#subjectsInput"),
                    hobbiesReading = $("[for=hobbies-checkbox-2]"),
                    picture = $("#uploadPicture"),
                    address = $("#currentAddress"),
                    state = $("#react-select-3-input"),
                    city = $("#react-select-4-input"),
                    submit = $("#submit");


    /*
        * Actions
     */


    //Открытие страницы
    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }



    public ResultFormPage fillForm(){

        firstName.setValue(Data.getFirstName());
        lastName.setValue(Data.getLastName());
        email.setValue(Data.getEmail());
        gender.$(byText(Data.getGender())).click();
        phoneNumber.setValue(Data.getPhoneNumber());
        calendarComponent.setDate();
        subject.setValue(Data.getSubject()).pressEnter();
        hobbiesReading.click();
        picture.uploadFile(new File(Data.getPicture()));
        address.setValue(Data.getCurrentAddress());
        state.scrollTo().setValue(Data.getState()).pressEnter();
        city.setValue(Data.getCity()).pressEnter();
        submit.scrollIntoView(false).pressEnter();

        return new ResultFormPage();
    }

}
