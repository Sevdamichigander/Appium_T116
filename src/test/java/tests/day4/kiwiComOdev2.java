package tests.day4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class kiwiComOdev2 {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    TouchAction action = new TouchAction<>(driver);
    KiwiPage kiwiPage = new KiwiPage();

    // Bu esitlik sayesinde bir onceki derste olusturdugumuz @BeforeTest e ihtiyacimiz kalmadi.

    @Test
    public void kiwiTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        AndroidElement devamButon = driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(kiwiPage.misafirOlarakDevamEt.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.misafirOlarakDevamEt.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        Thread.sleep(1000);
        kiwiPage.ilkSayfaGecisleri();

        // Trip type,one way olarak secilir
        ReusableMethods.koordinatTiklama(303,624, 1000);
        ReusableMethods.koordinatTiklama(535,1444,1000);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklama(526,774,3000);
        ReusableMethods.koordinatTiklama(1016,132,3000);
        ReusableMethods.koordinatTiklama(1016,132,3000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        if (!driver.isKeyboardShown()){
            //driver.hideKeyboard();
            //sendKeys yapilabilir.
            driver.getKeyboard().pressKey("Istanbul");

        }else{
            kiwiPage.fromTextBox.sendKeys("Ankara");
        }

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }
}
