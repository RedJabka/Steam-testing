package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReadConfig;

import java.time.Duration;
import java.util.List;

public class SteamMarketPage {

    public SteamMarketPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@class='market_search_advanced_button']")
    private WebElement advanceOptions;

    @FindBy(xpath = "//*[@id='app_option_0_selected']")
    private WebElement gameChoice;

    @FindBy(xpath = "//*[@id='app_option_570']")
    private WebElement dota2;

    @FindBy(xpath = "//*[@name='category_570_Hero[]']")
    private WebElement heroesTab;

    @FindBy(xpath = "//*[@value='tag_npc_dota_hero_life_stealer']")
    private WebElement heroLifestealer;

    @FindBy(xpath = "//*[@id='tag_570_Rarity_Rarity_Immortal']")
    private WebElement immortalCheckbox;

    @FindBy(xpath = "//*[@id='advancedSearchBox']")
    private WebElement inputSearch;

    @FindBy(xpath = "//*[contains(@onclick, 'market_advanced_search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id = 'result_0_name']")
    private WebElement firstItem;

    @FindBy(xpath = "//*[@id = 'result_1_name']")
    private WebElement secondItem;

    @FindBy(xpath = "//*[@id = 'result_2_name']")
    private WebElement thirdItem;

    @FindBy(xpath = "//*[@id = 'result_3_name']")
    private WebElement fourthItem;

    @FindBy(xpath = "//*[@id = 'result_4_name']")
    private WebElement fifthItem;

    @FindBy(xpath = "//*[@class='market_searchedForTerm'][1]")
    private WebElement gameFilter;

    @FindBy(xpath = "//*[@class='market_searchedForTerm'][last()]")
    private WebElement inputFilter;

    @FindBy(xpath = "//*[@class = 'newmodal_background']")
    private WebElement formMarketStatus;

    public void clickOptions() {
        advanceOptions.click();
    }


    public void chooseDota2() {
        gameChoice.click();
        dota2.click();
    }

    public void chooseLifestealer() {
        heroesTab.click();
        heroLifestealer.click();
    }

    public void chooseImmortal() {
        immortalCheckbox.click();
    }

    public void searchInput(String inp) {
        inputSearch.clear();
        inputSearch.sendKeys(inp);
    }

    public void setSearchParams(String inp) {
        chooseDota2();
        Driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfig.getProperty("seconds"))));

        chooseLifestealer();

        chooseImmortal();

        searchInput(inp);
    }

    public void clickSearch() {
        searchButton.click();
    }


    public boolean checkItemsString(String check) {
        check = check.toLowerCase();
        return firstItem.getText().toLowerCase().contains(check) &&
                secondItem.getText().toLowerCase().contains(check) &&
                thirdItem.getText().toLowerCase().contains(check) &&
                fourthItem.getText().toLowerCase().contains(check) &&
                fifthItem.getText().toLowerCase().contains(check);
    }


    public void rmGameFilter() {
        gameFilter.click();
    }


    public void rmInputFilter() {
        inputFilter.click();
    }

    public List<WebElement> getFilters() {
        return Driver.getInstance().findElements(By.xpath("/*[@class='market_searchedForTerm']"));
    }

    public void clickFirstItem() {
        firstItem.findElement(By.xpath("./..")).click();
    }

    public boolean checkMarketForm() {
        return formMarketStatus.getAttribute(ReadConfig.getProperty("style")).contains(ReadConfig.getProperty("formOpened"));
    }

    public boolean checkFilters(){
           return Driver.getInstance().getTitle().contains(ReadConfig.getProperty("gameFilter")) && Driver.getInstance().getTitle().contains(ReadConfig.getProperty("heroFilter")) && Driver.getInstance().getTitle().contains(ReadConfig.getProperty("rarityFilter")) && Driver.getInstance().getTitle().contains(ReadConfig.getProperty("testString"));
    }

    public String nameFirstItem() {
        return firstItem.getText();
    }

}
