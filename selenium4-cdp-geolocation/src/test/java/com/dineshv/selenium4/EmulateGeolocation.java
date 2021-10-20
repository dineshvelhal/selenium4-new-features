package com.dineshv.selenium4;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EmulateGeolocation extends Base {

  @Test
  public void emulateGeolocation() {
    ChromeDriver cDriver = (ChromeDriver) driver;

    HashMap<String, Object> coords = new HashMap<>();
    coords.put("latitude", 37.422048);
    coords.put("longitude", -122.084014);
    coords.put("accuracy", 2);

    cDriver.executeCdpCommand("Emulation.setGeolocationOverride", coords);

    driver.get("https://where-am-i.org/");

    System.out.println("ADDRESS: " + driver.findElement(By.id("address")).getText());
  }
}
