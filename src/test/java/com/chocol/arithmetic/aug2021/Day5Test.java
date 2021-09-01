package com.chocol.arithmetic.aug2021;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
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
public class Day5Test {

    @Test
    public void test01() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);

        System.out.println();
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return nums == null ? null : buildBST(0, nums.length - 1, nums);
    }

    public TreeNode buildBST(int begin, int end, int[] nums) {
        if (begin > end) {
            return null;
        }

        // 采用分治算法
        int middle = (begin + end + 1) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildBST(begin, middle - 1, nums);
        node.right = buildBST(middle + 1, end, nums);

        return node;
    }

}
