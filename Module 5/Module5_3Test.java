import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Module5_3Test {
    private Module5_3 prime = new Module5_3();

    @Test
    void readPositiveInt() {    // Tests if method returns positive integer correctly
        assertEquals(9, prime.readPositiveInt(9));
    }

    @Test
    void readPositiveIntZero() {    // Tests if number below 1 returns 0 from readPositiveInt method
        assertEquals(0, prime.readPositiveInt(0));
    }

    @Test
    void isPrime() {    // Tests if correctly identifies prime number
        assertTrue(prime.isPrime(5));
    }

    @Test
    void isPrimeComposite() {    // Tests if correctly identifies composite number
        assertFalse(prime.isPrime(4));
    }

    @Test
    void isPrime1() {    // Tests if correctly identifies 1 as a composite number
        assertFalse(prime.isPrime(1));
    }

    @Test
    void isPrimeLargestInt() {    // Tests if largest possible int functions with program
        assertTrue(prime.isPrime(Integer.MAX_VALUE));
    }
}