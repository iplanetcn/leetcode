import java.util.HashMap;

public class FibonacciNumber {
    private final HashMap<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (n < 0 || n > 30) {
            return 0;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n <= 1) {
            cache.put(n, n);
            return n;
        }

        int fn = fib(n - 1) + fib(n - 2);
        cache.put(n, fn);
        return fn;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.print(new FibonacciNumber().fib(i) + " ");
        }
    }
}

