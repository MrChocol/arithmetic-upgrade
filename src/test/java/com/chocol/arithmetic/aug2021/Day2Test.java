package com.chocol.arithmetic.aug2021;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@SpringBootTest
public class Day2Test {

    @Test
    public void test01() {
        TreeNode p = new TreeNode(1, new TreeNode(1), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(1));

        boolean result = isSameTree1(p, q);

        System.out.println();
    }

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
        return false;
    }

}
