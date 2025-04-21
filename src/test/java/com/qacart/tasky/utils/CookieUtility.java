package com.qacart.tasky.utils;

import org.openqa.selenium.Cookie;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public final class CookieUtility {
    private CookieUtility() {}

    public static void RegularUserCookieInsert(){
        Cookie RegularUserCookie = new Cookie("access_token", getConfig().regularUserToken());
        getDriver().manage().addCookie(RegularUserCookie);
        getDriver().navigate().refresh();
    }
}
