package com.qacart.tasky.mocker.auth;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class MockProfile {
    private MockProfile() {}
    private static final String testUrl = "/api/auth/profile";
    public static void mockSubscribedProfile() {
        String mockedFile = "subscribedProfile.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withBodyFile(mockedFile)
                                .withStatus(200)
                )
        );
    }

    public static void mockCanceledProfile() {
        String mockedFile = "InactiveProfile.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withBodyFile(mockedFile)
                                .withStatus(200)
                )
        );
    }

    public static void mockRegularProfile() {
        String mockedFile = "regularProfile.json";
        stubFor(get(urlEqualTo(testUrl))
                .willReturn(
                        aResponse()
                                .withBodyFile(mockedFile)
                                .withStatus(200)
                )
        );
    }


}
