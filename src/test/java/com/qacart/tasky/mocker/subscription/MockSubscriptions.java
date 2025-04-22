package com.qacart.tasky.mocker.subscription;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class MockSubscriptions {
    private MockSubscriptions() {}

    public static void mockActiveSubscription() {
        String testUrl = "/api/subscriptions";
        String mockedFile = "activatedSubscription.json";
        stubFor(
                post(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withStatus(201)
                                .withBodyFile(mockedFile)
                )
        );
    }

    public static void mockCloseToSubscriptionExpiration() {
        String testUrl = "/api/subscriptions/current";
        String mockedFile = "expiredSubscription.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withBodyFile(mockedFile)
                )
        );
    }

    public static void mockCurrentSubscriptionToBeActiveSubscriptionFlow() {
        String testUrl = "/api/subscriptions/current";
        String mockedFile = "currentActiveSubscriptionFlow.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                        .withStatus(200)
                        .withBodyFile(mockedFile)
                )
        );
    }

    public static void mockCurrentSubscriptionToBeActiveCancellationFlow() {
        String testUrl = "/api/subscriptions/current";
        String mockedFile = "currentActiveSubscriptionCancellationFlow.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withBodyFile(mockedFile)
                )
        );
    }

    public static void mockCancelledSubscription() {
        String testUrl = "/api/subscriptions/cancel";
        String mockedFile = "cancelSubscription.json";
        stubFor(post(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withBodyFile(mockedFile)
                )
        );
    }

    public static void mockSubscriptionTypes(){
        String testUrl = "/api/subscription-types";
        String mockedFile = "subscriptionTypes.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                        .withStatus(200)
                                .withBodyFile(mockedFile)
                )
                );
    }
}
