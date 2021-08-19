package com.chocol.arithmetic.aug2021;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
public class Day17Test {

    @Test
    public void test01() {
        String result = reverseVowels2("hello");
        assert "holle".equals(result);
    }

    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
     * 
     * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
     *
     * @return
     */
    public String reverseVowels(String s) {
        List<Integer> vowels = Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117);

        Deque<Integer> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains((int)chars[i])) {
                deque.add(i);
            }
        }

        char temp;
        while (!deque.isEmpty()) {
            Integer first = deque.removeFirst();
            if (deque.isEmpty()) {
                break;
            }
            Integer last = deque.removeLast();
            temp = chars[first];
            chars[first] = chars[last];
            chars[last] = temp;
        }

        return new String(chars);
    }

    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left < right) {
            while (left < chars.length && !("AEIOUaeiou".indexOf(chars[left]) >= 0)) {
                left++;
            }
            while (left < right && !("AEIOUaeiou".indexOf(chars[right]) >= 0)) {
                right--;
            }
            if (left < right) {
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
