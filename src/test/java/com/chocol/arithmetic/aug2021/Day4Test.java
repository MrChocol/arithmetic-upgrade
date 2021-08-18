package com.chocol.arithmetic.aug2021;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.TreeNode;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day4Test {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        // 1,2,2,null,3,null,3
        TreeNode root2 = new TreeNode(0);

        int maxDepth = maxDepth2(root);

        System.out.println();
    }

    /**
     * 给定一个二叉树，找出其最大深度。 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。<br/>
     * 说明: 叶子节点是指没有子节点的节点。
     * 
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归,dfs深度优先,time:O(n),zone:O(height)
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 广度优先bfs，横向扩展，维护一个队列，记录最大的层级,time:O(n),zone:O(n)
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                // 移除整个一层,再把下一层级的元素添加进来
                TreeNode node = queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return level;
    }

    int maxDepth = 0;

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 深度优先dfs，纵向扩展,记录节点数
        int level = 1;
        return level;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, level);
        dfs(node.left, level++);
        dfs(node.right, level++);

    }
}
