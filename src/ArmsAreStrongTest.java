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
    //start of actual tests
    @Test
    public void OutputCheckThreeDigits() {
        String[] inputs = {"153", "371", "407"};
        String[] outputs = {"Enter a number: " + System.lineSeparator() +"153 is an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"371 is an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"407 is an Armstrong Number!"+ System.lineSeparator()};

        for(int x = 0; x<inputs.length; x++){ //for loop runs through the arrays for each test
            provideInput(inputs[x]);
            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency
            for(int y = 0; y<=x; y++){ //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            ArmsAreStrong.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not recognize a 3 number armstrong number as valid");
        }

    }

    @Disabled("No functionality for four digits in the current code")
    @Test
    public void OutputCheckfourdigits() {
        String[] inputs = {"1634", "8208", "9474"};
        String[] outputs = {"Enter a number: " + System.lineSeparator() +"1634 is an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"8208 is an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"9474 is an Armstrong Number!"+ System.lineSeparator()};

        for(int x = 0; x<inputs.length; x++) { //for loop runs through the arrays for each test
            provideInput(inputs[x]);
            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency
            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            ArmsAreStrong.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not recognize a 4 number armstrong number as valid");
        }
    }

    @Test
    public void OutputCheckNotArmstrong() { //make two arrays with input and output and loop through
        String[] inputs = {"152", "783", "46"};
        String[] outputs = {"Enter a number: " + System.lineSeparator() +"152 is NOT an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"783 is NOT an Armstrong Number!"+ System.lineSeparator(),
                "Enter a number: " + System.lineSeparator() +"46 is NOT an Armstrong Number!"+ System.lineSeparator()};

        for(int x = 0; x<inputs.length; x++) { //for loop runs through the arrays for each test
            provideInput(inputs[x]);
            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency
            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            ArmsAreStrong.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program recognizes an invalid number as valid");
        }

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
        assertEquals(expectedOut, actualOutput, "Your program recognizes negative numbers as armstrong");

    }
    @Test
    public void OutputCheckZero(){
        provideInput("0");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"0 is an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "Your program does not recognize 0 as an armstrong number");
    }
    @Test
    public void OutputCheckOne(){
        provideInput("1");

        String expectedOut = "Enter a number: " + System.lineSeparator() +"1 is an Armstrong Number!"+ System.lineSeparator();
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "Your program does not recognize 1 as an armstrong number");
    }

}
