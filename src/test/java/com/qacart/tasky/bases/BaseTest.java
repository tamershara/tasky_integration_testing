package com.qacart.tasky.bases;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.qacart.tasky.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class BaseTest {
    protected WireMockServer wireMockServer;

    @BeforeMethod
    protected void setUpDriver() {
        Driver.initialize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeMethod
    protected void setUpMockServer() {
        wireMockServer = new WireMockServer(new WireMockConfiguration().port(8091).enableBrowserProxying(true));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8091);
    }

    @AfterMethod
    protected void tearDown() {
        //getDriver().quit();
        wireMockServer.stop();
    }
}
