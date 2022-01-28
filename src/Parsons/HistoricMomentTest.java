package Parsons;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoricMomentTest {
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
    @Test
    public void ADTest(){
        String[] inputs = {"11 true", "55 true", "2021 true"};
        String[] outputs = {
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "11 AD - 1 = 10 AD " + System.lineSeparator(),
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "55 AD - 1 = 54 AD " + System.lineSeparator(),
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "2021 AD - 1 = 2020 AD " + System.lineSeparator()
        };

        for (int x = 0; x < inputs.length; x++) { //for loop runs through the arrays for each test

            provideInput(inputs[x]);

            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency

            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            HistoricMoment.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not work for various AD inputs");
        }
    }
    @Test
    public void BCTest(){
        String[] inputs = {"7 false", "340 false", "1234 false"};
        String[] outputs = {
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "7 BC- 1 = 8 BC " + System.lineSeparator(),
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "340 BC- 1 = 341 BC " + System.lineSeparator(),
                "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ "1234 BC- 1 = 1235 BC " + System.lineSeparator()
        };

        for (int x = 0; x < inputs.length; x++) { //for loop runs through the arrays for each test

            provideInput(inputs[x]);

            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency

            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            HistoricMoment.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not work for various BC inputs");
        }
    }

    @Test
    public void inputADTest(){
        String input = "5 AD";
        provideInput(input);
        assertThrows(InputMismatchException.class, () -> HistoricMoment.main(new String[0]), "Your program should not accept strings in the place of booleans");

    }
    @Test
    public void inputDecimalTest(){
        String input = "5.2 false";
        provideInput(input);
       assertThrows(InputMismatchException.class, () -> HistoricMoment.main(new String[0]), "Your program should not accept doubles for years");



    }

    @Disabled("Implementation of 1 BC to 1 AD in test code not currently supported")
    @Test
    public void oneADTest(){
        String input = "1 true";
        String expected = "Enter a year: "+System.lineSeparator()+"Is it AD or BC? (Enter true for AD and false for BC) "+System.lineSeparator()+ 1 + " AD - 1 = " + "1 BC" + System.lineSeparator();

        provideInput(input);

        HistoricMoment.main(new String[0]);

        String actual = getOutput();


        assertEquals(expected, actual, "0 AD is not a year");
    }
}
