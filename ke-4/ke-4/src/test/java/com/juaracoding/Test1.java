package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel 1 API 30");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset", true);

        // URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Instance AndroidDriver
        driver = new AndroidDriver(url, desiredCapabilities);

    }

    @AfterClass
    public void finish() {
        driver.quit();
    }


    @Test
    public void testSub(){
        MobileElement tambahDua = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambahDua.click();
        MobileElement pengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        pengeluaran.click();
        MobileElement kategoriPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        kategoriPengeluaran.click();
        MobileElement pilihKategoriPengeluaran = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView");
        pilihKategoriPengeluaran.click();
        MobileElement jumlahKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahKeluar.sendKeys("75000");
        MobileElement keteranganKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keteranganKeluar.sendKeys("Pengeluaran Tagihan Listrik");
        MobileElement btnSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan.click();

    }

}
