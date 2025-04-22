package com.qacart.tasky.testcases.subscription;

import com.qacart.tasky.bases.BaseTest;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockCurrentSubscriptionToBeActiveCancellationFlow;

public class CancelSubscriptionTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SubscriptionPage subscriptionPage = new SubscriptionPage();
    @BeforeMethod
    void setUp() {
        loginPage.load();
        loginPage.loginUsingCookies("advanced");
        dashboardPage.load();
        mockCurrentSubscriptionToBeActiveCancellationFlow();
        dashboardPage.clickOnSubscriptionTab();
    }

    @Test
    void upgradeButtonInSubscriptionPageShouldBeEnabledAfterCancellation() {
        subscriptionPage.cancelSubscription();
        Assert.assertTrue(subscriptionPage.isUpgradeButtonEnabled());
    }
}
