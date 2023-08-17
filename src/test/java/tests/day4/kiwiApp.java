package tests.day4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class kiwiApp {


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
        Thread.sleep(750);
        ReusableMethods.koordinatTiklama(303,624, 1000);
        ReusableMethods.koordinatTiklama(535,1444,1000);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklama(526,774,3000);
        ReusableMethods.koordinatTiklama(1016,132,3000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        if (driver.isKeyboardShown()){
            //driver.hideKeyboard();
            //sendKeys yapilabilir.
            driver.getKeyboard().pressKey("Istanbul");

        }else{
            kiwiPage.fromTextBox.sendKeys("Ankara");
        }
        Thread.sleep(750);


        ReusableMethods.koordinatTiklama(628,292,1000);
        kiwiPage.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklama(465,912,1000);

        if (driver.isKeyboardShown()){
            //driver.hideKeyboard();
            //sendKeys yapilabilir.
            driver.getKeyboard().pressKey("Nice");

        }else{
            kiwiPage.fromTextBox.sendKeys("Stockholm");
        }
        Thread.sleep(750);
        ReusableMethods.koordinatTiklama(465,288,1000);
        kiwiPage.chooseButton.click();

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklama(431,1052,1000);
        ReusableMethods.screenScroll(471,1371,850,471,187);
        ReusableMethods.koordinatTiklama(694,800,1000);
        kiwiPage.setDateButton.click();

        // telefonun boyutu degismedigi muddetce bunu hersey icin kullanabiliriz.
        //ReusableMethods.screenScrollDown(1000);

        // search butonuna tiklanir

        Thread.sleep(500);
        kiwiPage.searchButton.click();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir

        ReusableMethods.koordinatTiklama(254,257,500);
        ReusableMethods.koordinatTiklama(502,578,500);
        ReusableMethods.koordinatTiklama(523,257,500);
        ReusableMethods.koordinatTiklama(514,1456,500);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

        String fiyatSon = kiwiPage.fiyatSonucu.getText();
        driver.sendSMS("252222222", "Son fiyat : " + fiyatSon);


    }
}
