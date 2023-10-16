package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 30");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity","com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement plus = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        plus.click();
        MobileElement msk = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        msk.click();
        MobileElement tglMasuk = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        tglMasuk.click();
        MobileElement TanggalMasuk = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"29 Oktober 2023\"]");
        TanggalMasuk.click();
        MobileElement simpanTanggalMasuk = (MobileElement) driver.findElementById("android:id/button1");
        simpanTanggalMasuk.click();
        MobileElement kategoriPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        kategoriPemasukan.click();
        MobileElement pilihKategoriMasuk = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
        pilihKategoriMasuk.click();
        MobileElement jumlahMasuk = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahMasuk.sendKeys("500000");
        MobileElement keterangan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keterangan.sendKeys("Uang Jajan");
        MobileElement btSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btSimpan.click();
        assertEquals(keterangan, "Uang Jajan");

        MobileElement tambahDua = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambahDua.click();
        MobileElement tglKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        tglKeluar.click();
        MobileElement simpanTanggalKeluar = (MobileElement) driver.findElementById("android:id/button1");
        simpanTanggalKeluar.click();
        MobileElement kategoriPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        kategoriPengeluaran.click();
        MobileElement pilihKategoriPengeluaran = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView");
        pilihKategoriPengeluaran.click();
        MobileElement jumlahKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahKeluar.sendKeys("75000");
        MobileElement keteranganKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keteranganKeluar.sendKeys("Tagihan Pinjol");
        MobileElement btnSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan.click();
    }

        public static void assertEquals (String actual, String expected){
            if (actual.equals(expected)){
                System.out.println("Passes");
            } else {
                System.out.println("Failed");
            }
    }

}