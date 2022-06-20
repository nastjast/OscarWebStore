package com.telran.oscar.constants;

import com.telran.oscar.utils.PropertyReader;

public interface ITestConstants {

    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

    String URL = "http://selenium1py.pythonanywhere.com/en-gb/";
    String VALID_EMAIL = System.getenv().getOrDefault("email", PropertyReader.getProperty("valid.email"));
    String VALID_PASSWORD = System.getenv().getOrDefault("pass", PropertyReader.getProperty("valid.password"));
    String CHANGED_PASSWORD = System.getenv().getOrDefault("pass", PropertyReader.getProperty("changed.password"));
    String EXISTING_USER_MSG = "email address already exists";
    String REGISTRATION_MSG = "Thanks for registering";
    String DELETED_ACC_MSG = "Your profile has now been deleted";
    String PROFILE_UPDATED_MSG = "Profile updated";
    String LOGIN_MSG = "Welcome back";
    String REGISTRATION_EMAIL = "an" + i + "@gmail.com";
    String PASS_REGISTRATION = "qwerty!^&" + i;
    String USER_NAME = "Anna";
}
