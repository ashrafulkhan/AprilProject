package com.testScript;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    protected WebDriver driver;

    @BeforeMethod
    public void before(){
        ChromeDriverManager.getInstance().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        String url="http://jqueryui.com/droppable/";
        driver.navigate().to(url);
    }

    @Test
    public void Test(){

        List<WebElement> iframeElements=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe "+iframeElements.size());

        driver.switchTo().frame(0);


        WebElement tergetElement=driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement sourchElement=driver.findElement(By.xpath("//div[@id='draggable']/p[contains(text(),'Drag me to my target')]"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(sourchElement,tergetElement).build().perform();

    }

    @AfterMethod
    public void after(){

    }
}
