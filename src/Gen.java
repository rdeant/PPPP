import java.util.*;

/**
 * Generates the first N prime numbers are power of primes.
 * A power of prime can be defined as a prime number P^(2^n)
 * where n is any positive integer.
 */
public class Gen {

    private static ArrayList<Integer> nums;

    public static void main(String[] args) {
        nums = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of primes and PPs to generate");
        int input = s.nextInt();
        int count = 0;
        int index = 2;
        while (count < input) {
            if (isPrime(index)) {
                count++;
                System.out.println("#" + count + ": " + index + " (P)");
                nums.add(index);
            } else if (isPP(index)) {
                count++;
                System.out.println("#" + count + ": " + index + " (PP)");
                nums.add(index);
            }
            index ++;
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPP(int num) {
        for (int x : nums) {
            int copy = x;
            int power = 2;
            while (Math.pow(copy, power) <= num) {
                if (Math.pow(copy, power) == num) {
                    return true;
                }
                power++;
            }
        }
        return false;
    }
}
