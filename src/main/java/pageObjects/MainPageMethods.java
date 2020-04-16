package pageObjects;

import common.ReadFileData;
import common.WaitFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.nio.file.WatchEvent;
import java.util.List;

public class MainPageMethods {
    private WebDriver driver;
    private SoftAssert softAssert;
    private WaitFunctions waitFunctions;

    public MainPageMethods(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();
        this.waitFunctions = new WaitFunctions(driver);
    }


    public void diziSec() throws  Exception{
        WebElement sıfırBir = driver.findElement(By.cssSelector(".thumb[ng-title='Sıfır Bir – Bir Zamanlar Adana’da']"));
        sıfırBir.click();
    }

    public void ilkBolumTikla(){

        List<WebElement> bolumler = driver.findElements(By.cssSelector("div[test-id='cardOverlay']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",bolumler.get(0));

    }

    public void onBesDakika(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("try {var iframe = document.getElementById('player-iframe'); " +
                "var video = iframe.contentWindow.document.getElementsByTagName('video')[0]; " +
                " } catch (e) { " +
                " var video = document.getElementsByTagName('video')[0]; } " +
                " " +
                " video.currentTime = 900; video.play();  " +
                " setTimeout(function() {video.pause()}, 5000);");
    }

    public void devam(){

        WebElement iframeElement = driver.findElement(By.cssSelector("iframe#player-iframe"));
        driver.switchTo().frame(iframeElement);
        WebElement playIcon = driver.findElement(By.cssSelector(".vjs-big-play-button"));
        playIcon.click();

    }

    public void anaSayfaGit(){

        ReadFileData readFileData = new ReadFileData();
        String url = readFileData.readData("mainPage");
        driver.get(url);

    }


    public boolean diziDogrula(){

        List<WebElement> izlemeyeDevam = driver.findElements(By.cssSelector("div[ng-title='İzlemeye Devam Et'] .media[ng-title='Sıfır Bir – Bir Zamanlar Adana’da']"));
        int size = izlemeyeDevam.size();
        if(size != 0){
            return true;
        }else {
            return false;
        }
    }

    public void filmeGit(){

        driver.get("https://www.blutv.com/filmler/yerli/aidiyet");
    }

    public void listemeEkle(){

        WebElement listemeEkleBtn = driver.findElement(By.cssSelector("[test-id='addFavoriteButton']"));
        listemeEkleBtn.click();
    }

    public void izlemeListemKontrol(){
        String izlemeListem = driver.findElement(By.cssSelector("div.favorites-home h2")).getText();
        Assert.assertEquals(izlemeListem,"İzleme Listem");
    }
}
