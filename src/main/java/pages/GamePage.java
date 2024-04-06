package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReadConfig;

public class GamePage {

    public GamePage() {
        PageFactory.initElements(Driver.getInstance(), this);

    }


    @FindBy(xpath = "//*[@id='appHubAppName']")
    private WebElement name;

    @FindBy(xpath = "//*[@class='date']")
    private WebElement date;

    @FindBy(xpath = "//*[contains(@class, 'game_purchase_price')]")
    private WebElement price;

    public String gameName() {
        return name.getText();
    }

    public String gameDate() {
        return date.getText();
    }

    public int gamePrice() {
        return Integer.parseInt(price.getAttribute(ReadConfig.getProperty("@gamePrice")));
    }
}
