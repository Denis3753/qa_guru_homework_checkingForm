package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.data.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class ResultFormPage {


    SelenideElement table = $(".table-responsive"),
                    modalHeader = $(".modal-header");

    public void checkOnValues(){
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        table.shouldHave(
                text(Data.getFirstName() + " " + Data.getLastName()),
                text(Data.getEmail()),
                text(Data.getGender()),
                text(Data.getPhoneNumber()),
                text(Data.getDay() +" " + Data.getMonth() + "," + Data.getYear()),
                text(Data.getSubject()),
                text(Data.getHobby()),
                text((Data.getPicture().split("/")[3])),
                text(Data.getCurrentAddress()),
                text(Data.getState() + " " + Data.getCity()));

    }
}
