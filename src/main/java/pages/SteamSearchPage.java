package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReadConfig;

public class SteamSearchPage {

    public SteamSearchPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@data-collapse-name='os']")
    private WebElement osTab;

    @FindBy(xpath = "//*[contains(@data-loc,'Linux')]//*[@class='tab_filter_control_checkbox']")
    private WebElement linuxCheckbox;

    @FindBy(xpath = "//*[@data-collapse-name='category3']")
    private WebElement playersNumTab;

    @FindBy(xpath = "//*[contains(@data-loc,'LAN') and contains(@data-loc,'Co-op')]//*[@class='tab_filter_control_checkbox']")
    private WebElement coopCheckbox;

    @FindBy(xpath = "//*[@data-collapse-name='tags']")
    private WebElement tagTab;

    @FindBy(xpath = "//*[contains(@data-loc, 'Action') and @data-value=19]//*[@class='tab_filter_control_checkbox']")
    private WebElement actionCheckbox;

    @FindBy(xpath = "//*[@id='search_resultsRows']//*")
    private WebElement firstGame;

    public void setLinuxCheckbox() {
        if (!verifyOpenDropdown(osTab)) {
            osTab.click();
        }
        linuxCheckbox.click();
    }


    public void setCoopCheckbox() {
        if (!verifyOpenDropdown(playersNumTab)) {
            playersNumTab.click();
        }
        coopCheckbox.click();
    }

    public void setActionCheckbox() {
        if (!verifyOpenDropdown(tagTab)) {
            tagTab.click();
        }
        actionCheckbox.click();
    }

    public static boolean verifyOpenDropdown(WebElement dropdown) {
        String attribute = dropdown.getAttribute("class");
        return !attribute.contains("collapsed");
    }


    public void clickFirstGame() {
        firstGame.click();
    }

    public String firstGameName() {
        WebElement attribute = firstGame.findElement(By.xpath("//*[@class='title']"));
        return attribute.getText();
    }

    public String firstGameDate() {
        WebElement attribute = firstGame.findElement(By.xpath("//*[contains(@class, 'search_released')]"));
        return attribute.getText();
    }

    public int firstGamePrice() {
        int attribute = Integer.parseInt(firstGame.findElement(By.xpath("//*[contains(@class,'search_discount_block')]")).getAttribute(ReadConfig.getProperty("@gamePrice")));
        return attribute;
    }

    public static void waitTen() {
        long startLoadingTime = System.currentTimeMillis();
        long waitingTime = 0;
        while (true) {
            if (waitingTime <= 1000) {
                waitingTime = System.currentTimeMillis() - startLoadingTime;
            } else {
                break;
            }
        }
    }

    public boolean checkLinuxCheckbox() {
        return linuxCheckbox.findElement(By.xpath("./../..")).getAttribute("class").contains("checked");
    }

    public boolean checkCoopCheckbox() {
        return coopCheckbox.findElement(By.xpath("./../..")).getAttribute("class").contains("checked");
    }

    public boolean checkActionCheckbox() {
        return actionCheckbox.findElement(By.xpath("./../..")).getAttribute("class").contains("checked");
    }
}

