package com.chocol.arithmetic.DO;

/**
 * Description: 二叉树节点
 *
 * @author 陈力
 * @date 2021/6/7
 * @since
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
