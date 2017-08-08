package com.endava.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @FindBy(id = "login-username")
    private WebElement loginUser;

    @FindBy(id = "login-signin")
    private  WebElement loginButton;

    @FindBy(id = "login-signin")
    private  WebElement signInButton;

    private WebDriver webDriver;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
    }

    public MainPage login(String userName, String password){
        loginUser.sendKeys(userName);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[2]/div[1]/div[2]/div/form/input[7]")));

        element.sendKeys(password);
        signInButton.click();

        MainPage mainPage = PageFactory.initElements(webDriver, MainPage.class);

        return mainPage;
    }
}
