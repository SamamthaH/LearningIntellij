import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {

    @Test
    public void testConstructorSizeInteger(){
        Bubble tsci = new Bubble(23);
        assertEquals(23, tsci.getSize(), "size from constructor is expected integer");

    }
    @Test
    public void testConstructorSizeDouble(){
        Bubble tscd = new Bubble(14.2);
        assertEquals(14.2, tscd.getSize(), "size from constructor is not expected double");

    }
    @Test
    public void testConstructorSizeMaxDouble(){
        Bubble tscd = new Bubble(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, tscd.getSize(), "size from constructor is not expected double");

    }
    @Test
    public void testConstructorPopped(){
        assertFalse(b.getIsPopped(), "constructor did not set bubble to be automatically false");
    }

    Bubble b = new Bubble(5);
    @Test
    public void testGetSize(){
        assertEquals(5, b.getSize());
    }

    @Test
    public void testSetSize(){
        b.setSize(7);
        assertEquals(7, b.getSize(), "does not return the correct size");
    }

    @Test
    public void testSetPopped(){
        b.setIsPopped(true);
        assertTrue(b.getIsPopped());
    }

    @Test
    public void testToString(){
        b.setSize(7.2);
        b.setIsPopped(false);
        String s = "size: 7.2 isPopped: false";
        assertEquals(s, b.toString(), "String format is wrong");
    }

}
