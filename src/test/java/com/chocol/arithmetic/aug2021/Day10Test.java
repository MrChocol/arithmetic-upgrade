package com.chocol.arithmetic.aug2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day10Test {

    @Test
    public void test01() {
        int result = longestPalindromeSubseq("bbbab");

        assert 4 == result;
    }

    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     *
     * 动态规划：<br/>
     * 1. 定义状态：dp[i][j] 代表s[i]到s[j]中子序列的最长长度<br/>
     * 2. 状态转移方程：if(s[i] == s[j]) dp[i][j] = dp[i+1][j-1]+2 else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])<br/>
     * 3. 解释： <br/>
     * 
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[][] dp = new int[length][length];
        // 每一个字符都是一个长度为1的回文子序列
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][length - 1];
    }

}
