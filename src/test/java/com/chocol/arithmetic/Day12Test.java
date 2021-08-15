package com.chocol.arithmetic;

import com.chocol.arithmetic.DO.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.ListNode;

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
public class Day12Test {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Boolean result = isBalanced(root);

        System.out.println();;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * 
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归判断深度，左节点深度|ldepth-rdepth|>1，返回false
        return height(root) > 0;
    }

    // 获取节点的高度
    public int height(TreeNode root) {
        // 根节点
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (lHeight < 0 || rHeight < 0 || Math.abs(lHeight - rHeight) > 1) {
            // 左右两层级高度相差为2则表示该节点不平衡
            return -1;
        } else {
            // 累计层级加一
            return Math.max(lHeight, rHeight) + 1;
        }

    }

}
