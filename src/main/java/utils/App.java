package utils;

public enum App {

    APIAPP("io.appium.android.apis","ApiDemos"),
    CALCULATOR("com.sec.android.app.popupcalculator","calculator");

    public String appPackage;
    public String appActivity;

    App(String appPackage,String appActivity){
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }
}
