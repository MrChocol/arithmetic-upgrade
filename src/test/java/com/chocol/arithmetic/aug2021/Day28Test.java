package com.chocol.arithmetic.aug2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day28Test {

    @Test
    public void test01() {
        Solution solution = new Solution(new int[] {1, 3});
        List<Integer> result = Arrays.asList(solution.pickIndex(), solution.pickIndex(), solution.pickIndex(),
            solution.pickIndex(), solution.pickIndex());

        System.out.println();
    }

    /**
     * 528. 按权重随机选择
     *
     * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
     * 
     * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
     * 
     * 也就是说，选取下标 i 的概率为 w[i] / sum(w)
     * 
     * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
     *
     * @return
     */
    class Solution {
        private int total;
        private int[] weight;

        public Solution(int[] w) {
            weight = new int[w.length];
            weight[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                // 记录权重
                weight[i] = weight[i - 1] + w[i];
            }
            this.total = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            // 把权重按区间划分，例如 w = [3, 1, 2, 4]时，区间dp[1,10]，[1,3][4,4][5,6][7,8,9,10],即dp[3,4,6,10]
            // 随机一个权重数x，则i满足在区间[dp[i]-w[i]+1,dp[i]]
            // 最后只需要找到最小的满足 x<=dp[i] 的角标i即可
            // +1代表dp区间从1开始
            int x = (int)(Math.random() * total) + 1;
            return binarySearch(x);
        }

        private int binarySearch(int x) {
            int low = 0;
            int high = weight.length - 1;
            // 使用二分查找在dp[3,4,6,10]中查找对应的角标
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (x > weight[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }

}
