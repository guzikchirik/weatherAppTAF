package com.weatherapp.mobilelayer.pages;

import org.openqa.selenium.support.PageFactory;

import com.weatherapp.mobilelayer.driver.AppiumDriverManager;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DefaultMobilePage {

    protected DefaultMobilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverManager.getInstance()
                                                                             .getDriver()), this);
    }
}
