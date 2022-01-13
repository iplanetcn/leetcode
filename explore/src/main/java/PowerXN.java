/**
 * PowerXN
 *
 * @author john
 * @since 2022-01-13
 */
public class PowerXN {

    /**
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }

        long N = Math.abs((long) n);
        double ret = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                ret *= x;
            }
            N = (N >> 1);
            x *= x;
        }

        return n < 0 ? 1 / ret : ret;
    }

    public double pow2(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return 1.0;
        double half = pow2(x, n / 2);
        if (n % 2 == 0) return half * half;
        else if (n > 0) return half * half * x;
        else return half * half / x;
    }


    public static void main(String[] args) {
        System.out.println(new PowerXN().myPow(-2.0, 0));
        System.out.println(new PowerXN().myPow(-2.0, 1));
        System.out.println(new PowerXN().myPow(-2.0, 2));
        System.out.println(new PowerXN().myPow(-2.0, 3));
        System.out.println(new PowerXN().myPow(-2.0, -3));
        System.out.println(new PowerXN().myPow(0.00001, 2147483647));
        System.out.println(new PowerXN().myPow(2.1, 3));
    }


}
