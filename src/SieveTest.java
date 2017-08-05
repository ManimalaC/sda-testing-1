import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 * Test class the Sieve class.
 *
 * @author Simon Larsén
 * @version 2017-08-05
 */
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

    @Test
    public void isPrimeFunctionsWhenPassedIncrementingValues() {
        assertTrue(sieve.isPrime(2));
        assertTrue(sieve.isPrime(3));
        assertFalse(sieve.isPrime(4));
        assertTrue(sieve.isPrime(5));
        assertFalse(sieve.isPrime(6));
        assertTrue(sieve.isPrime(7));
        assertFalse(sieve.isPrime(8));
        assertFalse(sieve.isPrime(9));
    }
}
