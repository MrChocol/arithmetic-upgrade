package com.chocol.arithmetic.aug2021;

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
public class Day18Test {

    @Test
    public void test01() {
        String s = "abcdefg";
        int k = 2;
        String result = reverseStr(s, k);
        assert "bacdfeg".equals(result);
    }

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
     * 
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
     * 
     * 链接：https://leetcode-cn.com/problems/reverse-string-ii
     *
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        char temp;

        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k, length) - 1;
            while (left < right) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

}
