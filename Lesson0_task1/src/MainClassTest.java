import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{
    @Test
    public void testGetLocalNumber(){
        MainClass main = new MainClass();
        int a = main.getLocalNumber();
        Assert.assertTrue("The return number must be 14", a == 14);

    }

}
