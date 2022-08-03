package utils;

public enum Device {

    MyEmulatör("emulator-5554",
            "11",
            "Pixel2",
            "Android"),

    HUAWEI("L2N4C19923015627","11","P30 lite","Android");

    public String udid;
    public String version;
    public String deviceName;
    public String platformName;


    Device(String udid,String version,String deviceName,String platformName){
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }
}
