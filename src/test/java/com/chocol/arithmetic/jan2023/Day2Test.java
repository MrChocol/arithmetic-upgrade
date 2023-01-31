package com.chocol.arithmetic.jan2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-01-31 14:31:50
 * @since
 */
@Slf4j
@SpringBootTest
public class Day2Test {

    @Test
    public void test01() {
        int[][] grid = {{5, 0, 20},
                        {0, 5, 0},
                        {6, 0, 2}};
        assert checkXMatrix(grid);
    }

    /**
     * 2319. 判断矩阵是否是一个 X 矩阵
     * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
     * <p>
     * 矩阵对角线上的所有元素都 不是 0
     * 矩阵中所有其他元素都是 0
     * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/check-if-matrix-is-x-matrix
     * <p>
     * n == grid.length == grid[i].length
     * 3 <= n <= 100
     * 0 <= grid[i][j] <= 105
     *
     * @return
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        // 边界值left=[0,n-1],right=[n-1,n-1]逐渐递减，直到left>right退出循环
        int l1 = 0, l2 = n - 1;
        int r1 = n - 1, r2 = n - 1;
        while (l1 <= r1) {
            if (grid[l1][l1] != 0 && grid[l2][l1] != 0 && grid[l1][r1] != 0 && grid[r2][r2] != 0) {
                grid[l1][l1] = -1;
                grid[l2][l1] = -1;
                grid[l1][r1] = -1;
                grid[r2][r2] = -1;
                l1++;
                l2--;
                r1--;
                r2--;
            } else {
                return false;
            }
        }
        for (int[] ints : grid) {
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (ints[i1] != -1 && ints[i1] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
