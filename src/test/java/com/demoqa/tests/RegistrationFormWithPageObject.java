package com.demoqa.tests;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObject extends BaseTest {

    RegistrationFormPage regFormPage = new RegistrationFormPage();


    @Test
    public void fillFormRegistration(){
        regFormPage.openPage()
                .fillForm()
                .checkOnValues();
    }
}
