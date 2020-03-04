package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static{
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]";
        SAVED_ARTICLE = "css:#content h3";
        ARTICLE_DESC = "css:section#mf-section-0 p i b";
    }

    public MWMyListsPageObject(RemoteWebDriver driver){super(driver);}
}
