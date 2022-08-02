package utils;

public enum App {

    APIAPP("io.appium.android.apis","io.appium.android.apis.ApiDemos");


    public String appPackage;
    public String appActivity;

    App(String appPackage,String appActivity){
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }
}
