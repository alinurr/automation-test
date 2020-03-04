package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
                SEARCH_LOOP = "css:button#searchIcon";

    }

    public MWSearchPageObject(RemoteWebDriver driver){super(driver);}

}
