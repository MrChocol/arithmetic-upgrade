package com.chocol.arithmetic.DO;

/**
 * Description: 二叉树节点
 *
 * @author 陈力
 * @date 2021/6/7
 * @since
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
