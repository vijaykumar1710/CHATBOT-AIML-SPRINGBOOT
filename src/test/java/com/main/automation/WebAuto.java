/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
// */
package com.main.uitest;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAuto {


  public static String automate(String hospitalType, String acuity, String screenType, String screenSize, String addons){
    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    final String URL = "http://localhost:8085/user.jsp";
    final WebDriver driver = new ChromeDriver();
    driver.get(URL);
    final Random rand = new Random();
    final String randusername = "test" + rand.nextInt(1000) ;
    final WebElement username = driver.findElement(By.name("username"));
    final WebElement contact = driver.findElement(By.name("contact"));
    final WebElement submit = driver.findElement(By.id("submit"));
    username.sendKeys(randusername);
    contact.sendKeys("9234567890");
    submit.click();

    final String inputId = "my-input";
    final String submitId = "submit-input";
    driver.findElement(By.id(inputId)).sendKeys("I am looking for PMS devices");
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId));
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys(hospitalType);
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys(acuity);
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys(screenType);
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys(screenSize);
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys("addons: " + addons);
    driver.findElement(By.id(submitId)).click();
    driver.findElement(By.id(inputId)).sendKeys("ok show the product");
    driver.findElement(By.id(submitId)).click();
    final String Suggested = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText();
    driver.findElement(By.id("msg")).sendKeys("interested");
    driver.findElement(By.id("getresult")).click();
    driver.switchTo().alert().accept();
    driver.quit();
    return Suggested;

  }
}
