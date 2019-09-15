import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{
    @Test
    public void testGetClassString(){
        MainClass main = new MainClass();
        String class_string = main.getClassString();
        if (class_string.contains("hello")){
            Assert.assertTrue("The string contains substring 'hello'", class_string == "Hello, world");
        }
        else if (class_string.contains("Hello")){
            Assert.assertTrue("The string contains substring 'Hello'",class_string == "Hello, world");
        }
        else {
            Assert.fail("The string doesn't contain substrings 'hello' or 'Hello'");
        }

    }
}
