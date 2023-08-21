package tests.day5;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class allCurrencyConventer {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    // Bu esitlik sayesinde bir onceki derste olusturdugumuz @BeforeTest e ihtiyacimiz kalmadi.
    AppiumDriver<MobileElement> driver2; // bunda  driver.findElementByAndroidUIAutomator yok.

    AllCurrencyConventerPage all = new AllCurrencyConventerPage();


    @Test
    public void allCurrencyTest() throws InterruptedException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir

        String actualUpdateButtonText = all.updateButton.getText();
        System.out.println(actualUpdateButtonText);
        String expected = "CURRENCY\n" +
                "UPDATE";

        Assert.assertEquals(actualUpdateButtonText, expected);


        // cevirmek istedigimiz para birimi zloty olarak secilir

        ReusableMethods.koordinatTiklama(438,337,1000);
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");


        // cevirelecek olan para birimi Tl olarak secilir
        // cevrilen tutar screenShot olarak kaydedilir
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir


    }
}
