package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    public ArticlePageObject(AppiumDriver driver){super(driver);}

    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            OPTION_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MYLIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MYLIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MYLIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            OPTION_EXISTED_FOLDER = "//*[@text='{SUBSTRING}']",
            ARTICLE_TITLE = "//*[@text='Apple Inc.']";

    private static String getFolderName(String substring)
    {
        return OPTION_EXISTED_FOLDER.replace("{SUBSTRING}", substring);
    }
    public WebElement waitForElementTitle()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title", 15);
    }

    public String getArticleTitle()
    {
        WebElement element = waitForElementTitle();
        return element.getAttribute("text");
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTION_BUTTON),
                "Cannot find button to find article options",
                10);

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5
        );
        this.waitForElementAndClick(
                By.id(ADD_TO_MYLIST_OVERLAY),
                "Cannot find 'Got it' tip overlay",
                5
        );
        this.waitForElementAndClear(
                By.id(MYLIST_NAME_INPUT),
                "Cannot find input to set name of articles of folder",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MYLIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                By.xpath(MYLIST_OK_BUTTON),
                "Cannot find button 'OK'",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot find X link",
                5
        );
    }

    public void addArticleToExistingList(String substring)
    {
        this.waitForElementAndClick(
                By.xpath(OPTION_BUTTON),
                "Cannot find button to find article options",
                10);

        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find option to add article to reading list",
                5
        );
        String existed_folder = getFolderName(substring);
        waitForElementAndClick(By.xpath(existed_folder), "Cannot find created folder",7);
    }

    public void openArticleByName()
    {
        this.waitForElementAndClick(
                By.xpath(ARTICLE_TITLE),
                "Cannot find article with 'Apple Inc.' name",
                15
        );
    }

    public void assertTitlePresent()
    {
        this.assertElementPresent(
                By.id(TITLE),
                "There is no element with title",
                0
        );
    }
}
