package com.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseSeleniumTest {

    protected WebDriver webDriver;

    @Before
    public void beforeEachBaseSeleniumTest() {
        createWebDriver();
    }

    @After
    public void afterEachBaseSeleniumTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private void createWebDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", false);

        webDriver = new ChromeDriver(capabilities);
    }
}
