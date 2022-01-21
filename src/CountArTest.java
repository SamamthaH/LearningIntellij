import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//switch to using assertArrayEquals
//implement one that is random each time
public class CountArTest {
    @Test
    public void methodAll0s(){
        String expected = "[10, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        String actual = Arrays.toString(CountAR.countThisPlease(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertEquals(expected, actual, "Something messed up");
    }
    @Test
    public void methodTestRandomNums(){
        String expected = "[1, 2, 3, 0, 1, 1, 1, 0, 0, 1]";
        String actual = Arrays.toString(CountAR.countThisPlease(new int[]{2, 2, 4, 2, 1, 9, 5, 1, 6, 0}));
        assertEquals(expected, actual, "Something messed up");
    }
    @Test
    public void testExample(){
        String expected =  "[0, 1, 0, 2, 3, 1, 0, 2, 0, 3]";
        String actual = Arrays.toString(CountAR.countThisPlease(new int[]{ 1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3 }));
        assertEquals(expected, actual, "Something messed up");
    }
    @Test
    public void methodOutOfBoundsException(){
        try{
            CountAR.countThisPlease(new int[]{10, 10, 10, 9, 2,3,4,5,1,7, 5});
            fail("Array is larger than it should be");
        }
        catch (IndexOutOfBoundsException e){
           assertTrue(true);
        }
    }
    @Test
    public void methodPassingAnArrayLargerThan10(){
        String expected = "[1, 2, 3, 0, 1, 1, 1, 1, 0, 1]";
        String actual = Arrays.toString(CountAR.countThisPlease(new int[]{2, 2, 4, 2, 1, 9, 5, 1, 6, 0, 7}));
        assertEquals(expected, actual, "Your program did not count all the passed numbers");
    }
    @Test
    public void methodPassArrayOfLargestIntZeros(){
        String expected = "[100, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        String actual = Arrays.toString(CountAR.countThisPlease(new int[100]));
        assertEquals(expected, actual, "Your program did not count all the passed numbers");
    }

}
