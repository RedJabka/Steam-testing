import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SteamItemPage;
import pages.SteamMarketPage;
import utils.ReadConfig;
import utils.Driver;

import java.time.Duration;

public class TestCaseThree extends BaseTestCase {

    @Test
    public static void test() {
        SteamMarketPage marketPage = new SteamMarketPage();
        SteamItemPage itemPage = new SteamItemPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("mainPage")));

        action.moveToElement(mainPage.getCommunityTab());
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("seconds"))));
        action.perform();

        mainPage.clickMarket();
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("seconds"))));
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("marketPage")));

        marketPage.clickOptions();

        String use = ReadConfig.getProperty("testString");

        marketPage.setSearchParams(use);
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("seconds"))));
        marketPage.clickSearch();
        softAssert.assertTrue(marketPage.checkFilters());

        softAssert.assertTrue(marketPage.checkItemsString(use));

        String searchName1 = marketPage.nameFirstItem();

        marketPage.rmInputFilter();
        marketPage.rmGameFilter();

        String searchName2 = marketPage.nameFirstItem();
        softAssert.assertNotEquals(searchName1, searchName2);

        marketPage.clickFirstItem();
        softAssert.assertTrue(Driver.getInstance().getTitle().contains(ReadConfig.getProperty("itemPage")));

        softAssert.assertTrue(itemPage.check(itemPage.getName(), searchName2));
        softAssert.assertTrue(itemPage.check(itemPage.getType(), ReadConfig.getProperty("rarityFilter")));
        softAssert.assertTrue(itemPage.check(itemPage.getUsedBy(), ReadConfig.getProperty("heroFilter")));
        softAssert.assertAll();
    }
}
