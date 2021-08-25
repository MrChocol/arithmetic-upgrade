package com.chocol.arithmetic.aug2021;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day22Test {

    @Test
    public void test01() {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        int result = findCheapestPrice(n, flights, src, dst, k);
        assert 200 == result;
    }

    /**
     * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，<br/>
     * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。<br/>
     * 
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线， 使得从 src 到 dst 的 价格最便宜 ，<br/>
     * 并返回该价格。 如果不存在这样的路线，则输出 -1。<br/>
     * 
     * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
     *
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 10000 * 101 + 1;

        /**
         * 状态定义：dp[k][i] 表示从src到达城市i经过k次航班需要的最小花费<br/>
         * 状态转移：dp[k][i] = min(dp[k][i],dp[k-1][j]+cost(j,i))<br/>
         * dp[k-1][j]+cost(j,i)表示从j到i经过k-1次航班的最小花费，cost(j,i)表示从j到i的花费<br/>
         * 
         * 初始值：dp[0][src] = 0 起点到起点最小花费为0<br/>
         * 返回值：dp[][dst]的最小值<br/>
         */
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < dp.length; i++) {
            // 其他的路线值初始值为最大
            Arrays.fill(dp[i], INF);
        }

        dp[0][src] = 0;
        // 中转一次有两次航班，因此需要k+1次航班
        for (int step = 1; step <= k + 1; step++) {
            for (int[] flight : flights) {
                // 遍历每个航班的信息
                int start = flight[0];
                int end = flight[1];
                int cost = flight[2];
                // 由src经过step次航班到达end点的花费
                // dp[step - 1][start]，由src经过step-1次航班到达这一次航班起点start的最小花费
                // dp[step][end]同一个点到达的路径不一样，因此需要取最小值
                dp[step][end] = Math.min(dp[step][end], dp[step - 1][start] + cost);
            }
        }
        int res = INF;
        for (int i = 0; i <= k + 1; i++) {
            res = Math.min(dp[i][dst], res);
        }

        return res >= INF ? -1 : res;
    }

}
