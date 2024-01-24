package dp;

import java.util.ArrayList;
import java.util.List;

class FibSolution {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(fib1(n));
        System.out.println(fib2(n));
    }
    public static int fib1(int n) {
        int result = 0;
        if (n < 2) {
            return n;
        }

        int index = 0;
        List<Integer> numList = new ArrayList<>();
        numList.add(0);
        index++;
        numList.add(1);
        index++;
        for (int i = 2; i <= n; i++) {
            if (index != n) {
                numList.add(numList.get(index - 1) + numList.get(index - 2));
                index++;
            }
        }
        
        result = numList.get(index - 1) + numList.get(index - 2);
        return result;
    }
    public static int fib2(int n) {
        if (n < 2) return n;
        return fib2(n - 1) + fib2(n - 2);
    }
}