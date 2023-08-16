package day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamComOdev {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.dogan.arabam");

        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {

        // Uygulamanin basarili bir sekilde yuklendigi dogrulanir.
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // Uygulamanin basarili bir sekilde acildigi dogrulanir.
        AndroidElement headerKontrol = driver.findElementById("com.dogan.arabam:id/tvShowroomInfo");
        Assert.assertTrue(headerKontrol.isDisplayed());

        // Arabam kac para bolumune tiklayalim

        driver.findElementByXPath("//*[@text='Arabam kaç para?']").click();

        // Aracimin fiyatini merak ediyorum bolumune tiklayalim

        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        // Wolkswagen markasini secelim

        Thread.sleep(1000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(535, 1726)) // Telefondaki ilk tiklama islemini yaptigimiz yer
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // press ve moveTo arasindaki mesafenin zaman araligi
                .moveTo(PointOption.point(535, 240))// Telefondaki kaydirma islemini gerceklestirecegimiz yer
                .release()                                      //ekrandan parmagimizi kaldirma
                .perform();                                     // action in gorevleri yerine getir emrini verdigimiz kisim

            /*
            Eger waitAction da ki sure milisaniye olarak arttirilirsa ekranin asagiya kayma hizi artar ve daha fazla mesafe kat ederiz.
            Eger waitAction da ki sure milisaniye olarak azaltilirsa ekranin asagiya kayma hizi yavaslar ve daha az mesafe kat ederiz.

            action i her zaman 1 kere yazip hizini ayarlayarak hareket edecegiz.
             */


        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();

        // model secimi yapalim
        driver.findElementByXPath("//*[@text='Passat']").click();

        // govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();

        // yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();

        // vites tipini secelim
        driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();


        // Versiyon secimi yapalim

        Thread.sleep(1000);
        action.press(PointOption.point(456,618))
                .release()
                .perform();




        // aracin km bilgilerini girelim

        /*
        3 farkli yontem var :

        - sendKeys

        //km.sendKeys("5.000");
        //driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();

        - klavyeden deger girme

        -koordinatlardan tek tek rakamlara basma
         */

        AndroidElement km = driver.findElementById("com.dogan.arabam:id/et_km");
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("150000");
        }else{
            km.sendKeys("100000");
        }
        Thread.sleep(5);
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracin rengini secelim
        driver.findElementByXPath("//*[@text='Kırmızı']").click();

        // opsiyel donanim (varsa) seecelim
        // -- opsiyonel donanim yok
        Thread.sleep(1000);

        driver.findElementByXPath("//*[@text='Devam']").click();

        Thread.sleep(1000);

        // degisen bilgisi ekleyerek tramer kaydi belirtelim

       action.press(PointOption.point(538,792)).release().perform();
       action.press(PointOption.point(205,1611)).release().perform();
       Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();

        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Tramer kaydı yok']").click();
        driver.findElementByXPath("//*[@text='Devam']").click();


        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim

        AndroidElement ortalamaFiyatSonucuLocate=driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortSonSonuc = ortalamaFiyatSonucuLocate.getText();
        System.out.println(ortSonSonuc);

        ortSonSonuc = ortSonSonuc.replaceAll("\\D", "");
        System.out.println(ortSonSonuc);
        Assert.assertTrue(Integer.parseInt(ortSonSonuc)>500000);


        //int actualPriceInt = Integer.parseInt(actualAveragePrice);
//
        //if (actualPriceInt>500.000){
        //    System.out.println("Aracimin fiyati 500.000 tl den fazladir.");
        //}else{
        //    System.out.println("Aracimin fiyati 500.000 tl den azdir");
        //}
//
        //// uygulamayi kapatalim
//
        //driver.closeApp();

    }
}


       /*
        // TouchAction touchAction = new TouchAction<>(driver);

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

      // AndroidElement volkswagen = driver.findElementByXPath("//android.widget.TextView[@text='Volkswagen']");

        // Öğenin koordinatlarını alın
      //int x = volkswagen.getLocation().getX();
      //int y = volkswagen.getLocation().getY();
        // Koordinatları kullanarak tıklama işlemini gerçekleştirin
       //touchAction.tap(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofSeconds(20))).perform();


// Öğenin koordinatlarını alın
        int x = volkswagen.getLocation().getX() + (volkswagen.getSize().getWidth() / 2);
        int y = volkswagen.getLocation().getY() + (volkswagen.getSize().getHeight() / 2);

// Dokunma işlemini gerçekleştirin
        touchAction.tap(PointOption.point(x, y))
                .waitAction(waitOptions(Duration.ofSeconds(2))) // Uygun bir bekleme süresi
                .perform();
 */

