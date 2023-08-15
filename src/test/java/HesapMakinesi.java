import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HesapMakinesi {
    @Test
    public void hesapMakinesi() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver; // driver i tanimladik.
        // Android isletim sistemine sahip olan cihazlarda daha dogru sonuc vererek veya
        // yaptigimiz islemlere dogru komutlarin verilmesini saglar.
        // Sadece android cihazlarda kullanilir.
        //Android olmayan cihazlarda kesin calismaz anlamina gelmez. Ama hata orani daha yuksek olur.

        AppiumDriver<MobileElement> driver2; // Hem android hem ios isletim sistgemine sahip olan cihazlar icin kullanilir.
        //Android driver icin ayri bir driver oldugundan Appium driver ios ve turevleri icin kullanilmaktadir.



        // Bu 4 islem telefonumuzu tanitmak icin kullaniliyor.
        // Bunlari server a gonderecegiz. Server da telefon ile baglanti kurup  git gel bilgi alisverisini yapacak.

        // kullanici gerekli kurulumlari yapar

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\33602\\IdeaProjects\\APPIUM_T116\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
//        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\33602\\IdeaProjects\\APPIUM_T116\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");

        // Bu tanimlamalari server a tanitmamiz/ gondermemiz lazim!
        // server in host ve port numarasini tanitiyoruz. Bu url uzerinden cihaza ulasmak istiyoruz dedik

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // uygulamanin yuklendigini dogrular(isInstalled) ==> bundleID yi bulup testimizi yapiyoruz.

        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));    //"com.google.android.calculator" ==> APK Info uygulamasindan bulduk

        // uygulamanin acildigini dogrular

        AndroidElement acButonu = driver.findElement(By.id("com.google.android.calculator:id/clr"));
        Assert.assertTrue(acButonu.isDisplayed());

        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular



        // 100 un 5 katinin 500 oldugunu hesap makinesinden dogrulayalim.

        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("equals").click();

        String actualResult = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        int expectedResult = 500;

        Assert.assertEquals(Integer.parseInt(actualResult),expectedResult);



        /*
        Ilk defa bir uygulamayi cep telefonumuza yuklemek istersek APK dosyasinin yolunu tanitmaliyiz.

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\33602\\IdeaProjects\\APPIUM_T116\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        Bir kere yukledikten sonra (uygulama yuklu ise) yuklenmis halini baska bir capabilities ile acacagiz.
        */

        /*

        capabilities tanimlamalari bu sekilde de yapilabilir:

        capabilities.setCapability("deviceName", "PIXEL 2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");

        127.0.0.1:4723 ==> www.xxxxx.com a esit
        /wd/hub ==> endpoint degerleri

        -- APK Info ile applikasyonun bundleID sini aliyorum

          // Ya locate alarak hesaplama yapabiliriz ya da parmak hareketleriyle

        //Appium Inspector anlik olarak telefonun screenshot ini alarak inspect yapiyor. Ayni anda server ile baglanti olmak zorunda.
        //Her seferinde refresh source&screenshot yapmak lazim

        // Server i ayni anda hem Intellij hem de Inspector kullanamiyor. Test i calistirdigimizda server i intellij devralir.
        // start session ile server i Inspector un kullanimina aliriz.
        // Tekrar locate alabilmek icin her seferinde start session ile gitgel yapacagiz.
         Server i ayni anda iki is icin kullanamiyoruz. Inspector icin tekrar kullanmak istedgimizde start session yapmamiz gerek


        */















    }
}
