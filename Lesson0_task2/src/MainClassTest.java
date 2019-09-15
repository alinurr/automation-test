import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{
    @Test
    public void testGetClassNumber(){
        MainClass main = new MainClass();
        int class_number = main.getClassNumber();
        Assert.assertTrue("The return number is more than 45", class_number > 45);
    }
}
