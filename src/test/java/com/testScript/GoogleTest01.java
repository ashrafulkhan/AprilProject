package com.testScript;

import com.script.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleTest01 extends BasePage{

    @Test
    public void gotoGooglePage(){
        WebElement ele=driver.findElement(By.xpath("//input[@id='lst-ib']"));
        ele.sendKeys("32 degrees fahrenheit to celsius");
        ele.submit();
        System.out.println("Bangladesh ");

    }
}
