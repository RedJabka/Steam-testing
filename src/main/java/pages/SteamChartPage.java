package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SteamChartPage {

    public SteamChartPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//button[contains(@class, 'DialogButton')]")
    private WebElement buttonMore;

    public void clickMore() {
        buttonMore.click();
    }
}
