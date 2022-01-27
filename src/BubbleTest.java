import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {
    //this is just leftover code from trying to figure out testing for written constructors
//    @Test
//    public void whenExceptionThrown_thenAssertionSucceeds() {
//        Exception exception = assertThrows(NumberFormatException.class, () -> {
//            Integer.parseInt("1a");
//        });
//
//        String expectedMessage = "For input string";
//        String actualMessage = exception.getMessage();
//        System.out.println(actualMessage);
//        assertTrue(actualMessage.contains(expectedMessage));
//    }

    //maybe run the main method? or try and access the main test method to see what parameters they pass?

    @Test
    public void testConstructorSize(){
        Bubble i = new Bubble(23);
        assertEquals(23, i.getSize(), "size from constructor is expected integer");

        Bubble d = new Bubble(14.2);
        assertEquals(14.2, d.getSize(), "size from constructor is not expected double");
        //tests
        Bubble md = new Bubble(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, md.getSize(), "size from constructor is not expected max double value");

    }
    @Test
    public void testConstructorPopped(){
        assertFalse(b.getIsPopped(), "constructor did not set bubble to be automatically false");
    }

    Bubble b = new Bubble(5); //made new bubble for rest of the test
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
