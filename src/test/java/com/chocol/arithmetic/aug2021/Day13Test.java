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
public class Day13Test {

    @Test
    public void test01() {
        int m = 1, n = 2, maxMove = 50, startRow = 0, startColumn = 0;
        int result = findPaths(m, n, maxMove, startRow, startColumn);

        assert result==150;
    }

    /**
     * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
     * 
     * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 10^9 + 7 取余 后的结果。
     *
     * 动态规划：<br/>
     * 1. 定义状态：dp[i][j][k] 代表球在第i次移动到坐标[i,j]的路径数量<br/>
     * 2. 状态转移方程：dp[i+1][i][j] = dp[i][j-1][k]+dp[i][j+1][k]+dp[i][j][k-1]+dp[i][j][k+1]<br/>
     * 3. 解释： outCount记录所有移出边界的次数和,i<maxMove,j<m,k<n <br/>
     *
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        // 初始位置第0次的路径数一定是1
        dp[0][startRow][startColumn] = 1;

        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    // 第i次移动到[j,k]的路径数，如果等于0则说明不可能移动到dp[i + 1][j1][k1]
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0];
                            int k1 = k + direction[1];
                            // 第i次的[j,k]向前后左右移动一次后，各个坐标对应的路径数
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                // 没有出界，第i+1次移动到坐标[j1,k1]的路径数赋值
                                // dp[i + 1][j1][k1]可能会移动到起始位置，起始位置为1
                                dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % mod;
                            } else {
                                // 出界，将count和outCount进行累加
                                outCounts = (count + outCounts) % mod;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;
    }

}
