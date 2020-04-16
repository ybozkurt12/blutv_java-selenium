package pageObjects;

import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.List;

public class UyeOlMethods {

    private WebDriver driver;
    private SoftAssert softAssert;
    private WaitFunctions waitFunctions;


    public UyeOlMethods(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.waitFunctions = new WaitFunctions(driver);
    }



    public void cikis(){
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("div[class*='UserMenu_avatar']"));
        actions.moveToElement(element).perform();

        WebElement btn = driver.findElement(By.cssSelector("a[class*='UserMenu_logout']"));
        btn.click();

    }
}
