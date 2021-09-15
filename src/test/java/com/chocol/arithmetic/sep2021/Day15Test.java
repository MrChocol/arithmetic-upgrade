package com.chocol.arithmetic.sep2021;

import java.util.Arrays;
import java.util.List;

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
public class Day15Test {

    @Test
    public void test01() {
        assert 2 == findPeakElement(new int[] {1, 2, 3, 1});
    }

    /**
     * 162. 寻找峰值
     *
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * 
     * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * 
     * 你可以假设nums[-1] = nums[n] = -∞ 。
     * 
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * 
     * 链接：https://leetcode-cn.com/problems/find-peak-element
     *
     * 提示：
     *
     * 1 <= nums.length <= 1000 <br/>
     * -231 <= nums[i] <= 231 - 1 <br/>
     * 对于所有有效的 i 都有 nums[i] != nums[i + 1] <br/>
     *
     * @return
     */
    public int findPeakElement(int[] nums) {
        // 定义中位数mid，如果nums[mid]<nums[mid+1]，表示为上坡路那么在mid的右边界一定存在峰值
        // 如果nums[mid-1]>nums[mid]
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 上坡在左边界
                right = mid;
            } else {
                // 上坡在右边界
                left = mid + 1;
            }
        }

        return left;
    }

}
