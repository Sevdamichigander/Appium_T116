package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class kiwiCom {

    AndroidDriver<AndroidElement> driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.skypicker.main");

        capabilities.setCapability("appActivity", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");

          /*                                 NO_RESET
         -  Eger bir uygulamada uygulamanin on bellegini her testten sonra sifirlamak istiyorsak NoReset FALSE olmalidir.

         -  Eger bir uygulamada uygulamanin on bellegini sifirlamadan gectigimiz adimlarin kaydedilerek sifirdan
            uygulamanin baslamasini istemiyorsak NoReset TRUE olmalidir.
        */

        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void kiwiTest() throws InterruptedException {
    // uygulamanin yuklendigi dogrulanir

        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
    // uygulamanin basariyla acildigi dogrulanir

        AndroidElement devamButon = driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(devamButon.isDisplayed());
        // misafir olarak devam et e tiklanir

        devamButon.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        TouchAction action = new TouchAction<>(driver);

        Thread.sleep(1000);

        for (int i=0; i<3; i++){
            action.press(PointOption.point(538,1689)).release().perform();
            Thread.sleep(2000);
        }

        // Trip type,one way olarak secilir
        Thread.sleep(5000);
        driver.findElementByXPath("//*[@text='Return']").click();
        driver.findElementByXPath("//*[@text='One way']").click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        driver.findElementByXPath("//*[@text='Strasbourg']").click();
        Thread.sleep(2000);
        action.press(PointOption.point(1001,1556)).release().perform();
        Thread.sleep(2000);
        action.press(PointOption.point(1001,1556)).release().perform();
        Thread.sleep(2000);


        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        AndroidElement fromBox = driver.findElementByXPath("//*[@class='android.widget.EditText']");
        fromBox.sendKeys("Paris");
        Thread.sleep(4000);

        driver.findElementByXPath("//*[@text='CDG, Charles de Gaulle Airport']").click();
       //fromBox.sendKeys(Keys.ARROW_DOWN);
       //Thread.sleep(4000);
       //fromBox.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElementByXPath("//*[@text='Choose']").click();
        Thread.sleep(4000);

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        driver.findElementByXPath("//*[@text='Anywhere']").click();
        Thread.sleep(4000);

        AndroidElement arrivalBox = driver.findElementByXPath("//*[@class='android.widget.EditText']");
        Thread.sleep(4000);

        arrivalBox.sendKeys("Italy");
        Thread.sleep(8000);

        driver.findElementByXPath("//*[@text='NAP, Naples International']").click();
        Thread.sleep(4000);

        driver.findElementByXPath("//*[@text='Choose']").click();
        Thread.sleep(4000);

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        driver.findElementByXPath("//*[@text='Anytime']").click();
        Thread.sleep(8000);

        action.press(PointOption.point(80, 205)) // Telefondaki ilk tiklama islemini yaptigimiz yer
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // press ve moveTo arasindaki mesafenin zaman araligi
                .moveTo(PointOption.point(80, 1005))// Telefondaki kaydirma islemini gerceklestirecegimiz yer
                .release()                                      //ekrandan parmagimizi kaldirma
                .perform();
        Thread.sleep(4000);

        driver.findElementByXPath("//*[@text='Set date']").click();
        Thread.sleep(4000);


        // search butonuna tiklanir
        driver.findElementByXPath("//*[@text='Search']").click();
        Thread.sleep(4000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(4000);

        driver.findElementByXPath("//*[@text='Price']").click();
        driver.findElementByXPath("//*[@text='Cheapest']").click();
        driver.findElementByXPath("//*[@text='Stops']").click();
        driver.findElementByXPath("//*[@text='Nonstop']").click();

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

        AndroidElement biletFiyati = driver.findElementByXPath("//*[@text='$83.00']");
        driver.sendSMS("0602142536", biletFiyati.getText());
    }
}




// uygulamanin yuklendigi dogrulanir
// uygulamanin basariyla acildigi dogrulanir
// misafir olarak devam et e tiklanir
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
