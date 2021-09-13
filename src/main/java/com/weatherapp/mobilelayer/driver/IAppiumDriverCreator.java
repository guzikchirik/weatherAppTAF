package com.weatherapp.mobilelayer.driver;

import io.appium.java_client.AppiumDriver;

public interface IAppiumDriverCreator {

    AppiumDriver createDriver();

    void startAppiumServer();

    void stopAppiumServer();
}
