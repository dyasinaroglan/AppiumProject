package gun03;

import io.cucumber.java.Before;
import org.junit.jupiter.api.BeforeAll;
import utils.App;
import utils.Device;

import static utils.Utils.openApp;

public class Hooks {

    @BeforeAll   //feature de çalıştırmak için
    public static void beforeAll(){
        openApp(Device.HUAWEI, App.CALCULATOR);
    }
}
