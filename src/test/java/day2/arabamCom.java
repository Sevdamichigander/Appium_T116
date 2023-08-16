package day2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class arabamCom {

    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.dogan.arabam");
        //Hangi uygulama uzerinde calismak istiyorsak APK Info dan uygulama bilgisine ulasabiliriz. Yukaridaki satir
        // Ustteki satir driver.activateApp("com.dogan.arabam"); ile ayni islemi gorur.
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
         // Kullanacak oldugumuz uygulamayi belirledikten sonra (appPackage ta belirledik), o uygulamada hangi sayfadan baslamak istiyorsak
        // onun degerini activities kismindan bularak appActivity degiskeninin karsisina parametre olarak giriyoruz.

//        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\33602\\IdeaProjects\\APPIUM_T116\\Apps\\arabam.com_4.8.0_Apkpure.apk");
// uygulamayi ilk defa yukledikten sonra yukaridaki satiri yoruma aliyoruz

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest(){

/*        driver.activateApp("com.dogan.arabam");

                    Bir uygulamayi aktif hale getirmek istedigimizde APK Info dan onun bundleID degerini bularak buradan aktif hale getirebiliriz.
                    Sik kullanilan yontem bu degildir. capabilities tir ==> appPackage ve appActivity ile
 */

        // Arabam kac para bolumune tiklayalim

        driver.findElementById("com.dogan.arabam:id/tvPricePrediction").click();

        // Aracimin fiyatini merak ediyorum bolumune tiklayalim

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]").click();

        // Wolkswagen markasini secelim
        AndroidElement searchMarka = driver.findElementById("com.dogan.arabam:id/et_brand");
        searchMarka.click();
        searchMarka.sendKeys("Volkswagen");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView").click();

        // yil secimi yapalim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        // model secimi yapalim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]")).click();
        // govde tipini secelim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")).click();
        // yakit tipini secelim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView")).click();

        // vites tipini secelim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")).click();

        // Versiyon secimi yapalim
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")).click();

        // aracin km bilgilerini girelim
        AndroidElement km = driver.findElementById("com.dogan.arabam:id/et_km");
        km.sendKeys("5.000");
        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();

        // aracin rengini secelim

        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.TextView").click();

        // opsiyel donanim (varsa) seecelim
        // -- opsiyonel donanim yok

        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        driver.findElementById("com.dogan.arabam:id/iv_B01101").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView").click();
        driver.findElement(By.id("com.dogan.arabam:id/btn_next")).click();

        driver.findElementById("com.dogan.arabam:id/rbHasTramerEntry").click();
        AndroidElement tramerPrice = driver.findElementById("com.dogan.arabam:id/etPriceValue");
        tramerPrice.sendKeys("10.000");
        driver.findElementById("com.dogan.arabam:id/btnNext").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim

        String actualAveragePrice= driver.findElement(By.id("com.dogan.arabam:id/tvAveragePrice")).getText();
        actualAveragePrice = actualAveragePrice.replaceAll("[^0-9]", "");

        System.out.println(actualAveragePrice);
        int actualPriceInt = Integer.parseInt(actualAveragePrice);

        if (actualPriceInt>500.000){
            System.out.println("Aracimin fiyati 500.000 tl den fazladir.");
        }else{
            System.out.println("Aracimin fiyati 500.000 tl den azdir");
        }

        // uygulamayi kapatalim

        driver.closeApp();

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
