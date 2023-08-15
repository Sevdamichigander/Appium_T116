package day2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
        // driver.activateApp("com.dogan.arabam"); ile ayni islemi gorur. Ustteki satir
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

//        driver.activateApp("com.dogan.arabam");
// Bir uygulamayi aktif hale getirmek istedigimizde APK Info dan onun bundleID degerini bularak buradan aktif hale getirebiliriz.
        // Sik kullanilan yontem bu degildir. capabilities tir.



    }
}

        // Arabam kac para bolumune tiklayalim
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        // Wolkswagen markasini secelim
        // yil secimi yapalim
        // model secimi yapalim
        // govde tipini secelim
        // yakit tipini secelim
        // vites tipini secelim
        // Versiyon secimi yapalim
        // aracin km bilgilerini girelim
        // aracin rengini secelim
        // opsiyel donanim (varsa) seecelim
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        // uygulamayi kapatalim
