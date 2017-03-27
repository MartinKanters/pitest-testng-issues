package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyClassTest {
    @Test
    public void testEven() {
        Assert.assertTrue(MyClass.isEven(2));
    }

    @Test
    public void testOdd() {
        Assert.assertFalse(MyClass.isEven(1));
    }
}
