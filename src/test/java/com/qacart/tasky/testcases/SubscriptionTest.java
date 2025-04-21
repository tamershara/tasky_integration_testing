package com.qacart.tasky.testcases;

import com.qacart.tasky.model.CreditCardInfo;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.Fixtures.CreditCardFixture.defaultCardInfo;
import static com.qacart.tasky.mocker.auth.MockProfile.mockSubscribedProfile;
import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockActiveSubscription;
import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockCurrentSubscriptionToBeActive;

public class SubscriptionTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SubscriptionPage subscriptionPage = new SubscriptionPage();
    @BeforeMethod
    public void setUp() {
        loginPage.load();
        loginPage.loginUsingCookies();
        dashboardPage.clickOnSubscriptionTab();
    }

    @Test
    void upgradeButtonShouldBeDisabledAfterSubscription() {
        mockActiveSubscription();
        mockCurrentSubscriptionToBeActive();
        mockSubscribedProfile();
        CreditCardInfo creditCardInfo = defaultCardInfo();
        subscriptionPage.subscribe(creditCardInfo);
        Assert.assertTrue(subscriptionPage.isUpgradeButtonDisabled());
    }
}
