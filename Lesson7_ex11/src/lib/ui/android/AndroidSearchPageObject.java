package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
     static {
         SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
         SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
         SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
     }


    public AndroidSearchPageObject(RemoteWebDriver driver){super(driver); }
}
