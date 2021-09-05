package com.chocol.arithmetic.sep2021;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day4Test {

    @Test
    public void test01() {
        int result = fib(45);
        assert 134903163 == result;
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     *
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * 
     * F(0) = 0, F(1)= 1 F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     *
     * 0 <= n <= 100
     * 
     * @return
     */
    public int fib(int n) {
        int MAX = 1000000007;

        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] > MAX) {
                dp[i] = Math.floorMod(dp[i], MAX);
            }
        }

        return dp[n];
    }

}
