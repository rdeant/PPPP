package rdt;

import java.util.*;
import rdt.PPInfo;

/**
 * Generates the first N prime numbers are power of primes.
 * A power of prime can be defined as a prime number P^(2^n)
 * where n is any positive integer.
 */
public class Gen {

    private static ArrayList<PPInfo> full = new ArrayList<PPInfo>();
    private static ArrayList<PPInfo> pp = new ArrayList<PPInfo>();

    public static void main(String[] args) {
        full = new ArrayList<PPInfo>();
        int input = Integer.parseInt(args[0]);
        int count = 0;
        int index = 2;
        // Finds first n primes.
        while (count < input) {
            if (isPrime(index)) {
                count++;
                full.add(new PPInfo(index, 1));
            }
            index ++;
        }
        addPP(full.get(full.size() - 1).prime);
        for (int i = 0; i < input; i++) {
            System.out.println(full.get(i));
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

    public static void addPP(int upperBound) {
        pp = new ArrayList<PPInfo>();
        for (int i = 0; i < full.size(); i++) {
            for (int j = 2; j > 0; j *= 2) {
                int test = (int)Math.pow(full.get(i).prime, j);
                if (test < upperBound) {
                    PPInfo cand = new PPInfo(full.get(i).prime, j);
                    pp.add(cand);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < pp.size(); i++) {
            int test = (int)Math.pow(pp.get(i).prime, pp.get(i).power);
            for (int k = 0; k < full.size(); k++) {
                if (test < Math.pow(full.get(k).prime, full.get(k).power)) {
                    full.add(k, new PPInfo(pp.get(i).prime, pp.get(i).power));
                    break;
                }

            }
        }

    }
}
