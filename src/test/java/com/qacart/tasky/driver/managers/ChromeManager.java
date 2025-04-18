package com.qacart.tasky.driver.managers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeManager {
    private ChromeManager() {
    }

    public static ChromeDriver getChromeDriver() {
        return new ChromeDriver(getChromeOptions());
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setSslProxy("localhost:8091");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security");
        options.setProxy(proxy);
        return options;
    }
}
