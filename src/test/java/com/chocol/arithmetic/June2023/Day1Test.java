package com.chocol.arithmetic.June2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-06-02 17:35:21
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] res = vowelStrings(words, queries);
        System.out.println(res);
    }

    /**
     * 2559. 统计范围内的元音字符串数
     * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
     * <p>
     * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
     * <p>
     * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
     * <p>
     * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/count-vowel-strings-in-ranges
     * <p>
     * 1 <= words.length <= 105
     * 1 <= words[i].length <= 40。
     * words[i] 仅由小写英文字母组成
     *
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] temp = new int[words.length];
        int[] results = new int[queries.length];
        Arrays.fill(temp, -1);
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (temp[j] != -1) {
                    results[i] += temp[j];
                } else {
                    if (isVowelString(words[j])) {
                        temp[j] = 1;
                        results[i]++;
                    } else {
                        temp[j] = 0;
                    }
                }
            }
        }
        return results;
    }

    private boolean isVowel(String word) {
        return "a".equals(word) || "e".equals(word) || "i".equals(word) || "o".equals(word) || "u".equals(word);
    }

    private boolean isVowelString(String word) {
        return isVowel(word.substring(0, 1)) && isVowel(word.substring(word.length() - 1));
    }

}
