package com.chocol.arithmetic.aug2021;

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
public class Day14Test {

    @Test
    public void test01() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest2(nums, target);

        assert result == 2;
    }

    /**
     * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(res - target) > Math.abs(sum - target)) {
                        res = sum;
                    }
                }
            }
        }

        return res;
    }

    public int threeSumClosest2(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 跳过相等的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 取[i+1,length-1]区间的数字
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                }
                // 比较间隔大小
                if (Math.abs(sum - target) < min) {
                    res = sum;
                    min = Math.abs(sum - target);
                }
                // 如果三个元素的值大于target则说明end对应的元素偏大，需要往前缩进
                if (sum > target) {
                    end--;
                } else {
                    // 说明元素值偏小，start需要往大的值方向走
                    start++;
                }
            }
        }
        return res;
    }

}
