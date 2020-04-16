import common.DriverProperties;
import common.ReadFileData;
import common.TestListener;
import common.WaitFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;


@Listeners(TestListener.class)
public class FirstTestCase {

    public WebDriver webDriver;
    public WaitFunctions waitFunctions;

    public FirstTestCase() throws Exception {

        webDriver = DriverProperties.getChromeDriverInstance();
        waitFunctions = new WaitFunctions(webDriver);
    }


    @Test(priority = 1)
    public void GirisYap() throws  Exception {

        UyeOlElements uyeOlElements = new UyeOlElements(webDriver);
        ReadFileData readFileData = new ReadFileData();
        uyeOlElements.isim.sendKeys(readFileData.readData("isim"));
        uyeOlElements.email.sendKeys(readFileData.readData("email"));
        uyeOlElements.password.sendKeys(readFileData.readData("password"));
        uyeOlElements.uyeOl.click();

        waitFunctions.threadSleep(10);

    }

    @Test(priority = 2)
    public void DiziSecimi() throws Exception {

        MainPageElements mainPageElements = new MainPageElements(webDriver);
        mainPageElements.diziTab.click();
        waitFunctions.threadSleep(5);

        MainPageMethods mainPageMethods = new MainPageMethods(webDriver);
        mainPageMethods.diziSec();
        waitFunctions.threadSleep(10);

        mainPageMethods.ilkBolumTikla();
        waitFunctions.threadSleep(15);

    }

    @Test(priority = 3)
    public void DiziBolumDetay() throws Exception{

        MainPageMethods mainPageMethods = new MainPageMethods(webDriver);
        mainPageMethods.onBesDakika();
        waitFunctions.threadSleep(15);

        mainPageMethods.devam();
        waitFunctions.threadSleep(2);

        mainPageMethods.anaSayfaGit();
        waitFunctions.threadSleep(5);

    }

    @Test(priority = 4 )
    public void FilmiDogrula() throws Exception{

        MainPageMethods mainPageMethods = new MainPageMethods(webDriver);
        Boolean isTrue = mainPageMethods.diziDogrula();
        Assert.assertTrue(isTrue);
    }

    @Test(priority = 5 )
    public void Cikis() throws Exception{
        UyeOlMethods uyeOlMethods = new UyeOlMethods(webDriver);
        uyeOlMethods.cikis();
    }
}
