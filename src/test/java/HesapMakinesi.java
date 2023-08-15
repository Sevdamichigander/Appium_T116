import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        // Bu tanimlamalari server a tanitmamiz/ gondermemiz lazim!
        // server in host ve port numarasini tanitiyoruz. Bu url uzerinden cihaza ulasmak istiyoruz dedik

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        /*
        127.0.0.1:4723 ==> www.xxxxx.com a esit
        /wd/hub ==> endpoint degerleri

         */










        /*

        capabilities tanimlamalari bu sekilde de yapilabilir:

        capabilities.setCapability("deviceName", "PIXEL 2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");

        */











    }
}
