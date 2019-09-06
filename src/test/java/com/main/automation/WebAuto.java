/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */

package com.main.automation;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAuto {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    final WebDriver driver = new ChromeDriver();
    driver.get("http://localhost:8085/user.jsp");
    final Random rand = new Random();
    final String randusername = "test" + rand.nextInt(100);
    final WebElement username = driver.findElement(By.name("username"));
    final WebElement contact = driver.findElement(By.name("contact"));
    final WebElement submit = driver.findElement(By.id("submit"));
    username.sendKeys(randusername);
    contact.sendKeys("923456790");
    submit.click();


    driver.findElement(By.id("my-input")).sendKeys("I am looking for PMS devices");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input"));
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("tier 1");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("Mid Acuity");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("touch screen");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("12 inch");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("addons: SpO2");
    driver.findElement(By.id("submit-input")).click();
    driver.findElement(By.id("my-input")).sendKeys("ok show the product");
    driver.findElement(By.id("submit-input")).click();
    final WebElement col = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]"));
    System.out.println(col.getText());
  }

}

