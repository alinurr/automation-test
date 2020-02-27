package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static{
        TITLE = "xpath:(//XCUIElementTypeStaticText[@name='{TITLE}'])[1]";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MYLIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public iOSArticlePageObject(AppiumDriver driver){super(driver);}
}
