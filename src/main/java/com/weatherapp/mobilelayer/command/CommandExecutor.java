package com.weatherapp.mobilelayer.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.weatherapp.mobilelayer.logger.Logger;

public class CommandExecutor {

    public static void executeScript(String pathToScript) {
        try {
            Process process = new ProcessBuilder().command(pathToScript).start();
            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                System.out.println(line);
            }
            System.out.println("before exitVal = ");
            int exitVal = process.waitFor();
            System.out.println("exitVal = "+exitVal);
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
            } else {
                //abnormal...
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String executeWithResponse(Supplier<String> command) {
        return createProcessWithStringResponse(command, Duration.ofSeconds(30));
    }

    public static List<String> executeWithLinedResponse(Supplier<String> command) {
        return createProcessWithResponse(command, Duration.ofSeconds(30));
    }

    public static String executeXcodeTests(Supplier<String> command) {
        String output = createProcessWithStringResponse(command, Duration.ofSeconds(100));
        return output.contains("** TEST SUCCEEDED **") ? "PASSED" : "FAILED";
    }

    public static void execute(Supplier<String> command) {
        execute(command, Duration.ofSeconds(30));
    }

    public static void execute(Supplier<String> command, Duration duration) {
        createProcess(getCommandArray(command.get()), duration);
    }

    public static void execute(String[] command) {
        int length = command.length;
        String[] commandArray = new String[5 + length];
        commandArray[0] = "/bin/bash";
        commandArray[1] = "-c";
        System.arraycopy(command, 0, commandArray, 2, length);
        commandArray[commandArray.length - 2] = "with";
        commandArray[commandArray.length - 1] = "args";
        createProcess(commandArray, Duration.ofSeconds(20));
    }

    private static String[] getCommandArray(String command) {
        String[] commandArray = new String[5];
        commandArray[0] = "/bin/bash";
        commandArray[1] = "-c";
        commandArray[2] = command;
        commandArray[3] = "with";
        commandArray[4] = "args";
        return commandArray;
    }

    private static String createProcessWithStringResponse(Supplier<String> command, Duration duration) {
        return createProcessWithResponse(command, duration).stream().collect(Collectors.joining());
    }

    private static List<String> createProcessWithResponse(Supplier<String> command, Duration duration) {
        String[] commands = getCommandArray(command.get());
        Logger.debug("[ " + commands[2].replace("~/Library/Android/sdk/platform-tools/", "") + " ]");
        List<String> output = new ArrayList<>();
        try {
            Process p = new ProcessBuilder(commands).start();
            waitForRefresh(p, duration);
            output = getOutput(p).collect(Collectors.toList());
            p.destroy();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        Logger.trace("Command output is > " + output.toString());
        return output;
    }

    private static void createProcess(String[] command, Duration timeout) {
        Logger.debug("[ " + command[2].replace("~/Library/Android/sdk/platform-tools/", "") + " ]");
        try {
            Process p = new ProcessBuilder(command).start();
            waitForRefresh(p, timeout);
            p.destroy();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void waitForRefresh(Process p, Duration duration) throws InterruptedException {
        p.waitFor(10, TimeUnit.SECONDS);
        int refreshTime = 3;
        for (int i = 0; i < duration.getSeconds() / refreshTime && p.isAlive(); i++) {
            Thread.sleep(refreshTime * 1000);
        }
    }

    private static Stream<String> getOutput(Process p) {
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        return in.lines();
    }
}
