package com.chocol.arithmetic.aug2021;

import org.junit.jupiter.api.Test;
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
public class Day21Test {

    @Test
    public void test01() {
        int n = 7;
        int result = getMaximumGenerated(n);
        assert 3 == result;
    }

    /**
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     * 
     * 1. nums[0] = 0 <br/>
     * 2. nums[1] = 1 <br/>
     * 3. 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i] <br/>
     * 4. 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1] <br/>
     * 返回生成数组 nums 中的 最大 值。
     * 
     * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
     *
     * @return
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        // i不超过 (n+1)/2
        for (int i = 1; i < (n + 1) / 2; i++) {
            nums[2 * i] = nums[i];
            nums[2 * i + 1] = nums[i] + nums[i + 1];
            max = Math.max(max, Math.max(nums[2 * i], nums[2 * i + 1]));
        }
        return max;
    }

}
