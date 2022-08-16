package com.demoqa.components;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.data.Data;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    SelenideElement openCalendar = $("#dateOfBirthInput"),
                    month = $(".react-datepicker__month-select"),
                    year = $(".react-datepicker__year-select"),
                    day = $(".react-datepicker__day--0" + Data.getDay() +":not(.react-datepicker__day--outside-month)");


    public  CalendarComponent setDate(){
        openCalendar.click();
        month.selectOption(Data.getMonth());
        year.selectOptionByValue(Data.getYear());
        day.click();

        return this;
    }
}
