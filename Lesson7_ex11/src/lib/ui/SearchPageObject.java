package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject{ //abstract так как объект этого класса мы уже создавать не будем

     protected static String //protected для того чтобы мы могли использовать эти переменные в других классах
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    //TEMPLATES METHODS
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    //TEMPLATES METHODS

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"Cannot find and click search init element",5);
        //this.waitForElementPresent(SEARCH_INPUT,"Cannot find search input after clicking search init element", 7);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 10);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 20);
    }

}
