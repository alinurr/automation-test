package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SaveTwoArticleTest extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveTwoArticle()
    {
        //save first article to my list
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Python";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Wikimedia disambiguation page");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.waitForElementTitle();
            ArticlePageObject.getArticleTitle();
        }else {
            ArticlePageObject.waitForArticleAppearByTitle("Python");
        }


        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        //save second article to my list
        SearchPageObject.initSearchInput();
        //SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Species of snake");

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.waitForElementTitle();
            ArticlePageObject.getArticleTitle();
        }else {
            ArticlePageObject.waitForArticleAppearByTitle("Python molurus");
        }

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete("Python Disambiguation page providing links to topics that could be referred to by the same search term");


        MyListsPageObject.clickSavedArticle();;
        String article_desc = MyListsPageObject.getBoldDescOfSavedArticle();
        assertEquals(
                "We see unexpected title",
                "Python molurus",
                article_desc
        );
    }
}
