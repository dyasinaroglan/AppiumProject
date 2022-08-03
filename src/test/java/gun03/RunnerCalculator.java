package gun03;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.App;
import utils.Device;

import static utils.Utils.openApp;

@CucumberOptions(
        features = {"src/test/java/gun03/MyStepdefs.java"},
        glue = {"gun03"},
        tags = "@Sum"

)

         /*
         bu neden sadece gun03 den alıyor? çünkü ben feature dosyalarını herhangi bir yere yazabilirim

           o yüzden feature dosyaları java dosyaları olmadığı için path'ı baştan itibaren vermem lazım
        ama herhangi bir java dosyasını test'in altına ya da main'ın altına yazamam. illa java'nın içine yazmam gerekir

         glue ise stepDef leri içeriyor. StepDef'ler java class'ları değil mi? evet java class'ları
         ama features herhangi bir yerde yazılabilir

           */


public class RunnerCalculator extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters({"device"})
    public void beforeTest(@Optional("") String device) {
        Device.
        if (device.length() == 0)
            openApp(Device.HUAWEI, App.CALCULATOR);
        else
            openApp(Device.valueOf(device), App.CALCULATOR);
    }
}
