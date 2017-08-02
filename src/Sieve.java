import java.util.Arrays;
public class Sieve {

    public boolean isPrime(int number) {
        boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // assume all numbers are prime
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i]) {
                for (int j = i*2; j < prime.length; j+=i) {
                    prime[j] = false; // mark multiples of i as not prime
                }
            }
        }
        return prime[number];
    }
}
