import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SteamAboutPage;
import utils.Driver;
import utils.ReadConfig;


public class TestCaseOne extends BaseTestCase {
    @Test
    public static void test() {
        SoftAssert softAssert = new SoftAssert();

        SteamAboutPage aboutPage = new SteamAboutPage();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("mainPage")));

        mainPage.clickAbout();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("aboutPage")));

        int online = aboutPage.getOnline();
        int inGame = aboutPage.getInGame();
        softAssert.assertTrue(online >= inGame, "There are more online players than online users as expected");

        aboutPage.clickStore();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("mainPage")));

        softAssert.assertAll();
    }

}
