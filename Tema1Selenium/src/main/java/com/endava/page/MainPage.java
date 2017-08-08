package com.endava.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver driver){
        this.webDriver = driver;
    }

    @FindBy(id = "Compose")
    private WebElement composeButton;

//    @FindBy(id = "to-field")
//    private  WebElement toField;

    @FindBy(id = "subject-field")
    private WebElement subjectField;

    @FindBy(id = "rtetext")
    private WebElement textField;

    @FindBy(xpath = "html/body/div[8]/div[3]/div[4]/div[2]/div[7]/div/table/tbody/tr[3]/td/div[2]/span[1]/a")
    private WebElement sendMailButton;

    @FindBy(xpath = "//div[contains(@class,'list-view-items-page')]/div[3]//span[contains(@class,'subj')]")
    private WebElement lastReceivedSubject;

    @FindBy(xpath = "//div[contains(@class,'list-view-items-page')]/div[3]//span[contains(@class,'thread-snippet')]")
    private WebElement getLastReceivedContent;

    @FindBy(xpath = "//div[@style='visibility: visible;']//div[@aria-expanded='true' and contains(@class,'thread-item expanded')]//div[@class='email-wrapped'] ")
    private WebElement contentFromMail;

    @FindBy(xpath = "//li[@id='Sent']/a")
    private WebElement sentButton;

    @FindBy(xpath = "(//li[contains(@class,'Py(8px)')]/a)[1]")
    private WebElement signOutButton;

    @FindBy(xpath = "//td[@id='uhNavWrapper']/ul/li[2]/a")
    private  WebElement homeButton;

    public String getSubject(){
        return lastReceivedSubject.getText();
    }

    public String getContent(){
        return contentFromMail.getText();
    }

    public void sendMail(String to, String subject, String message){
        composeButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement toField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to-field")));
        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        textField.sendKeys(message);
        sendMailButton.click();
    }

    public void clickLastReceived(){
        lastReceivedSubject.click();
    }

    public SentPage openSent(){
        sentButton.click();

        SentPage sentPage = PageFactory.initElements(webDriver, SentPage.class);

        return sentPage;
    }

    public void signOut(){
        homeButton.click();
        signOutButton.click();
    }




//    public void waitUntilCompleteLoad(){
//        WebDriverWait wait = new WebDriverWait(webDriver,5000);
//        wait.until(ExpectedConditions.visibilityOfAllElements(jobList));
//        wait.until(ExpectedConditions.textToBePresentInElement(totalJobs,""));
//
//    }
}
