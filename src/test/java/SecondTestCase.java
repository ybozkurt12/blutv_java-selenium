import common.DriverProperties;
import common.ReadFileData;
import common.TestListener;
import common.WaitFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.MainPageMethods;
import pageObjects.UyeOlElements;
import pageObjects.UyeOlMethods;

@Listeners(TestListener.class)
public class SecondTestCase {

    public WebDriver webDriver;
    public WaitFunctions waitFunctions;

    public SecondTestCase() throws Exception {

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
    public void FilmDetay() throws  Exception {

        MainPageMethods mainPageMethods = new MainPageMethods(webDriver);
        mainPageMethods.filmeGit();

        waitFunctions.threadSleep(5);

        mainPageMethods.listemeEkle();

        mainPageMethods.anaSayfaGit();
        waitFunctions.threadSleep(5);

        mainPageMethods.izlemeListemKontrol();
        waitFunctions.threadSleep(5);

    }

    @Test(priority = 3 )
    public void Cikis() throws Exception{

        UyeOlMethods uyeOlMethods = new UyeOlMethods(webDriver);
        uyeOlMethods.cikis();


    }

}
