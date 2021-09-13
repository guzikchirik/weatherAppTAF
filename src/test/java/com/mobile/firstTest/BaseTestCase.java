package com.mobile.firstTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.weatherapp.mobilelayer.command.AdbCommands;
import com.weatherapp.mobilelayer.command.CommandExecutor;
import com.weatherapp.mobilelayer.driver.AppiumDriverManager;
import com.weatherapp.mobilelayer.logger.Logger;
import com.weatherapp.mobilelayer.pages.mainpage.MainPage;

import io.appium.java_client.AppiumDriver;

public class BaseTestCase {

    private AppiumDriver appiumDriver;
    protected MainPage mainPage;

    @BeforeTest
    public void setUp() {
        Logger.debug("setUp method");
        CommandExecutor.execute(AdbCommands.ADB_START_EMU);
        appiumDriver = AppiumDriverManager.getInstance()
                                          .createDriver();
        mainPage = new MainPage();
    }

    @AfterTest
    public void tearDown() {
        Logger.debug("tearDown method");
        appiumDriver.quit();
        AppiumDriverManager.getInstance()
                           .closeDriver();
    }

}
