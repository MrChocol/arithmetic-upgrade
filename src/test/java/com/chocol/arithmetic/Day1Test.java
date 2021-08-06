package com.chocol.arithmetic;

import com.chocol.arithmetic.DO.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/7
 * @since
 */
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        // TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root =
            new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        // List<Integer> res = inorderTraversal1(root);
        List<Integer> res = inorderTraversal2(root);

        System.out.println();
    }

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。（就是从左到右进行遍历）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。（就是从左到右进行遍历）<br/>
     * 通过维护一个栈来进行遍历<br/>
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        // 直到节点为空或者栈中元素全部弹出为止
        while (root != null || !stk.isEmpty()) {
            // 直接深入到最左边的节点 过程中将遍历到的节点压入栈中
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 已经到了最左边的节点，则弹出这个节点取出值，再进行这个节点右边节点的遍历
            // 如果右边节点不为空则继续进入上面的压栈循环
            // 如果右边节点为空则继续取栈中的元素
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
