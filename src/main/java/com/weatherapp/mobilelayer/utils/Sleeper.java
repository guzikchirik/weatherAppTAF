package com.weatherapp.mobilelayer.utils;

import java.time.Duration;

import com.weatherapp.mobilelayer.logger.Logger;

public class Sleeper {
    private static final Object synObj = new Object();

    public static void sleepTight(Duration duration) {
        synchronized (synObj) {
            try {
                if (duration.toSeconds() > 5) {
                    Logger.debug("Thread goes to sleep for " + duration);
                }
                Thread.sleep(duration.toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
