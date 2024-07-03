package com.chocol.arithmetic.dec2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-01-30 14:31:50
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        System.out.println(res);
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if (nums.length < 1) {
            return res;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (res[0] == -1 && nums[left] == target) {
                res[0] = left;
            }
            left++;
            if (res[1] == -1 && nums[right] == target) {
                res[1] = right;
            }
            right--;
        }

        return res;
    }

}
