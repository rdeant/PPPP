package rdt;

public class PPInfo {
    public int prime;
    public int power;

    public PPInfo(int p, int pow) {
        prime = p;
        power = pow;
    }

    public PPInfo(String str) {
        if (str.indexOf("^") == -1) {
            prime = Integer.parseInt(str);
            power = 1;
        } else {
            prime = Integer.parseInt(str.substring(0, str.indexOf("^")));
            power = Integer.parseInt(str.substring(str.indexOf("^") + 1));
        }
    }

    public String toString() {
        if (power == 1) {
            return String.valueOf(prime);
        } else {
            return prime + "^" + power;
        }
    }
}
