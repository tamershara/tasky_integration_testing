package com.qacart.tasky.utils;

import org.openqa.selenium.Cookie;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public final class CookieUtility {
    private CookieUtility() {}

    public static void regularUserCookieInsert(){
        Cookie regularUserCookie = new Cookie("access_token", getConfig().regularUserToken());
        getDriver().manage().addCookie(regularUserCookie);
        getDriver().navigate().refresh();
    }

    public static void advancedUserCookieInsert(){
        Cookie subscribedUserToken = new Cookie("access_token", getConfig().advancedUserToken());
        getDriver().manage().addCookie(subscribedUserToken);
        getDriver().navigate().refresh();
    }
}
