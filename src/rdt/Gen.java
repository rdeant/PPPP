package rdt;

import java.util.*;
import rdt.PPInfo;

/**
 * Generates the first N prime numbers are power of primes.
 * A power of prime can be defined as a prime number P^(2^n)
 * where n is any positive integer.
 */
public class Gen {

    private static ArrayList<PPInfo> full;

    public static void main(String[] args) {
        full = new ArrayList<PPInfo>();
        int input = Integer.parseInt(args[0]);
        int count = 0;
        int index = 2;
        while (count < input) {
            if (isPrime(index)) {
                count++;
                full.add(new PPInfo(index, 1));
            } else if (isPP(index) != null) {
                count++;
                full.add(isPP(index));
            }
            index ++;
        }
        for (PPInfo x : full) {
            System.out.println(x);
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

    public static PPInfo isPP(int num) {
        for (PPInfo x : full) {
            int copy = x.prime;
            int power = 2;
            while (Math.pow(copy, power) <= num) {
                if (Math.pow(copy, power) == num) {
                    return new PPInfo(x.prime, power);
                }
                power *= 2;
            }
        }
        return null;
    }
}
