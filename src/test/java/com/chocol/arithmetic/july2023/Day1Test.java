package com.chocol.arithmetic.july2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-7-25 15:18:46
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        int[] nums = {3, 2, 3};
        int res = majorityElement2(nums);
        System.out.println(res);
    }

    /**
     * 169. 多数元素
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * https://leetcode.cn/problems/majority-element
     * <p>
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -10^9 <= nums[i] <= 10^9
     *
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        int dupCount = 1;
        Arrays.sort(nums);
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNum) {
                if (++dupCount > nums.length / 2) {
                    return lastNum;
                }
            } else {
                dupCount = 1;
            }
            lastNum = nums[i];
        }
        return 0;
    }

    /**
     * Boyer-Moore 投票算法
     * 定义第一个元素x为major，剩余个数为count，遍历数组，当后续元素相同时count++，出现不同元素时count--，当count为0时，新的元素为major，总结来说为此消彼长
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    major = nums[i];
                } else {
                    count--;
                }
            }
        }
        return major;
    }
}
