package Parsons;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavademicTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    //actual tests start now
    //theoretical approach: check up front whether the answer is correct
    //then break it down further so they know which area is incorrect
    @Test
    public void testOutput(){
        //this section of code runs the main method and stores the output in a string
        Javademic.main(new String[0]);
        String output = getOutput();

        //now we check the string against what we know the expected output to be
        //slight issue, google calculator says 13099.9782182
        String expected = "Num cases of infections in " + 30 + " days is " + 13099.97821824974 + " people"+ System.lineSeparator();

        assertEquals(output, expected, "The string does not match expected output");
    }

    @Test
    public void rAddition(){
        //actual question has 0.3 as r
        double[] expected = {1.2, 1.3, 1.7};
        double[] use = {.2, .3, .7};
        for(int x = 0; x<3; x++){
            double actual = 1+use[x];

            assertEquals(expected[x], actual, "Positive addition is not working");
        }
    }

    @Test
    public void rNegativeAddition(){
        double[] expected = {.2, -0.3, .6};
        double[] use = {-0.8, -1.3, -0.4};
        for(int x = 0; x<3; x++){
            double actual = 1+use[x];

            //used modified assertEquals with delta because there was a slight error that broke the program because of a tiny decimal
            assertEquals(expected[x], actual, 0.000001, "Negative addition is not working");
        }
    }

    @Test
    public void powerOfTTest(){
        //actual question has 30 as t
        double[] expected = {2619.99564365, 3.71293, 9727.86042518};
        double[] use = {30, 5, 35};
        for(int x = 0; x<3; x++){
            //using 1.3 because that is the value in the original program
            double actual = Math.pow(1.3, use[x]);

            //used modified assertEquals with delta because there was a slight error that broke the program because of a tiny decimal
            assertEquals(expected[x], actual, 0.000001, "Power function not working");
        }
    }

    @Test
    public void multiplicationTest(){

        double[] expected = {13099.9782182, 26199.9564365, 34059.9433674};
        double[] use = {5, 10, 13};
        for(int x = 0; x<3; x++){
            //using 1.3 because that is the value in the original program
            double actual = 2619.99564365*use[x];

            //used modified assertEquals with delta because there was a slight error that broke the program because of a tiny decimal
            assertEquals(expected[x], actual, 0.000001, "Multiplication not working");
        }
    }
}
