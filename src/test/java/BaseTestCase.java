import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SteamMainPage;
import utils.Driver;
import utils.ReadConfig;

public class BaseTestCase {
    public static SteamMainPage mainPage;

    public static Actions action;

    @BeforeClass
    public static void setup() {

        mainPage = new SteamMainPage();

        action = new Actions(Driver.getInstance());

        Driver.getInstance().get(ReadConfig.getProperty("url"));
    }

    @Test
    public static void test() {

    }

    @AfterClass
    public static void finish() {

        Driver.getInstance().quit();
    }
}
