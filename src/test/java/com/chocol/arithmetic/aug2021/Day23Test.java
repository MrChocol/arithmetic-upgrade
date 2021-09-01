package com.chocol.arithmetic.aug2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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
public class Day23Test {

    @Test
    public void test01() {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
    }

    /**
     * 797. 所有可能的路径 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
     * 
     * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
     * 
     * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
     * 
     * n == graph.length <br/>
     * 2 <= n <= 15 <br/>
     * 0 <= graph[i][j] < n <br/>
     * graph[i][j] != i（即，不存在自环） <br/>
     * graph[i] 中的所有元素 互不相同 <br/>
     * 保证输入为 有向无环图（DAG <br/>
     *
     * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
     *
     * @return
     */
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 初始起点为0
        stack.offerLast(0);
        // 深度优先
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    private void dfs(int[][] graph, int index, int n) {
        if (index == n) {
            // 当到了graph最后一个节点时，肯定为空，因此不需要将stack最后一个元素弹出，将stack里面存储的一条路径存到结果里面去
            ans.add(new ArrayList<>(stack));
            return;
        }
        // 遍历第index节点
        for (int j : graph[index]) {
            // 继续向下搜索节点j到下一个节点的路径,并将节点压入到栈尾
            stack.offerLast(j);
            dfs(graph, j, n);
            // 搜索完后需要去除当前节点
            stack.pollLast();
        }
    }

}
