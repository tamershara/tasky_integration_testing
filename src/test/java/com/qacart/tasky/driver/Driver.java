package com.qacart.tasky.driver;

import com.qacart.tasky.driver.managers.DriverManager;

import static com.qacart.tasky.driver.factory.DriverFactory.initDriver;

public final class Driver {
    private Driver() {
    }

    public static void initialize() {
        DriverManager.setDriver(initDriver());
    }
}
