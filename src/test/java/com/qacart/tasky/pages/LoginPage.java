package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;
import static com.qacart.tasky.mocker.auth.MockProfile.mockRegularProfile;
import static com.qacart.tasky.mocker.auth.MockProfile.mockSubscribedProfile;
import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockSubscriptionTypes;
import static com.qacart.tasky.utils.CookieUtility.advancedUserCookieInsert;
import static com.qacart.tasky.utils.CookieUtility.regularUserCookieInsert;

public class LoginPage implements BasePage {

    @Override
    public void load() {
        getDriver().get(getConfig().pageBaseURL() + "/login");
    }

    public void loginUsingCookies(String userType) {
        switch (userType.toUpperCase()) {

            case "REGULAR": {
                mockRegularProfile();
                mockSubscriptionTypes();
                regularUserCookieInsert();
            } break;

            case "ADVANCED" : {
                mockSubscribedProfile();
                mockSubscriptionTypes();
                advancedUserCookieInsert();
            } break;

            default: throw new RuntimeException("Invalid user type");
        }
    }
}
