package com.demoqa.data;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;



import java.util.Locale;

public class Data {

  static Faker faker = new Faker(new Locale("ru"));

  private static String firstName = faker.name().firstName(),
                 lastName = faker.name().lastName(),
                 phoneNumber = faker.phoneNumber().subscriberNumber(10),
                 currentAddress = faker.address().fullAddress(),
                 gender = "Other",
                 subject = "English",
                 day = "30",
                 month = "May",
                 year = "1990",
                 hobby = "Reading",
                 picture = "src/test/resources/qa.png",
                 state = "NCR",
                 city = "Delhi";


  static FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

    private static String email = fakeValuesService.bothify("????##@ya.ru");


    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhoneNumber() {

        return phoneNumber;
    }

    public static String getGender(){
        return gender;
    }

    public static String getDay(){
        return day;
    }

    public static String getMonth(){
        return month;
    }

    public static String getYear(){
        return year;
    }

    public static String getHobby(){
        return hobby;
    }

    public static String getSubject(){
        return subject;
    }

    public static String getCurrentAddress(){
        return currentAddress;
    }

    public static String getPicture(){
        return picture;
    }

    public static String getState(){
        return state;
    }

    public static String getCity(){
        return city;
    }
}
