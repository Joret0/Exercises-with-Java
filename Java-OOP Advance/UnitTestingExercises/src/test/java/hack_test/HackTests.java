package hack_test;

import org.junit.Assert;
import org.junit.Test;

public class HackTests {

    @Test
    public void absShouldReturnAbsoluteValue() {
        Assert.assertEquals(50, Math.abs(-50));
    }
}
