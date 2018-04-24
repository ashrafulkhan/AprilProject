package com.testScript;

import com.script.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkTest extends BasePage {

    @Test
    public void testBrokenLink(){
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are "+links.size());

        for(int i=0; i<links.size();i++){

            WebElement ele=links.get(i);
            String url =  ele.getAttribute("href");

            verifyLinkActive(url);
        }


    }

    public void verifyLinkActive(String linkUrl){
        try {
            URL url=new URL(linkUrl);

            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

            httpURLConnection.setConnectTimeout(3000);

            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode()==200){
                System.out.println(linkUrl +"-"+httpURLConnection.getResponseMessage());
            }
            
            if(httpURLConnection.getResponseCode()==httpURLConnection.HTTP_NOT_FOUND){

                System.out.println(linkUrl+"-"+httpURLConnection.getResponseMessage()+"-"+httpURLConnection.HTTP_NOT_FOUND);
            }


        } catch (Exception e) {

        }
    }

}
