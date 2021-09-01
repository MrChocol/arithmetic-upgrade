package com.chocol.arithmetic.aug2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day6Test {

    @Test
    public void test01() {
        int n = 25;
        int result = tribonacci(n);

        System.out.println();
    }

    /**
     * 泰波那契序列Tn定义如下：
     *
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     *
     * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n > 37) {
            return Integer.MAX_VALUE;
        }
        int[] memo = new int[38];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        if (n < 3) {
            return memo[n];
        }
        int sum = memo[0] + memo[1] + memo[2];

        for (int i = 3; i <= n; i++) {
            sum = memo[i - 3] + memo[i - 2] + memo[i - 1];
            memo[i] = sum;
        }
        return sum;
    }

}
