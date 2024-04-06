package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReadConfig;

public class SteamAboutPage {

    public SteamAboutPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[contains(@class,'menuitem') and contains(text(),'STORE')]")
    private WebElement storeButton;

    @FindBy(xpath = "//*[contains(@class,'gamers_online')]//parent::*[1]")
    private WebElement gamersOnline;

    @FindBy(xpath = "//*[contains(@class, 'gamers_in_game')]//parent::*[1]")
    private WebElement gamersInGame;

    public void clickStore() {
        storeButton.click();
    }


    public int getOnline() {
        String answer = gamersOnline.getText().replaceAll(ReadConfig.getProperty("regex"), "").trim();
        return Integer.parseInt(answer);
    }

    public int getInGame() {
        String answer = gamersInGame.getText().replaceAll(ReadConfig.getProperty("regex"), "").trim();
        return Integer.parseInt(answer);
    }

}
