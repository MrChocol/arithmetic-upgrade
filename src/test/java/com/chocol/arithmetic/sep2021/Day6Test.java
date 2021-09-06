package com.chocol.arithmetic.sep2021;

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
public class Day6Test {

    @Test
    public void test01() {
        int result = search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
        assert 4 == result;
        int result2 = search(new int[] {5}, 5);
        assert 0 == result2;
        int result3 = search(new int[] {-1, 0, 3, 5, 9, 12}, 2);
        assert -1 == result3;
    }

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     *
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * 
     * 链接：https://leetcode-cn.com/problems/binary-search
     *
     * 提示： 你可以假设 nums 中的所有元素是不重复的。 <br/>
     * n 将在 [1, 10000]之间。 <br/>
     * nums 的每个元素都将在 [-9999, 9999]之间。 <br/>
     * 
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                // 小于目标数，区间往左移
                left = mid + 1;
            } else {
                // 大于目标数，区间往右移
                right = mid - 1;
            }
        }
        return -1;
    }

}
