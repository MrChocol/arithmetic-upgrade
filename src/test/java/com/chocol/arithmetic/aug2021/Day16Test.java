package com.chocol.arithmetic.aug2021;

import java.util.*;
import java.util.stream.Collectors;

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
public class Day16Test {

    @Test
    public void test01() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println();
    }

    /**
     * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] ：
     * 
     * 0 <= a, b, c, d< n a、b、c 和 d 互不相同 nums[a] + nums[b] + nums[c] + nums[d] == target 你可以按 任意顺序 返回答案 。
     * 
     * 链接：https://leetcode-cn.com/problems/4sum
     *
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        // 使用4指针，a为开头1，b为开头2，c为左指针，d为右指针
        for (int a = 0; a < nums.length - 3; a++) {
            // 去重,res只存值不存角标，因此需要跳过
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                // 去重,res只存值不存角标，因此需要跳过
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if (nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                // 取[i+1,length-1]区间的数字
                int left = b + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 移动指针
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        // 去重,res只存值不存角标，因此需要跳过
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                        // 去重,res只存值不存角标，因此需要跳过
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return res;

    }

}
