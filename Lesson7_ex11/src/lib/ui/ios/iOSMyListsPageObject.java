package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject {
    static{
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name, 'Python')][contains(@name, 'Disambiguation page providing links to topics that could be referred to by the same search term')]";
        SAVED_ARTICLE = "xpath://XCUIElementTypeLink[contains(@name, 'Python molurus')][contains(@name, 'Species of snake')]";
        ARTICLE_DESC = "xpath:(//XCUIElementTypeStaticText[@name='Python molurus'])[2]";
    }

    public iOSMyListsPageObject(AppiumDriver driver){super(driver);}
}
