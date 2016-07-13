package interviewquestions;

public class Fibonacci {
    private int fib(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return fibAccum(2, x, 0, 1);
    }

    private int fibAccum(int n, int max, int last1, int last2) {
        if (n == max) {
            return last1 + last2;
        } else {
            return fibAccum(n + 1, max, last2, last1 + last2);
        }
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(0));
        System.out.println(f.fib(1));
        System.out.println(f.fib(2));
        System.out.println(f.fib(3));
        System.out.println(f.fib(4));
        System.out.println(f.fib(5));
        System.out.println(f.fib(6));
    }
}
