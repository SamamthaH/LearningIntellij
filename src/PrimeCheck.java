import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PrimeCheck {
    public static boolean isPrime(int num){
        return num % 2 != 0;
    }
}
class TestPrime{
    @Test
    public void testPrimeCheckingCorrectly(){
        assertTrue(PrimeCheck.isPrime(1), "number is even");
    }

}