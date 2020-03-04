package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SaveTwoArticleTest extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "alinurr",
            password = "alinurR8705";
    @Test
    public void testSaveTwoArticle()
    {
        //save first article to my list
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Python";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("ikimedia disambiguation page");

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

        if (Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForElementTitle();

            assertEquals("We are not on the same page after login",
                    "Python",
                    ArticlePageObject.getArticleTitle()
            );

            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        //save second article to my list
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            SearchPageObject.initSearchInput();
        }else {
            SearchPageObject.searchFromArticlePage();
            SearchPageObject.typeSearchLine(search_line);
        }
        SearchPageObject.clickByArticleWithSubstring("pecies of snake");

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
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
            MyListsPageObject.swipeByArticleToDelete("Python Disambiguation page providing links to topics that could be referred to by the same search term");
        }else {
            MyListsPageObject.swipeByArticleToDelete("Python");
        }

        MyListsPageObject.clickSavedArticle();
        MyListsPageObject.assertLeftArticle();

    }
}
