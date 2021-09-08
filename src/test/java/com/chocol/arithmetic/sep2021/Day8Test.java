package com.chocol.arithmetic.sep2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day8Test {

    @Test
    public void test01() {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};
        assert 4 == findMaximizedCapital(k, w, profits, capital);
    }

    /**
     * 502. IPO(贪心算法+优先队列)
     *
     * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣
     * 设计完成最多 k 个不同项目后得到最大总资本的方式。
     * 
     * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
     * 
     * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
     * 
     * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
     * 
     * 答案保证在 32 位有符号整数范围内。
     * 
     * 链接：https://leetcode-cn.com/problems/ipo
     * 
     * 提示：
     *
     * 1 <= k <= 105 <br/>
     * 0 <= w <= 109 <br/>
     * n == profits.length <br/>
     * n == capital.length <br/>
     * 1 <= n <= 105 <br/>
     * 0 <= profits[i] <= 104 <br/>
     * 0 <= capital[i] <= 109 <br/>
     * 
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];
        // 以所需资本-收益作为一个一体化数组，再进行排序
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        // 按照所需资本从小到大排序
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        // 优先队列用来存储收益，收益最大的在队列头
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 限制最大投资次数
        for (int i = 0; i < k; i++) {
            // 当前角标在投资项目范围内，并且当前角标对应的投资资本小于我当前的资产
            while (curr < n && arr[curr][0] <= w) {
                pq.offer(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                // 队列不为空说明有收益，则将收益加到总资产中去
                w += pq.poll();
            } else {
                // 如果没有则说明当前资产不足以收购剩余最小的资本
                break;
            }
        }
        return w;
    }

}
