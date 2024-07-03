package com.chocol.arithmetic.july2023;

import com.chocol.arithmetic.DO.ListNode;
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
 * @date 2023-7-25 15:18:46
 * @since
 */
@Slf4j
@SpringBootTest
public class Day2Test {

    @Test
    public void test01() {
        ListNode commonNode = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, commonNode));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, commonNode)));

        ListNode res = getIntersectionNode2(headA, headB);
        System.out.println(res);
    }

    /**
     * 160. 相交链表
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * 注意，函数返回结果后，链表必须 保持其原始结构
     * <p>
     * https://leetcode.cn/problems/intersection-of-two-linked-lists
     * <p>
     * listA 中节点数目为 m
     * listB 中节点数目为 n
     * 1 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * 如果 listA 和 listB 没有交点，intersectVal 为 0
     * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
     *
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 维护一个堆栈 存hashcode
        Map<Integer, ListNode> temp = new HashMap<>();
        ListNode nextA = headA;
        while (nextA != null) {
            temp.put(nextA.hashCode(), nextA);
            nextA = nextA.next;
        }

        ListNode nextB = headB;
        while (nextB != null) {
            if (temp.containsKey(nextB.hashCode())) {
                return nextB;
            }
            nextB = nextB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 相交链表，要走对方的路，循环往复迟早会碰面
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
