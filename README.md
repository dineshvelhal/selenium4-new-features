# selenium4-new-features
Selenium 4 - New And Exciting Feature Demos

## Frames and Tabs
Selenium 4 brings you the capability of opening additional browser windows or new browser tabs. Previously, with Selenium 3, only the application under test could open the new tabs or windows.
<p>
This is interesting because now you can open 2 or more applications in multiple windows or tabs and drive them simultaneously. 

[Demo](https://github.com/dineshvelhal/selenium4-new-features/tree/main/frames-and-tabs)

## Accessing Console Logs in Chrome
Accessing the Chrome Console logs is supported in Selenium 3 as well. In case of version 3, you can make use of the WebDriver capabilities to set the logging type and logging level.
In Selenium 4, now you can access the Chrome console logs using the newly supported CDP (Chrome DevTools) interface.
<p>
Below examples show how this works in Selenium 3 & 4

 - Selenium 3 - Using Driver capabilities [Demo](https://github.com/dineshvelhal/selenium4-new-features/tree/main/selenium-3-browser-console-logs)
 - Selenium 4 - Using Driver capabilities [Demo](https://github.com/dineshvelhal/selenium4-new-features/tree/main/selenium-4-browser-console-logs)
 - Selenium 4 - Using CDP Protocol [Demo](https://github.com/dineshvelhal/selenium4-new-features/tree/main/selenium-4-cdp-console-logs)

All 3 examples open the same application. When the button in the application is clicked, a variety of log messages with different log levels are printed in the Console Log. It's interesting to see how different versions of Selenium & CDP capture and show the logs.
(Please submit the PR if you think the CDP example requires improvements. I am still exploring this feature!)

## Geolocation Emulation
Selenium 4 has introduced the CDP support and that has opened up interesting possibilities like simulating the Geo-location. Now you can specify the Latitudes & Longitudes to mock the Geo-location.
<p>

In this example I specify the location of the Google Headquarters in California. See it in action in this [Demo](https://github.com/dineshvelhal/selenium4-new-features/tree/main/selenium4-cdp-geolocation)



