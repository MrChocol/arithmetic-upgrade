package com.chocol.arithmetic.oct2022;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        int[] fruits = {1,2,1};
        int res = totalFruit(fruits);
        assert res == 3;
        System.out.println(res);
    }

    /**
     * 904. 水果成篮
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
     * <p>
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     * <p>
     * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
     * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * <p>
     * 链接：https://leetcode-cn.com/problems/fizz-buzz
     * <p>
     * 提示：
     * <p>
     * 1 <= fruits.length <= 105
     * 0 <= fruits[i] < fruits.length
     *
     * @return
     */
    public int totalFruit(int[] fruits) {
        // 双指针，res记录摘取的水果的最大数量，memo记录当前采摘的水果数量
        if (fruits.length < 3) return fruits.length;

        // k-类型 v-数量
        Map<Integer, Integer> memo = new HashMap<>();

        int left = 0, res = 0;
        for (int right = 0; right < fruits.length; right++) {
            // 将最右边的数推到map中
            memo.put(fruits[right], memo.getOrDefault(fruits[right], 0) + 1);
            // 如果map数量大于三则说明最后一次right推进来的数是新的类型，这时候就需要把最左边的树类型去掉
            while (memo.size() > 2) {
                memo.put(fruits[left], memo.getOrDefault(fruits[left], 0) - 1);
                if (memo.get(fruits[left]) == 0) {
                    memo.remove(fruits[left]);
                }
                ++left;
                // 移除后保存最大值
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
