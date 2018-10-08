
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private static EnhancedAndroidDriver<MobileElement> driver;

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

        File fileLocation = new File("<PATH_TO_APP>");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, fileLocation.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:8000/wd/hub");
        driver = Factory.createAndroidDriver(url, desiredCapabilities);
    }

    @Test
    public void someTest(){
        Assert.assertTrue("Yeah, really", true);
    }

    @After
    public void TearDown() {
        driver.label("Stopping App");
        driver.quit();
    }


}
