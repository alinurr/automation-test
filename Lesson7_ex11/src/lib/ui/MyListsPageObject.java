package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String
        FOLDER_BY_NAME_TPL,
        ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);//берет созданную нами константу и заменяет шаблон {} на данные переданные в name_of_folder
    }

    private static String getSavedArticleIdByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleIdByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title " + article_title,15);
    }

    public void waitForArticleDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleIdByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title " + article_title,15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleAppearByTitle(article_title);
        String article_xpath = getSavedArticleIdByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );

        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForArticleDisappearByTitle(article_title);
    }

    public void clickSavedArticle(String article_title)
    {
        String article_xpath = getSavedArticleIdByTitle(article_title);
        this.waitForElementAndClick(
                article_xpath,
                "Cannot find second article after deleting first one",
                5
        );
    }
}
