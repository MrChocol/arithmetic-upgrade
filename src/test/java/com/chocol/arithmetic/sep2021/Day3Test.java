package com.chocol.arithmetic.sep2021;

import java.util.Arrays;
import java.util.PriorityQueue;

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
public class Day3Test {

    @Test
    public void test01() {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] result = smallestK(arr, k);
        System.out.println();
    }

    /**
     * 面试题 17.14. 最小K个数
     *
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     *
     * 
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (null == arr || arr.length < k) {
            return arr;
        }
        Arrays.sort(arr);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public int[] smallestK2(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            // 将最大的放到堆顶
            return o2 - o1;
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }

}
