import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class RefactoredTest extends CoreTestCase {

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Glass";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchResultToDisappear();
    }

    @Test
    public void testSaveTwoArticle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' search input",
                5
        );

        String search_line = "Python";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "Cannot find search input 'Search…'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Wikimedia disambiguation page']"),
                "Cannot find article with 'Wikimedia disambiguation page' podtitle",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                10
        );
        waitForElementPresent(
                By.xpath("//*[@text='Change language']"),
                "Cannot find 'CHange language' option",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Share link']"),
                "Cannot find menu 'Share link' option",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find 'Add to reading list' option",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Find in page']"),
                "Cannot find 'Find in page' option",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Font and theme']"),
                "Cannot find 'Font and theme' option",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles of folder",
                5
        );

        String name_of_folder = "Articles about programming languages";

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find button 'OK'",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' search input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "Cannot find search input 'Search…'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='General-purpose, high-level programming language']"),
                "Cannot find article with 'General-purpose, high-level programming language' podtitle",
                15
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                10
        );

        waitForElementPresent(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find menu",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find menu",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find 'Articles about programming languages' folder",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find button with 'My lists'",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='"+ name_of_folder +"']"),
                "Cannot find created folder",
                7
        );

        swipeElementToLeft(
                By.xpath("//*[@text='Wikimedia disambiguation page']"),
                "Cannot find article to delete"
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Python (programming language)']"),
                "Cannot find article",
                8
        );

        WebElement article = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot open article 'Python (programming language'",
                15
        );

        String article_title = article.getAttribute("text");
        Assert.assertEquals(
                "We see unexpected title",
                "Python (programming language)",
                article_title
        );

    }
}
