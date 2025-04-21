package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import com.qacart.tasky.model.CreditCardInfo;
import org.openqa.selenium.By;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class SubscriptionPage implements BasePage {
   private final By upgradeButtonLocator = By.id(":r5:");
   private final By cardNumberLocator = By.name("cardNumber");
   private final By expiryMonthLocator = By.name("expiryMonth");
   private final By expiryYearLocator = By.name("expiryYear");
   private final By cvvLocator = By.name("cvv");
   private final By subscribeButtonLocator = By.id(":rb:");

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

}
