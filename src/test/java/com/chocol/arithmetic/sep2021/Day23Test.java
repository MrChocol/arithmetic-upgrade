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
public class Day23Test {

    @Test
    public void test01() {
        assert !isPowerOfThree(45);
    }

    /**
     * 326. 3的幂
     *
     * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
     * 
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     * 
     * 链接：https://leetcode-cn.com/problems/power-of-three
     *
     * 提示：
     *
     * -231 <= n <= 231 - 1 <br/>
     *
     * @return
     */
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

}
