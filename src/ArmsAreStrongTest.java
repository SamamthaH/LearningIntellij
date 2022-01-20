import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmsAreStrongTest {
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
    @Test
    public void OutputCheckThreeDigits1() {
        provideInput("153");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"153 is an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }
    @Test
    public void OutputCheckThreeDigits2() {
        provideInput("371");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"371 is an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

    @Test
    public void OutputCheckNotArmstrong1() {
        provideInput("152");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"152 is NOT an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");

    }
    @Test
    public void OutputCheckNotArmstrong2() {
        provideInput("783");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"783 is NOT an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");

    }
    @Test
    public void OutputCheckNegative() {
        provideInput("-153");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"-153 is NOT an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");

    }

}
