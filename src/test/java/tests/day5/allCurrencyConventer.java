package tests.day5;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class allCurrencyConventer {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    // Bu esitlik sayesinde bir onceki derste olusturdugumuz @BeforeTest e ihtiyacimiz kalmadi.
    /*
        AppiumDriver<MobileElement> driver2;
        Burda driver2 de driver.findElementByAndroidUIAutomator degeri Appium driver da olmadigi icin
        android cihazlarda driver olarak Android Driver i kullaniyoruz.
    */


    AllCurrencyConventerPage all = new AllCurrencyConventerPage();


    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {

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
        ReusableMethods.koordinatTiklama(428,490,1000);
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");
        ReusableMethods.scrollWithUiScrollableAndClick("1");
        ReusableMethods.scrollWithUiScrollableAndClick("000");
        Thread.sleep(1000);
        // cevrilen tutar screenShot olarak kaydedilir

        /*                  1. yontem
        File ekranKaydi = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranKaydi, new File("CeviriSonuc.jpg"));
        */


        // 2. yontem

        ReusableMethods.getScreenshot("ZlotyToTL");

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String exchangeResult = all.result.getText();
        driver.sendSMS("123456799", exchangeResult);


        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir


    }
}
