package com.endava;

import com.endava.page.LoginPage;
import com.endava.page.MainPage;
import com.endava.page.SentPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainTestClass {
    protected static LoginPage loginPage;
    private static WebDriver webDriver;

    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver","C:/Users/cciocoveanu/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");

        loginPage = PageFactory.initElements(webDriver, LoginPage.class);
    }

    @AfterClass
    public static  void after(){
        webDriver.close();
    }

    @Test
    public void firstTest(){

        MainPage mainPage = loginPage.login("tselenium45", "password45");
    //    mainPage.sendMail("tselenium45@yahoo.com","test","content test");

        System.out.println(mainPage.getSubject());
        Assert.assertEquals("test", mainPage.getSubject());

        mainPage.clickLastReceived();

        System.out.println(mainPage.getContent());
        Assert.assertEquals("content test", mainPage.getContent());

        SentPage sentPage = mainPage.openSent();

        System.out.println(sentPage.getLastPerson());
        Assert.assertEquals("tselenium45@yahoo.com", sentPage.getLastPerson());

        mainPage.signOut();
    }


}

// //*[@id="yui_3_16_0_ym19_1_1502118768387_1755"]

// //div[contains(@class,'subj')]//span[contains(@class,'subj')]