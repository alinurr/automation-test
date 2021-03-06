import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

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
        //save first article to my list
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Python";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Wikimedia disambiguation page");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.getArticleTitle();
        String name_of_folder = "Articles about programming languages";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        //save second article to my list
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        driver.hideKeyboard();
        SearchPageObject.clickByArticleWithSubstring("Syntax of the Python programming language");

        ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToExistingList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete("Wikimedia disambiguation page");
        MyListsPageObject.clickSavedArticle();;
        String article_title = ArticlePageObject.getArticleTitle();
        assertEquals(
                "We see unexpected title",
                "Python syntax and semantics",
                article_title
        );
    }


    @Test
    public void testAssertTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.openArticleByName();
        ArticlePageObject.assertTitlePresent();
    }

}
