package com.qacart.tasky.driver.managers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public final class FirefoxManager {
    private FirefoxManager() {
    }

    public static FirefoxDriver getFirefoxDriver() {
        return new FirefoxDriver(getFirefoxOptions());
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        Proxy proxy = new Proxy();
        proxy.setSslProxy("localhost:8091");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("security.fileuri.strict_origin_policy", false);
        options.setProfile(profile);
        options.setProxy(proxy);
        options.addArguments("--start-maximized");
        return options;
    }
}
