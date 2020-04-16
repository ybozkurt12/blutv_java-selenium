package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageElements {

    public WebElement diziTab;
    public WebElement blueTVLogo;


    public MainPageElements(WebDriver driver) {

        diziTab      = driver.findElement(By.cssSelector("#header_dizi"));
        blueTVLogo   = driver.findElement(By.cssSelector(".blutv-logo"));
    }
}
