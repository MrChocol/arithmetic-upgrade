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
public class Day7Test {

    @Test
    public void test01() {
        int i = 1 ^ 3;
        int[] nums = {5, 1, 6};
        int result = subsetXORSum(nums);

        assert result == 28;
    }

    /**
     * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
     * 
     * 例如，数组[2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
     * 
     * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
     * 
     * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
     *
     * 
     * @param nums
     * @return
     */
    int res = 0;

    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dfs(nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int index, int xor) {
        if (index == nums.length) {
            res += xor;
            return;
        }
        // 当前位置算入
        dfs(nums, index + 1, xor ^ nums[index]);
        // 当前位置不算入
        dfs(nums, index + 1, xor);
    }

}
