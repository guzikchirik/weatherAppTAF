package com.weatherapp.mobilelayer.driver;

import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.weatherapp.mobilelayer.command.CommandExecutor;

import io.appium.java_client.AppiumDriver;

public class AppiumDriverManager {
    private static AppiumDriverManager instance = null;
    private IAppiumDriverCreator driverCreator;
    private AppiumDriver appiumDriver;

    public static AppiumDriverManager getInstance() {
        if (instance == null) {
            instance = new AppiumDriverManager();
        }
        return instance;
    }

    public AppiumDriver createDriver() {
        driverCreator = new AppiumDriverCreator();
        appiumDriver = driverCreator.createDriver();
        return appiumDriver;
    }

    public AppiumDriver getDriver() {
        return this.appiumDriver;
    }

    public void closeDriver() {
        driverCreator.stopAppiumServer();
    }
}
