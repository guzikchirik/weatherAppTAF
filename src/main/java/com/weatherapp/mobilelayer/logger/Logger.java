package com.weatherapp.mobilelayer.logger;

import org.apache.logging.log4j.LogManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Logger {

    private static final String DEFAULT_LOGGER_NAME = "com.weatherApp";
    private static String step = null;
    private static final ThreadLocal<org.apache.logging.log4j.Logger> LOGGER = ThreadLocal.withInitial(() -> LogManager.getLogger(DEFAULT_LOGGER_NAME));

    public static void info(String message) {
        LOGGER.get().info(addStepNumberInLog(message, " "));
    }

    public static void info(String message, Throwable error) {
        LOGGER.get().info(addStepNumberInLog(message, " "), error);
    }

    /**
     * Adding a step to an object is impossible because there will be problems with loading files on the RP
     */
    public static void info(Object message) {
        LOGGER.get().info(message);
    }

    public static void info(String message, Object... object) {
        LOGGER.get().info(addStepNumberInLog(message, " "), object);
    }

    public static void info(Class clazz, String message) {
        LOGGER.get().info(addStepNumberInLogWithClass(clazz, message, " "));
    }

    public static void debug(String message) {
        try {
            LOGGER.get().debug(addStepNumberInLog(message));
        } catch (Exception ex) {
            System.out.print("error in logger " + ex.getClass());
        }
    }

    public static void debug(Object message) {
        LOGGER.get().debug(message);
    }

    public static void debug(String message, Throwable error) {
        LOGGER.get().debug(addStepNumberInLog(message), error);
    }

    public static void debug(String message, Object... object) {
        LOGGER.get().debug(addStepNumberInLog(message), object);
    }

    public static void debug(Class clazz, String message) {
        LOGGER.get().debug(addStepNumberInLogWithClass(clazz, message));
    }

    public static void warn(String message) {
        LOGGER.get().warn(addStepNumberInLog(message, " "));
    }

    public static void warn(String message, Throwable error) {
        LOGGER.get().warn(addStepNumberInLog(message, " "), error);
    }

    public static void warn(Object message) {
        LOGGER.get().warn(message);
    }

    public static void warn(String message, Object... object) {
        LOGGER.get().warn(addStepNumberInLog(message, " "), object);
    }

    public static void warn(Class clazz, String message) {
        LOGGER.get().warn(addStepNumberInLogWithClass(clazz, message));
    }

    public static void fatal(String message) {
        LOGGER.get().fatal(addStepNumberInLog(message));
    }

    public static void fatal(String message, Throwable error) {
        LOGGER.get().fatal(addStepNumberInLog(message), error);
    }

    public static void fatal(Object message) {
        LOGGER.get().fatal(message);
    }

    public static void fatal(String message, Object... object) {
        LOGGER.get().fatal(addStepNumberInLog(message), object);
    }

    public static void error(String message) {
        LOGGER.get().error(addStepNumberInLog(message));
    }

    public static void error(String message, Throwable error) {
        LOGGER.get().error(addStepNumberInLog(message), error);
    }

    public static void error(Object message) {
        LOGGER.get().error(message);
    }

    public static void error(String message, Object... object) {
        LOGGER.get().error(addStepNumberInLog(message), object);
    }

    public static void error(Class clazz, String message) {
        LOGGER.get().error(addStepNumberInLogWithClass(clazz, message));
    }

    public static void trace(String message) {
        LOGGER.get().trace(addStepNumberInLog(message));
    }

    public static void trace(String message, Throwable error) {
        LOGGER.get().trace(addStepNumberInLog(message), error);
    }

    public static void trace(Object message) {
        LOGGER.get().trace(message);
    }

    public static void trace(String message, Object... object) {
        LOGGER.get().trace(addStepNumberInLog(message), object);
    }

    public static void setStep(String nextStep) {
        Logger.step = nextStep;
        Logger.info("----------------------------------- STEP {} -----------------------------------", nextStep);
    }

    public static void removeStepsFromLogWithMsg(String message) {
        Logger.step = null;
        Logger.info("----------------------------------- {} ----------------------------------- ", message);
    }

    private static String addStepNumberInLog(String message) {
        return addStepNumberInLog(message, "");
    }

    private static String addStepNumberInLog(String message, String prefix) {
        return step == null
                ? prefix + message
                : String.format("%s[Step %s] - %s", prefix, step, message);
    }

    private static String addStepNumberInLogWithClass(Class clazz, String message) {
        return addStepNumberInLogWithClass(clazz, message, "");
    }

    private static String addStepNumberInLogWithClass(Class clazz, String message, String prefix) {
        return step == null
                ? String.format("%s[%s] %s", prefix, clazz.getSimpleName(), message)
                : String.format("%s[Step %s] - [%s] %s", prefix, step, clazz.getSimpleName(), message);
    }
}
