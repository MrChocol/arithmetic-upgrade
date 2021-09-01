package com.chocol.arithmetic.aug2021;

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
public class Day27Test {

    @Test
    public void test01() {
        int[] arr = {1, 4, 2, 5, 3};
        int result = sumOddLengthSubarrays(arr);
        assert 58 == result;
    }

    /**
     * 1588. 所有奇数长度子数组的和
     * 
     * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
     * 
     * 子数组 定义为原数组中的一个连续子序列。
     * 
     * 请你返回 arr中 所有奇数长度子数组的和 。
     * 
     * 1 <= arr.length <= 100
     * 
     * 1 <= arr[i] <= 1000
     * 
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
     *
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        // 双指针
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i;
            int right = left;
            while (right < arr.length) {
                if ((right - left) % 2 == 0) {
                    for (int j = left; j <= right; j++) {
                        ans += arr[j];
                    }
                }
                right++;
            }
        }

        return ans;
    }

}
