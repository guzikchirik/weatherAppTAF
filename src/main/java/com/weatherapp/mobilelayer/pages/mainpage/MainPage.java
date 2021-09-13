package com.weatherapp.mobilelayer.pages.mainpage;

import java.time.temporal.ChronoUnit;

import com.weatherapp.mobilelayer.pages.DefaultMobilePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import lombok.Getter;

@Getter
public class MainPage extends DefaultMobilePage {

    @AndroidFindBy(id = "result_info_city")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement resultInfoCity;

    @AndroidFindBy(id = "user_field")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement userField;

    @AndroidFindBy(id = "clear_btn")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement clearBtn;

    @AndroidFindBy(id = "main_btn")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement mainBtn;

    @AndroidFindBy(id = "main_btn")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement mainMenu;

    @AndroidFindBy(id = "show_time_btn")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    private MobileElement showTimeBtn;

}
