package com.mobile.firstTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weatherapp.mobilelayer.pages.mainpage.ShowTimePage;
import com.weatherapp.mobilelayer.utils.Sleeper;

public class SmokeTests extends BaseTestCase {

    private static final String CITY = "Minsk";

    @Test
    public void searchResultForCityTest() {
        mainPage.getUserField().setValue(CITY);
        Assert.assertEquals(mainPage.getUserField().getText(), CITY, "Verify that userField contains searched city");

        mainPage.getMainBtn().click();
        Assert.assertEquals(mainPage.getResultInfoCity().getText(), CITY, "Verify that ResultInfoCity contains searched city");
    }

    @Test
    public void checkMainMenuTest() {
        mainPage.getUserField().setValue(CITY);
        Assert.assertEquals(mainPage.getUserField().getText(), CITY, "Verify that userField contains searched city");

        mainPage.getMainBtn().click();
        Assert.assertEquals(mainPage.getResultInfoCity().getText(), CITY, "Verify that ResultInfoCity contains searched city");
    }

    @Test
    public void checkButtonTimeTest() {
        mainPage.getShowTimeBtn().click();
        ShowTimePage showTimePage = new ShowTimePage();
        Assert.assertTrue(isValidFormat("HH:mm:ss", showTimePage.getTvTime().getText()), "Verify that userField contains searched city");
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
