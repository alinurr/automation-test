package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static  final String
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
        OPTIONS_ADD_TO_MYLIST_BUTTON = "xpath://*[@text='Add to reading list']",
        ADD_TO_MYLIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
        MYLIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
        MYLIST_OK_BUTTON = "xpath://*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForElementTitle()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForElementTitle();
        return title_element.getAttribute("text");
    }

    public void swipeUpToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
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

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }
}
