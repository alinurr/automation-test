package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static{
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";//значение xpath с какой-то секцией, которую легко будет поменять
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
    }
    public AndroidMyListsPageObject(AppiumDriver driver){super(driver);}
}
