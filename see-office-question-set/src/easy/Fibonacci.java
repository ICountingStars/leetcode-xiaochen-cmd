package easy;


/**
 * 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * eg:
 * 输入：n = 2
 * 输出：1
 * <p>
 * eg2:
 * 输入：n = 5
 * 输出：5
 * <p>
 * limit:
 * 0 <= n <= 100
 *
 * @author chenjianglin
 * @date 2021/2/22
 * @since 1.0.0
 **/
public class Fibonacci {

    //动态规划：详细版
    public static int fibonacci4(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
//          1e9+7（1000000007）是最接近1e9的质素，可与防止int32溢出
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    //动态规划：以斐波那契数列性质 f(n+1) = f(n)+f(n-1) 为转移方程
    // 最佳解法
    public static int fibonacci3(int n) {
        //简化版
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    //记忆化递归法 新建一个长度为n的数组，将在递归中所有的值存储到数组中，遇到相同的直接从数组中取
    //缺点是需要额外的空间 大约O(N)的空间

    public int fibonacci2(int n) {
        if (n == 0) return 0;
        int[] memory = new int[n + 1];
        memory[0] = 0;
        memory[1] = 1;
        return fibonacciMemory(n, memory);
    }

    public int fibonacciMemory(int n, int[] memory) {
        if (n < 2) {
            return n;
        }
        //递归前查询
        if (memory[n] > 0) {
            return memory[n];
        }
        //递归完成后保存递归的值
        memory[n] = (fibonacciMemory(n - 1, memory) + fibonacciMemory(n - 2, memory)) % 1000000007;
        return memory[n];
    }

    //自己写的递归法求解
    //大量递归计算，效率底下
    public static int fibonacci(int n) {
        if (n < 0 || n > 100) {
            return -1;
        }
        if (n <= 1) {
            return n;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2)) % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci3(2));
        System.out.println(fibonacci3(5));
        System.out.println(fibonacci3(50));
        System.out.println(fibonacci4(2));
        System.out.println(fibonacci4(5));
        System.out.println(fibonacci4(50));
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci2(2));
        System.out.println(fibonacci.fibonacci2(5));
        System.out.println(fibonacci.fibonacci2(50));
    }
}
