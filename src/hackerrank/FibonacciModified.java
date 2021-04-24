package hackerrank;

public class FibonacciModified {

    public int fibonacciModified(int t1, int t2, int n) {
        long[] memcache = new long[n];
        memcache[0] = t1;
        memcache[1] = t2;
        for (int i = 2; i < n; i++) {
            memcache[i] = memcache[i - 2] + (memcache[i - 1] * memcache[i - 1]);
        }
        return (int) memcache[memcache.length - 1];
    }

    public static void main(String[] args) {
        FibonacciModified fm = new FibonacciModified();
        System.out.println(fm.fibonacciModified(0, 1, 10));
    }
}
