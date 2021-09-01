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
public class Day26Test {

    @Test
    public void test01() {
        int[] nums = {1, 1, 1, 1, 1};
        int[] result = runningSum(nums);
        System.out.println();
    }

    /**
     * 1480. 一维数组的动态和
     *
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 
     * 请返回 nums 的动态和。
     * 
     * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
     *
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }

        return ans;
    }

}
