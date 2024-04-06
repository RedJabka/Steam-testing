import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GamePage;
import pages.SteamChartPage;
import pages.SteamSearchPage;
import utils.Driver;
import utils.ReadConfig;

import java.time.Duration;

public class TestCaseTwo extends BaseTestCase {

    @Test
    public static void test() {

        SteamSearchPage searchPage = new SteamSearchPage();
        SteamChartPage chartPage = new SteamChartPage();
        GamePage gamePage = new GamePage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("mainPage")));

        action.moveToElement(mainPage.getNoteWorthyTab());
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("seconds"))));
        action.perform();

        mainPage.clickTopSellers();
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("longSeconds"))));
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("chartPage")));

        chartPage.clickMore();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("searchPage")));

        searchPage.setLinuxCheckbox();
        softAssert.assertTrue(searchPage.checkLinuxCheckbox());

        searchPage.setCoopCheckbox();
        softAssert.assertTrue(searchPage.checkCoopCheckbox());

        searchPage.setActionCheckbox();
        softAssert.assertTrue(searchPage.checkActionCheckbox());

        SteamSearchPage.waitTen();

        String searchName = searchPage.firstGameName();

        String searchDate = searchPage.firstGameDate();

        int searchPrice = searchPage.firstGamePrice();

        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("longSeconds"))));
        searchPage.clickFirstGame();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("gamePage")));


        String gameName = gamePage.gameName();
        String gameDate = gamePage.gameDate();
        int gamePrice = gamePage.gamePrice();

        softAssert.assertEquals(searchName, gameName);
        softAssert.assertEquals(searchDate, gameDate);
        softAssert.assertEquals(searchPrice, gamePrice);
        softAssert.assertAll();
    }
}
