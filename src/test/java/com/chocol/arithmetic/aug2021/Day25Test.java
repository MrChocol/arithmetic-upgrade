package com.chocol.arithmetic.aug2021;

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
public class Day25Test {

    @Test
    public void test01() {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double result = obj.findMedian();
        assert 1.5 == result;
        obj.addNum(3);
        result = obj.findMedian();
        assert 2 == result;
    }

    /**
     * 295. 数据流的中位数
     *
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     * 
     * 例如，
     * 
     * [2,3,4]的中位数是 3
     * 
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     * 
     * 设计一个支持以下两种操作的数据结构：
     * 
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。 double findMedian() - 返回目前所有元素的中位数
     * 
     * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
     *
     * @return
     */
    class MedianFinder {
        // 记录大于中位数的所有元素，相当于有序数组的右半部分,中位数在堆顶，左队列维护总个数为奇数时的中位数
        private PriorityQueue<Integer> right;
        // 记录小于中位数的所有元素，相当于有序数组的左半部分，中位数在堆顶
        private PriorityQueue<Integer> left;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> b - a);
            right = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            // 如果左队列为空或者添加的数字小于左队列的最大中位数，则添加到左队列中
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
                if (right.size() + 1 < left.size()) {
                    // 如果右队列长度小于左队列长度，则需要把左队列的最大中位数挪到右队列中
                    right.offer(left.poll());
                }
            } else {
                right.offer(num);
                if (right.size() > left.size()) {
                    left.offer(right.poll());
                }
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            } else {
                return (left.peek() + right.peek()) / 2.0;
            }
        }
    }

}
