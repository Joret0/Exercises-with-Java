package bubble_sort_test;

import bubble_sort.Bubble;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTests {
    @Test
    public void testBubbleSort() {
        int[] inputArray = { 4, 3, -222, 213, 2, 1, 2, 3, 2};
        String expected = "[213, 4, 3, 3, 2, 2, 2, 1, -222]";

        Bubble.sort(inputArray);
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }
}
