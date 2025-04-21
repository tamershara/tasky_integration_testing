package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import com.qacart.tasky.model.CreditCardInfo;
import org.openqa.selenium.By;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;
import static com.qacart.tasky.mocker.auth.MockProfile.mockSubscribedProfile;
import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockActiveSubscription;
import static com.qacart.tasky.mocker.subscription.MockSubscriptions.mockCurrentSubscriptionToBeActive;

public class SubscriptionPage implements BasePage {
   private final By upgradeButtonLocator = By.xpath("//button[normalize-space()='Upgrade']");
   private final By cardNumberLocator = By.name("cardNumber");
   private final By expiryMonthLocator = By.name("expiryMonth");
   private final By expiryYearLocator = By.name("expiryYear");
   private final By cvvLocator = By.name("cvv");
   private final By subscribeButtonLocator = By.className("css-1dzsn8i");

    @Override
    public void load() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard/subscription");
    }

    public void subscribe(CreditCardInfo creditCard) {
        getDriver().findElement(upgradeButtonLocator).click();
        getDriver().findElement(cardNumberLocator).sendKeys(creditCard.getCardNumber());
        getDriver().findElement(expiryMonthLocator).sendKeys(creditCard.getExpiryMonth());
        getDriver().findElement(expiryYearLocator).sendKeys(creditCard.getExpiryYear());
        getDriver().findElement(cvvLocator).sendKeys(creditCard.getCvv());
        getDriver().findElement(subscribeButtonLocator).click();
    }

    public boolean isUpgradeButtonDisabled() {
        return getDriver().findElement(upgradeButtonLocator).isEnabled();
    }

    public void mockSubscriptionFlow() {
        mockActiveSubscription();
        mockCurrentSubscriptionToBeActive();
        mockSubscribedProfile();
    }

}
