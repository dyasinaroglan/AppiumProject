Appium

1.  IDE gerekli (Android Studio, IntelliJ)
2.  JAVA SDK gerekli (JAVA_HOME olarak environmet variable'a eklenirse iyi olur.
    Normalde kurulum Path kismina ekleyecektir)
3.  Android SDK lazim
    a.  Android Strudio kurulursa otomatik kurulur
    b.  IntelliJ icinde yeni proje olarak Android secilirse, Android SDK kurulu degilse kurulmasi icin uyarir.
        Buradan Android SDK kurulabilir.
        Normalde c:\users\{kullanici}\AppData\Local\Android\Sdk

    Android yolunun environmet variable icine ANDROID_HOME olarak eklenmesi gerekir.

4.  Appium kurulumu
    a.  Appium Gui ile kurulabilir.
        Bir windows uygulamasidir. Install edilir.
    b.  npm ile yüklenebir.
        npm icin, nodejs kurulmali. Nodejs indirilir ve kurulur.
        (c:\Program Files\Nodejs) Kurulum sonrasi bu yol Path'e otomatik yazilir.
        consolda   "" npm install appium -g  "" yazarak appium kurulur.
        Appium :  c:\users\{kullanici}\AppData\Roaming\npm\node_modules\appium\lib
        Bu yol da environmets variable icin APPIUM_HOME olarak girilmeli

5.  Appium inspector
    Google aratilir. Install dosyasi indirilir ve kurulur.
    Cep telefonu ya da Emülatöre baglanmak icin Appium calistirilmali.
    Uygulamada istenen gerekli olan desired capabilities girilmeli.
    {
      "appium:udid": "emulator-5554",
      "appium:version": "11",
      "appium:deviceName": "GalaxyNexus720x1280_API30",
      "appium:realDevice": false,
      "platformName": "Android"
    }

6.  Android SDK kurulunca IntelliJ de Tools-->Android-->AVD Manager calistirilir.
    Acilan pencereden istenilen Emülatör olusturulup kullanilir.
    Emülatör kurulumu sonrasi, üst menüde sanal disk uyarisi cikar. Bu link ile sanal disk olusturulmali.
    Böylece emülatör icinde dosya indirme islemleri yapilabilir.

7.  adb devices
    Android SDK ile birlikte gelir (Android\Sdk\platform_tools)
    consolda "" >adb devices "" yazilirsa bilgisayara bagli tüm cihazlari verir

    Android Cep telefonunun Developer modu acik ve USB Debugging acik olmali
    Developer mode  Ayarlar-->Telefon Bilgisi-->Build Number'a 7-8 defa tiklayarak acilir.
    Developer mode acilinca  Ayarlar altinda en altta yer alir. Buradan USB Debugging acilmali.
    USB Debugging acildiktan sonra ">adb devices" komutu ile cihaz görülebilir.

    consolda asagidaki gibi cikti olmali.

    >adb devices {ENTER}
    ZTRGF3235   device

    ZTRGF3235 : Bagli cihazin udid'i


    cep tel'in ip'si 192.168.1.23 ise
    cep telefonu bilgisayara bagli iken Consolda
    >adb tcpip 5555 {ENTER}     // 5555 sart degil herhangi bir port
    cep telefonu bilgisayardan cikartilir
    >adb connect 192.168.1.23:5555 {ENTER}    //  ile cep telefonuna wifi ile baglanilir

    >adb devices {ENTER}        // yapilirsa
    192.168.1.23:5555  device   // bu sekilde cikti olur.

    >adb disconnect 192.168.1.23:5555       // ile baglanti kesilir

8.  Apk info
    Appium testi icin cihaz ve test edilecek uygulama bilgileri gerekli.
    Cihaz bilgiler üstte verildi.
    Uygulama icin desired capability olarak "appPackage" ve "appActivity" gerekli
    Bu ise basit olarak, play storedan indirilecek "AppInfo" uygulamasi ile bulunur.