package com.weatherapp.mobilelayer.driver;


import java.net.MalformedURLException;
import java.net.URL;

import com.weatherapp.mobilelayer.logger.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumDriverCreator implements IAppiumDriverCreator {

    private String deviceUDID = "emulator-5554";
    private static String appiumPort = "4723";
    private static String appiumServerAddress = "127.0.0.1";
    private  static AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
            .usingPort(Integer.parseInt(appiumPort))
            .withIPAddress(appiumServerAddress)
            .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
            .withArgument(CustomServerArgument.RELAXED_SECURITY)
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE);

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildService(appiumServiceBuilder);

    @Override
    public AppiumDriver createDriver() {
        startAppiumServer();
        return new AndroidDriver(service, AppiumCapabilitiesCreator.getCapabilities());
    }

    @Override
    public void startAppiumServer() {
        Logger.debug("Try to start appium service on port: " + appiumPort);
        service.start();
        Logger.debug("Appium service is started successfully");
    }

    @Override
    public void stopAppiumServer() {
        Logger.debug("STOP Appium service on port: " + appiumPort);
        service.stop();
    }
}
