package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SteamItemPage { ;

    public SteamItemPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@class = 'descriptor'][1]")
    private WebElement usedBy;

    @FindBy(xpath = "//*[@id = 'largeiteminfo_item_name']")
    private WebElement name;
    @FindBy(xpath = "//*[@id = 'largeiteminfo_item_type']")
    private WebElement type_rarity;

    public WebElement getUsedBy() {
        return usedBy;
    }


    public WebElement getName() {
        return name;
    }


    public WebElement getType() {
        return type_rarity;
    }

    public boolean check(WebElement web, String name) {
        return web.getText().toLowerCase().contains(name.toLowerCase());
    }
}
