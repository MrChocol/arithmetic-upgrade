package com.chocol.arithmetic.aug2021;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day3Test {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        // 1,2,2,null,3,null,3
        TreeNode root2 =
            new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));

        boolean result = isSymmetric(root2);

        System.out.println();
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // return isSameTree(root.left, root.right);
        return iteration(root);
    }

    /**
     * 递归法
     * 
     * @param l
     * @param r
     * @return
     */
    public boolean isSameTree(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l != null && r != null && l.val == r.val) {
            return isSameTree(l.left, r.right) && isSameTree(l.right, r.left);
        }
        return false;
    }

    /**
     * 迭代法
     * 
     * @param root
     * @return
     */
    public boolean iteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

}
