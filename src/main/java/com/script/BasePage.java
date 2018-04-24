package com.script;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    @BeforeMethod
    public void beforMethod(){
        ChromeDriverManager.getInstance().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        String url="http://www.google.co.in/";
        driver.navigate().to(url);


    }


    @AfterMethod
    public void afterMethod(){
     driver.close();
    }
}
