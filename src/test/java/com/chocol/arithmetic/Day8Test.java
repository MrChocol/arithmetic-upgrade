package com.chocol.arithmetic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day8Test {

    @Test
    public void test01() {
        int[] nums = {1, 3, 5, 7, 9};
        int result = numberOfArithmeticSlices(nums);

        assert result == 6;
    }

    /**
     * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     * 
     * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
     * 
     * 子数组 是数组中的一个连续序列。
     * 
     * 
     * 定义状态：dp[i]表示从nums[0]到nums[i]且以nums[i]为结尾的等差数列子数组的数量。
     *
     * 状态转移方程：dp[i] = dp[i-1]+1 if nums[i]-nums[i-1]==nums[i-1]-nums[i-2] else 0
     *
     * 解释：如果nums[i]能和nums[i-1]nums[i-2]组成等差数列，则以nums[i-1]结尾的等差数列均可以nums[i]结尾，且多了一个新等差数列[nums[i],nums[i-1],nums[i-2]]
     * 
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int[] memo = new int[nums.length];
        if (nums[0] - nums[1] == nums[1] - nums[2]) {
            memo[2] = 1;
        }
        int res = memo[2];
        for (int i = 3; i < nums.length; i++) {
            if (nums[i - 2] - nums[i - 1] == nums[i - 1] - nums[i]) {
                memo[i] = memo[i - 1] + 1;
            }
            res += memo[i];
        }

        return res;
    }

}
