import acm.program.*;

public class Module5_3 extends ConsoleProgram {
    /* Reads a number from the user and reports whether or not it
     * is prime.
     */
    public void run() {
        /* Get the value from the user. */
        int value = 0;
        while (value == 0) {
            value = readPositiveInt(readInt("Enter a positive integer: "));
        }

        /* Check whether or not it is prime. */
        if (isPrime(value)) {
            println(value + " is prime.");
        } else {
            println(value + " is composite.");
        }
    }

    /**
     * Given a positive integer, returns whether that integer is
     * prime.
     *
     * @param value The value to test.
     * @return Whether or not it is prime.
     */
    boolean isPrime(int value) {
        /* Try all possible divisors of the number.  If any of them
         * cleanly divide the number, we return that the number is
         * composite.
         */
        if (value == 1) {return false;}
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reads a positive integer from the user and returns it.
     *
     * @return A positive integer entered by the user.
     */
    int readPositiveInt(int value) {
        /* If the value was nonpositive, reprompt the user. */
        if (value <= 0) {
            println("Please enter a positive integer.");
            return 0;
        }
        return value;
    }

    public static void main(String[] args) {
        new Module5_3().start(args);
    }
}
