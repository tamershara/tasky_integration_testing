package com.qacart.tasky.driver.factory;

import com.qacart.tasky.driver.managers.ChromeManager;
import com.qacart.tasky.driver.managers.FirefoxManager;
import com.qacart.tasky.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;

public final class DriverFactory {
    private DriverFactory() {
    }

    public final static Map<BrowserType, Supplier<WebDriver>> DRIVERS = new HashMap<>();

    static {
        DRIVERS.put(BrowserType.CHROME, ChromeManager::getChromeDriver);
        DRIVERS.put(BrowserType.FIREFOX, FirefoxManager::getFirefoxDriver);
    }

    public static WebDriver initDriver() {
        return DRIVERS.get(getConfig().browser()).get();
    }

}
