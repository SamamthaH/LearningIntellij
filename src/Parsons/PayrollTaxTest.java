package Parsons;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayrollTaxTest {
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

    //note, each run through requires three inputs:
    //hours, wage, and tax rate
    //write a test that loops through variances of one variables while keeping the other two static
    //because of the framing of the question, negative numbers should not apply

    @Test
    public void alternateHoursTest() {

        String[] inputs = {"1 18 0.12", "8 18 0.12", "22 18 0.12"};
        String baseOutput = "How many hours have you worked?" + System.lineSeparator() + "What is your hourly wage?" + System.lineSeparator()
                + "What is the tax rate? (Enter 0.12 for 12%)" + System.lineSeparator();
        String[] outputs = {
                "Pay Amount: " + 18.0 + System.lineSeparator() + "Tax Amount: " + 2.16 + System.lineSeparator() + "Net Earnings: " + 15.84 + System.lineSeparator(),
                "Pay Amount: " + 144.0 + System.lineSeparator() + "Tax Amount: " + 17.28 + System.lineSeparator() + "Net Earnings: " + 126.72 + System.lineSeparator(),
                "Pay Amount: " + 396.0 + System.lineSeparator() + "Tax Amount: " + (22*18*0.12) + System.lineSeparator() + "Net Earnings: " + 348.48 + System.lineSeparator()
        };


        for (int x = 0; x < inputs.length; x++) { //for loop runs through the arrays for each test

                provideInput(inputs[x]);

            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency

            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(baseOutput);
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            PayrollTax.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not accept various hour inputs");
        }
    }
    @Test
    public void zeroHoursTest(){
        String input = "0 8 0.12";
        String expectedOutput = "How many hours have you worked?" + System.lineSeparator() + "What is your hourly wage?" + System.lineSeparator()
                + "What is the tax rate? (Enter 0.12 for 12%)" + System.lineSeparator() + "Pay Amount: " + 0.0 + System.lineSeparator() +
                "Tax Amount: " +0.0 + System.lineSeparator() + "Net Earnings: " + 0.0 + System.lineSeparator();
        provideInput(input);
        PayrollTax.main(new String[0]);
        String actualOutput = getOutput();

        assertEquals(expectedOutput, actualOutput, "Your program does not accept 0 hours");

    }
    @Test
    public void alternateWageTest() {

        String[] inputs = {"5 5 0.12", "5 10 0.12", "5 19 0.12"};
        String baseOutput = "How many hours have you worked?" + System.lineSeparator() + "What is your hourly wage?" + System.lineSeparator()
                + "What is the tax rate? (Enter 0.12 for 12%)" + System.lineSeparator();
        String[] outputs = {
                "Pay Amount: " + 25.0 + System.lineSeparator() + "Tax Amount: " + 3.0 + System.lineSeparator() + "Net Earnings: " + 22.0 + System.lineSeparator(),
                "Pay Amount: " + 50.0 + System.lineSeparator() + "Tax Amount: " + 6.0 + System.lineSeparator() + "Net Earnings: " + 44.0 + System.lineSeparator(),
                "Pay Amount: " + 95.0 + System.lineSeparator() + "Tax Amount: " + 11.4 + System.lineSeparator() + "Net Earnings: " + 83.6 + System.lineSeparator()
        };


        for (int x = 0; x < inputs.length; x++) { //for loop runs through the arrays for each test

            provideInput(inputs[x]);

            StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency

            for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                expectedOutput.append(baseOutput);
                expectedOutput.append(outputs[y]);
            }
            //Call the main method here
            PayrollTax.main(new String[0]);
            //Get the output
            String actualOutput = getOutput();
            //Compare
            assertEquals(expectedOutput.toString(), actualOutput, "Your program does not accept various wage inputs");
        }
    }
        @Test
        public void alternateTaxTest() {

            String[] inputs = {"5 18 0.02", "5 18 0.34", "5 18 1"};
            String baseOutput = "How many hours have you worked?" + System.lineSeparator() + "What is your hourly wage?" + System.lineSeparator()
                    + "What is the tax rate? (Enter 0.12 for 12%)" + System.lineSeparator();
            String[] outputs = {
                    "Pay Amount: " + 90.0 + System.lineSeparator() + "Tax Amount: " + 1.8 + System.lineSeparator() + "Net Earnings: " + 88.2 + System.lineSeparator(),
                    "Pay Amount: " + 90.0 + System.lineSeparator() + "Tax Amount: " + 30.6 + System.lineSeparator() + "Net Earnings: " + 59.4 + System.lineSeparator(),
                    "Pay Amount: " + 90.0 + System.lineSeparator() + "Tax Amount: " + 90.0 + System.lineSeparator() + "Net Earnings: " + 0.0 + System.lineSeparator()
            };


            for (int x = 0; x < inputs.length; x++) { //for loop runs through the arrays for each test

                provideInput(inputs[x]);

                StringBuilder expectedOutput = new StringBuilder(); //Stringbuilder for efficiency

                for (int y = 0; y <= x; y++) { //for loop adds the previous expected output onto this one, because the console doesn't clear in between loops
                    expectedOutput.append(baseOutput);
                    expectedOutput.append(outputs[y]);
                }
                //Call the main method here
                PayrollTax.main(new String[0]);
                //Get the output
                String actualOutput = getOutput();
                //Compare
                assertEquals(expectedOutput.toString(), actualOutput, "Your program does not accept various tax rate inputs");
            }
        }

}
