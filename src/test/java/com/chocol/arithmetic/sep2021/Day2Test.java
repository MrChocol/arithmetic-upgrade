package com.chocol.arithmetic.sep2021;

import com.chocol.arithmetic.DO.ListNode;
import com.chocol.arithmetic.DO.TreeNode;
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
public class Day2Test {

    @Test
    public void test01() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = getKthFromEnd(head, 2);
        System.out.println();
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * 
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     *
     * 提示：
     * 
     * 1 <= version1.length, version2.length <= 500 <br/>
     * version1 和 version2 仅包含数字和 '.' <br/>
     * version1 和 version2 都是 有效版本号 <br/>
     * version1 和 version2 的所有修订号都可以存储在 32 位整数 中 <br/>
     *
     * 
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        // 双指针,先让右指针前进k个位置
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
            if (right == null) {
                return head;
            }
        }
        // 左右指针同时移动，直到右指针到达终点
        while (right != null) {
            head = head.next;
            right = right.next;
        }

        return head;
    }

}
