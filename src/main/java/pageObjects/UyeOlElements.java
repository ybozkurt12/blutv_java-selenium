package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UyeOlElements {
    public WebElement isim;
    public WebElement email;
    public WebElement password;
    public WebElement uyeOl;


    public UyeOlElements(WebDriver driver) {

        isim        = driver.findElement(By.id("registerWidget_name"));
        email       = driver.findElement(By.cssSelector("input[name='username']"));
        password    = driver.findElement(By.cssSelector("input[name='password']"));
        uyeOl       = driver.findElement(By.cssSelector("button[type='submit']"));
    }
}
