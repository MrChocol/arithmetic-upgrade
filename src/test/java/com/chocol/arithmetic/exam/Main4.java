package com.chocol.arithmetic.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    /**
     * CBEFDA CBAEDF
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] s = line.split(" ");
        String after = s[0];
        String mid = s[1];

        List<TreeNode> treeNodes = new ArrayList<>();
        // 左边节点小于右边节点，子节点小于父节点
        for (int i = 1; i < after.length() - 2; i += 2) {
            if (after.charAt(i) > after.charAt(i - 1) && after.charAt(i) > after.charAt(i + 1)) {
                // BCA结构
                TreeNode currNode =
                    new TreeNode(after.charAt(i + 1), new TreeNode(after.charAt(i - 1)), new TreeNode(after.charAt(i)));
                treeNodes.add(currNode);
            } else{
                // CB结构
                TreeNode currNode = new TreeNode(after.charAt(i), new TreeNode(after.charAt(i-1)), null);
                treeNodes.add(currNode);
            }
        }
        System.out.println();
        // mid如果当前字母小于前者也小于后者，则说明为左右节点的父节点
    }

    public static class TreeNode {
        Character value;
        TreeNode left;
        TreeNode right;

        public TreeNode(Character value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode(Character value) {
            this.value = value;
        }
    }
}
