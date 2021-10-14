package com.chocol.arithmetic.DO;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/9/28
 * @since
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}
