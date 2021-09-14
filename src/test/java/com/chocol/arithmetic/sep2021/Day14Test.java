package com.chocol.arithmetic.sep2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Day14Test {

    @Test
    public void test01() {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("a", "b", "c");
        assert "a".equals(findLongestWord(s, dictionary));
    }

    /**
     * 524. 通过删除字母匹配到字典里最长单词
     *
     * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
     * 
     * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
     * 
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting 说明:
     *
     * 1 <= s.length <= 1000 <br/>
     * 1 <= dictionary.length <= 1000 <br/>
     * 1 <= dictionary[i].length <= 1000 <br/>
     * s 和 dictionary[i] 仅由小写英文字母组成 <br/>
     *
     * 
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        // 遍历匹配符合的个数
        int sLen = s.length();
        // 字典按照字典顺序进行排序
        String ans = "";

        dictionary.sort(String.CASE_INSENSITIVE_ORDER);
        int max = 0;
        for (int i = dictionary.size() - 1; i >= 0; i--) {
            // 从末尾向前遍历
            String dict = dictionary.get(i);
            int dLen = dict.length();
            if (dLen < max || dLen > sLen) {
                // 当前字典长度小于最大匹配的长度或者大于字符串s的长度
                continue;
            }

            int left = 0, right = 0, count = 0;
            while (left < sLen && right < dLen) {
                // 匹配单词
                if (s.charAt(left) == dict.charAt(right)) {
                    count++;
                    left++;
                    right++;
                } else {
                    left++;
                }
            }

            // 如果匹配到的次数大于当前最大值并且等于字典单词的长度
            if (count >= max && count == dLen) {
                ans = dict;
                max = count;
            }

        }

        return ans;
    }

}
