package com.abhi.tests;

import com.abhi.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.Test;


public class DemoTest {


    //local
    //remote  - browser stack , selenium grid , sauce labs
    //chrome , edge , firefox

    @Test
    public void testLogin(){

       // FrameworkConfig config = ConfigFactory.get(FrameworkConfig.class);
        // Singleton pattern - getOrCreate
        FrameworkConfig config = ConfigCache.getOrCreate(FrameworkConfig.class);


        System.out.println(config.browser());
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//
//        driver.quit();

    }
}
