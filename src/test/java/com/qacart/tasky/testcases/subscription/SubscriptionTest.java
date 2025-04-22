package com.qacart.tasky.testcases.subscription;

import com.qacart.tasky.bases.BaseTest;
import com.qacart.tasky.model.CreditCardInfo;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.Fixtures.CreditCardFixture.defaultCardInfo;

public class SubscriptionTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SubscriptionPage subscriptionPage = new SubscriptionPage();
    @BeforeMethod
    public void setUp() {
        loginPage.load();
        loginPage.loginUsingCookies("regular");
        dashboardPage.load();
        dashboardPage.clickOnSubscriptionTab();
    }

    @Test
    void upgradeButtonInSubscriptionPageShouldBeDisabledAfterSubscription() {
        CreditCardInfo creditCardInfo = defaultCardInfo();
        subscriptionPage.subscribe(creditCardInfo);
        Assert.assertFalse(subscriptionPage.isUpgradeButtonEnabled());
    }
}
