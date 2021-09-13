package com.weatherapp.mobilelayer.command;

import java.util.function.Supplier;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum AdbCommands implements Supplier<String> {
    ADB_ADD_ENV("export ANDROID_HOME=$HOME/Library/Android/sdk; export ANDROID_SDK_ROOT=$ANDROID_HOME"),

    ADB_START_EMU("export ANDROID_HOME=$HOME/Library/Android/sdk; export ANDROID_SDK_ROOT=$ANDROID_HOME; cd $HOME/Library/Android/sdk/emulator; ./emulator -writable-system " +
                          "-no-snapshot -partition-size 1024 -avd Pixel_4_API_29; sleep 1; while [ \"`$(which adb) shell getprop init.svc.bootanim `\" != \"running\" ] ; do sleep 1; done; " +
                          "while [ \"`$(which adb) shell getprop init.svc.bootanim `\" != \"stopped\" ] ; do sleep 5; done");

    private String command;
    private String resultCommand;

    AdbCommands(String command) {
        this.command = command;
        this.resultCommand = command;
    }

    public AdbCommands command() {
        return this;
    }

    @Override
    public String get() {
        return resultCommand;
    }

    public AdbCommands withArg(String arg) {
        resultCommand = String.format(command, arg);
        return this;
    }
}
