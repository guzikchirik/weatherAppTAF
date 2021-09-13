package com.weatherapp.mobilelayer.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AbstractMobilePage {

    protected AbstractMobilePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
