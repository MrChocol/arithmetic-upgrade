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
public class Day19Test {

    @Test
    public void test01() {

        assert 3 == minSteps(3);
    }

    /**
     * 650. 只有两个键的键盘
     *
     * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
     * 
     * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 <br/>
     * Paste（粘贴）：粘贴 上一次 复制的字符。 <br/>
     * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
     * 
     * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
     *
     * 提示：
     * 
     * 1 <= n <= 1000 <br/>
     *
     * @return
     */
    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }

}
