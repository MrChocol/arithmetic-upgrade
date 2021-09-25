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
public class Day21Test {

    @Test
    public void test01() {
        assert 8 == minDistance("intention", "execution");
    }

    /**
     * 583. 两个字符串的删除操作
     *
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     * 
     * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
     *
     * 提示：
     *
     * 给定单词的长度不超过500。 <br/>
     * 给定单词中的字符只含有小写字母。 <br/>
     *
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        // dp[i][j]代表word1前i个单词和word2前j个单词公共的单词长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 取前者最大的公共长度
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return l1 - dp[l1][l2] + l2 - dp[l1][l2];
    }

}
