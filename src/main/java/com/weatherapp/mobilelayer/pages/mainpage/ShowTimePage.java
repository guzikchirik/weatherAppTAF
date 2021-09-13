package com.weatherapp.mobilelayer.pages.mainpage;

import java.time.temporal.ChronoUnit;

import com.weatherapp.mobilelayer.pages.DefaultMobilePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import lombok.Getter;

@Getter
public class ShowTimePage extends DefaultMobilePage {

    @AndroidFindBy(id = "tvTime")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement tvTime;
}
