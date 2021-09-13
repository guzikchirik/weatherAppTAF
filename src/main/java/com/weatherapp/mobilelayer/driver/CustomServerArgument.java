package com.weatherapp.mobilelayer.driver;

import io.appium.java_client.service.local.flags.ServerArgument;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CustomServerArgument implements ServerArgument {
    RELAXED_SECURITY("--relaxed-security");
    private final String argument;
}
