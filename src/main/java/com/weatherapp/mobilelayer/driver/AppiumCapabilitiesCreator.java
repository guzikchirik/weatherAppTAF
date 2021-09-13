package com.weatherapp.mobilelayer.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCapabilitiesCreator {

    private static DesiredCapabilities desiredCapabilities;

    public static Capabilities getCapabilities() {
        desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(AppiumCapabilities.PLATFORM_NAME, "Android");
//        desiredCapabilities.setCapability(AppiumCapabilities.DEVICE_NAME, "NexusSimAPI23");
//        desiredCapabilities.setCapability(AppiumCapabilities.APP_ACTIVITY, AppiumPropertyReader.get(CAPABILITY_APP_ACTIVITY));
//        desiredCapabilities.setCapability(AppiumCapabilities.APP_PACKAGE, AppiumCapabilities.getAppPackage());
//        desiredCapabilities.setCapability(AppiumCapabilities.APP, AppiumPropertyReader.get(CAPABILITY_APP_PATH));
//        desiredCapabilities.setCapability(AppiumCapabilities.NO_RESET, Boolean.FALSE);
        desiredCapabilities.setCapability("deviceName", "pixel");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.firstapp.weatherapp");
        desiredCapabilities.setCapability("appActivity", "com.firstapp.weatherapp.MainActivity");
        desiredCapabilities.setCapability("unicodeKeyboard", Boolean.TRUE);
        desiredCapabilities.setCapability("resetKeyboard", Boolean.TRUE);
        return desiredCapabilities;
    }
}
