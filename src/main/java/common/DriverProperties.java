package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProperties {

    public DriverProperties() {

    }

    private static ChromeDriver chromeDriver = null;

    public static WebDriver getChromeDriverInstance() {

        if(chromeDriver == null){
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("disable-dev-shm-usage");

            String workingDir = System.getProperty("user.dir");

            System.setProperty("webdriver.chrome.driver", workingDir + "/src/main/resources/drivers/chromedriver.exe");

            chromeDriver = new ChromeDriver(chromeOptions);

            chromeDriver.manage().deleteAllCookies();
            chromeDriver.manage().window().maximize();
        }
        return  chromeDriver;
    }


}
