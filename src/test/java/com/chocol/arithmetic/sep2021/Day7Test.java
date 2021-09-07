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
public class Day7Test {

    @Test
    public void test01() {
        assert 4 == balancedStringSplit("RLRRLLRLRL");
        assert 3 == balancedStringSplit("RLLLLRRRLR");
        assert 1 == balancedStringSplit("LLLLRRRR");
        assert 2 == balancedStringSplit("RLRRRLLRLL");
    }

    /**
     * 1221. 分割平衡字符串
     *
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * 
     * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
     * 
     * 注意：分割得到的每个字符串都必须是平衡字符串。
     * 
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * 
     * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
     * 
     * 提示：
     *
     * 1 <= s.length <= 1000 <br/>
     * s[i] = 'L' 或 'R' <br/>
     * s 是一个 平衡 字符串 <br/>
     *
     * @return
     */
    public int balancedStringSplit(String s) {
        // 从0开始计算L和R的个数，只要两者数量相同则总数+1，再重新从截断点开始计算
        int ans = 0;
        if (s.length() < 2) {
            return ans;
        }
        int lCount = 0, rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            }
            if (s.charAt(i) == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                ans++;
                lCount = 0;
                rCount = 0;
            }
        }
        return ans;
    }

}
