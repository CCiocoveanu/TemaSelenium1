package com.endava.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentPage {

    private WebDriver webDriver;

    public SentPage(WebDriver driver){
        this.webDriver = driver;
    }
//
//    @FindBy(xpath = "//div[contains(@class,'list-view-items-page')]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
//    private WebElement lastPerson;

    public String getLastPerson(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement lastPerson = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'list-view-items-page')]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")));

        return lastPerson.getText();

    }
}
