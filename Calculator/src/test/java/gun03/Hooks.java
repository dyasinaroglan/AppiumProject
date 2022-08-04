package gun03;

import org.junit.jupiter.api.BeforeAll;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Hooks {   //cucumberı çalıştırdığımda ilk hooks çalışacak

    @BeforeAll   //feature de çalıştırmak için   beforeAllScenarios
    public static void beforeAll(){   //senaryolardan önce çalışır
        if(Driver.getDriver() == null)  //null değilse zaten testNG den gelmiştir, tanımlıdır. ilk testNG çalışır
        openApp(Device.HUAWEI, App.CALCULATOR);
    }
}
