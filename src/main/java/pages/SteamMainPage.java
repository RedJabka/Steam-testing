package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SteamMainPage {

    public SteamMainPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[contains(@class,'menuitem') and contains(text(),'About')]")
    private WebElement aboutButton;
    @FindBy(xpath = "//*[@id='noteworthy_tab']/*[@class='pulldown']")
    private WebElement noteWorthyTab;
    @FindBy(xpath = "//*[@id='noteworthy_flyout']//*[@class='popup_menu_item' and contains(text(), 'Sellers')]")
    private WebElement topSellers;
    @FindBy(xpath = "//*[contains(@class,'menuitem') and contains(text(),'COMMUNITY')]")
    private WebElement communityTab;
    @FindBy(xpath = "//*[contains(@aria-label,'Global')]//*[contains(@href,'market')]")
    private WebElement market;

    public void clickAbout() {
        aboutButton.click();
    }


    public WebElement getNoteWorthyTab() {
        return noteWorthyTab;
    }


    public void clickTopSellers() {
        topSellers.click();
    }


    public WebElement getCommunityTab() {
        return communityTab;
    }


    public void clickMarket() {
        market.click();
    }
}
