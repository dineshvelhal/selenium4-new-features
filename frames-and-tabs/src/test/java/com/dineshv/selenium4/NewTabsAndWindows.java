package com.dineshv.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import static org.testng.Assert.*;

public class NewTabsAndWindows extends Base{
    By searchField = By.name("q");
    By searchButton = By.name("btnK");

    @Test(testName = "New Window Test")
    public void newWindow() throws InterruptedException {
        // Go to Google in main window
        driver.get("https://www.google.com");
        // Get the handle of the main window.
        String mainWindow = driver.getWindowHandle();

        // Add new window and go to Google in that window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.google.com");
        // Get the handle of the new window.
        String newWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(windowHandles.size(), 2);

        // Add some wait to allow time to move windows, so you can watch them better
        Thread.sleep(3000);

        driver.switchTo().window(mainWindow);
        driver.findElement(searchField).sendKeys("Selenium 4");

        driver.switchTo().window(newWindow);
        driver.findElement(searchField).sendKeys("Test Automation");

        driver.switchTo().window(mainWindow);
        driver.findElement(searchButton).click();
        Thread.sleep(2000);

        driver.switchTo().window(newWindow);
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }

    @Test(testName = "New Tab Test")
    public void newTab() throws InterruptedException {

        // Go to Google in main window
        driver.get("https://www.google.com");
        // Get the handle of the main window.
        String mainWindow = driver.getWindowHandle();

        // Add new window and go to Google in that window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");
        // Get the handle of the new window.
        String newWindow = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(windowHandles.size(), 2);

        driver.switchTo().window(mainWindow);
        driver.findElement(searchField).sendKeys("Selenium 4");

        driver.switchTo().window(newWindow);
        driver.findElement(searchField).sendKeys("Test Automation");

        driver.switchTo().window(mainWindow);
        driver.findElement(searchButton).click();
        Thread.sleep(2000);

        driver.switchTo().window(newWindow);
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }
}
