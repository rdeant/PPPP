package rdt;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import rdt.PPInfo;

public class Driver {

    public static void main(String[] args) {
        try {
            File file = new File("./output.txt");
            Scanner s = new Scanner(file);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter a number to find the smallest "
            + "integer with exactly 2^n divisors");
            int input = kb.nextInt();
            int index = 0;
            ArrayList<PPInfo> build = new ArrayList<PPInfo>();
            while (index < input && s.hasNextLine()) {
                index++;
                String str = s.nextLine();
                PPInfo temp = new PPInfo(str);
                if (temp.power != 1) {
                    for (PPInfo x : build) {
                        if (temp.prime == x.prime) {
                            x.power += temp.power;
                        }
                    }
                } else {
                    build.add(temp);
                }
            }
            kb.close();
            s.close();
            int beg = 0;
            int pow = build.get(0).power;
            for (int i = 1; i < build.size(); i++) {
                if (build.get(i).power != pow) {
                    if (i - beg == 1) {
                        System.out.println(build.get(beg));
                    } else {
                        System.out.println("(" + build.get(beg).prime + "..."
                        + build.get(i - 1).prime + ")^" + pow);
                    }
                    beg = i;
                    pow = build.get(i).power;
                } else if (i == build.size() - 1) {
                    System.out.print("(" + build.get(beg).prime + "..."
                    + build.get(i).prime + ")");
                    if (build.get(i).power != 1) {
                        System.out.print("^" + build.get(i).power);
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
