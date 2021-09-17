package com.chocol.arithmetic.sep2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day16Test {

    @Test
    public void test01() {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 31. 下一个排列
     *
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     * 
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 
     * 必须 原地 修改，只允许使用额外常数空间。
     * 
     * 链接：https://leetcode-cn.com/problems/next-permutation
     *
     * 提示：
     *
     * 1 <= nums.length <= 100 <br/>
     * 0 <= nums[i] <= 100 <br/>
     *
     * @return
     */
    public void nextPermutation(int[] nums) {
        // 倒序查找最近的一个下坡位置
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            // [i,end]持续上坡
            i--;
        }
        if (i >= 0) {
            // 找到[i,end]区间最接近并且大于nums[i]的位置，并将两者进行互换
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 互换
            swap(i, j, nums);
        }
        // 此时需要将(i,end]的数字反向排序即可,因为这一段区间是一个下坡，如果要取得最接近原数组的大数组，就需要将下坡扭转为上坡
        reverse(i + 1, nums);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int start, int[] nums) {
        // 从start往后的数组进行倒序
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

}
