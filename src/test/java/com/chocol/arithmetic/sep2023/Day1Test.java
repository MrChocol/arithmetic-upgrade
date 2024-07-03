package com.chocol.arithmetic.sep2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-7-25 15:18:46
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        int[] gem = {100, 0, 50, 100};
        int[][] operations = {{0, 2}, {0, 1}, {3, 0}, {3, 0}};
        int res = giveGem(gem, operations);
        System.out.println(res);
    }

    /**
     * LCP 50. 宝石补给
     * 欢迎各位勇者来到力扣新手村，在开始试炼之前，请各位勇者先进行「宝石补给」。
     * <p>
     * 每位勇者初始都拥有一些能量宝石， gem[i] 表示第 i 位勇者的宝石数量。现在这些勇者们进行了一系列的赠送，operations[j] = [x, y] 表示在第 j 次的赠送中 第 x 位勇者将自己一半的宝石（需向下取整）赠送给第 y 位勇者。
     * <p>
     * 在完成所有的赠送后，请找到拥有最多宝石的勇者和拥有最少宝石的勇者，并返回他们二者的宝石数量之差。
     * <p>
     * 注意：
     * <p>
     * 赠送将按顺序逐步进行。
     * <p>
     * https://leetcode.cn/problems/WHnhjV/description/?envType=daily-question&envId=2023-09-15
     * <p>
     * 2 <= gem.length <= 10^3
     * 0 <= gem[i] <= 10^3
     * 0 <= operations.length <= 10^4
     * operations[i].length == 2
     * 0 <= operations[i][0], operations[i][1] < gem.length
     *
     * @return
     */
    public int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            gem[operations[i][1]] = gem[operations[i][1]] + gem[operations[i][0]] / 2;
            gem[operations[i][0]] = gem[operations[i][0]] - gem[operations[i][0]] / 2;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

}
