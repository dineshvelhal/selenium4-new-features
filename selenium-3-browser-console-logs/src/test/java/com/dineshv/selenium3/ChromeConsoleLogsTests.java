package com.dineshv.selenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeConsoleLogsTests {
    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);

        options.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void readConsoleLog() {
        driver.get("https://dineshvelhal.github.io/testautomation-playground/console_logs.html");
        driver.findElement(By.id("button")).click();

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for(LogEntry logEntry: logEntries) {
            System.out.println(logEntry.getLevel() + " : " + logEntry.getMessage());
        }
    }
}

