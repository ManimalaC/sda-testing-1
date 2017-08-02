import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class SieveTest {
    private Sieve sieve;

    @Before
    public void setUp() {
        sieve = new Sieve();
    }

    @Test
    public void isPrimeTrueWhenPassedA2() {
        assertTrue(sieve.isPrime(2));
    }

    @Test
    public void isPrimeTrueWhenPassedAPrime() {
        assertTrue(sieve.isPrime(3));
        assertTrue(sieve.isPrime(97));
        assertTrue(sieve.isPrime(7));
        assertTrue(sieve.isPrime(5));
    }

    @Test
    public void isPrimeFalseWhenPassedAComposite() {
        assertFalse(sieve.isPrime(4));
        assertFalse(sieve.isPrime(903));
        assertFalse(sieve.isPrime(6));
        assertFalse(sieve.isPrime(35));
    }
}
