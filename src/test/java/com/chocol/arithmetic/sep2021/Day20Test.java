package com.chocol.arithmetic.sep2021;

import com.chocol.arithmetic.DO.ListNode;
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
public class Day20Test {

    @Test
    public void test01() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
            new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        ListNode[] listNodes = splitListToParts(head, 3);
        System.out.println();
    }

    /**
     * 725. 分隔链表
     *
     * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
     * 
     * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
     * 
     * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
     * 
     * 返回一个由上述 k 部分组成的数组。
     * 
     * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
     *
     * 提示：
     * 
     * 链表中节点的数目在范围 [0, 1000] <br/>
     * 0 <= Node.val <= 1000 <br/>
     * 1 <= k <= 50 <br/>
     *
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if (head == null) {
            return ans;
        }

        // 先计算head的长度
        int length = 1;
        ListNode dp = head;
        while (dp.next != null) {
            dp = dp.next;
            length++;
        }

        // length<=k的情况下：每个单元一个
        // length>k的情况下，先取余数，再计算每一个node需要存储的元素个数
        int r = length % k;
        int width = length / k;

        for (int i = 0; i < length && head != null; i++) {
            int partSize = width;
            if (r > 0) {
                r--;
                partSize += 1;
            }
            ans[i] = head;
            for (int j = 1; j < partSize; j++) {
                // 当前节点向后移
                head = head.next;
            }
            // 节点转移
            ListNode next = head.next;
            head.next = null;
            head = next;
        }

        return ans;
    }

}
