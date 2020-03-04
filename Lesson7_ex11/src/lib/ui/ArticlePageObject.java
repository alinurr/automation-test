package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject{
    protected static String
        TITLE,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MYLIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        ADD_TO_MYLIST_OVERLAY,
        MYLIST_NAME_INPUT,
        MYLIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForElementTitle()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 20);
    }

    private static String getArticleTitleByXpath(String article_title)
    {
        return TITLE.replace("{TITLE}", article_title);

    }

    public void waitForArticleAppearByTitle(String article_title)
    {
        String article_id = getArticleTitleByXpath(article_title);
        this.waitForElementPresent(article_id, "Cannot find article by title " + article_title, 10);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForElementTitle();
        if (Platform.getInstance().isAndroid())
        {
            return title_element.getAttribute("text");
        }else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        }else {
            return title_element.getText();
        }

    }


    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                10
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MYLIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MYLIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );
        this.waitForElementAndClear(
                MYLIST_NAME_INPUT,
                "Cannot find input to set name of articles of folder",
                5
        );

        this.waitForElementAndSendKeys(
                MYLIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                MYLIST_OK_BUTTON,
                "Cannot find button 'OK'",
                5
        );


    }

    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMW()){
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MYLIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    public void removeArticleFromSavedIfItAdded()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MYLIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }

    public void closeArticle()
    {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );
        }else {
            System.out.println("Method closeArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }


}
