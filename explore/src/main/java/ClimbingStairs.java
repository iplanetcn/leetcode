import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n < 1 || n > 45) {
            return 0;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n == 1) {
            cache.put(1, 1);
            return 1;
        }

        if (n == 2) {
            cache.put(2, 2);
            return 2;
        }

        if (n == 3) {
            cache.put(3, 3);
            return 3;
        }

        int fn = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, fn);
        return fn;
    }
}
