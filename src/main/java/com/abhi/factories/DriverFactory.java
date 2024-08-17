package com.abhi.factories;

import com.abhi.enums.BrowserType;
import com.abhi.enums.ConfigProperties;
import com.abhi.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;



public final class DriverFactory {

    private DriverFactory() {}

    /**
     *
     * @param browser
     * @param version
     * @return
     * @throws MalformedURLException
     * TODO Remove hardcoded value of grid url
     */

    public static WebDriver getDriver(String browser, String version) throws MalformedURLException {

        WebDriver driver=null;

        String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
        if(browser.equalsIgnoreCase("chrome")) {
            if(runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(String.valueOf(BrowserType.CHROME));
                cap.setVersion(version);
                driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            }
            else {
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                WebDriverManager.chromedriver().browserVersion("127.0.6533.99").setup();
                driver = new ChromeDriver();
            }
        }
        else if(browser.equalsIgnoreCase("firefox")) {

            if(runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(String.valueOf(BrowserType.FIREFOX));
                cap.setVersion(version);
                driver =new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}