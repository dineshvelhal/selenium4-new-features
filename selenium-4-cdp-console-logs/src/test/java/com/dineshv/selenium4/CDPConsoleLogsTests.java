package com.dineshv.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.log.Log;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CDPConsoleLogsTests {
    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        // DevTools Protocol
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
            System.out.println(logEntry.getLevel().toString().toUpperCase() + " : "
                + logEntry.getText() + " : " + logEntry.getSource().name());
        });
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void readConsoleLog() {
        driver.get("https://dineshvelhal.github.io/testautomation-playground/console_logs.html");
        driver.findElement(By.id("button")).click();
    }
}

