package com.chocol.arithmetic.sep2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
public class Day18Test {

    @Test
    public void test01() {

        assert !canWinNim(4);
    }

    /**
     * 292. Nim 游戏
     *
     * 你和你的朋友，两个人一起玩Nim 游戏：
     * 
     * 桌子上有一堆石头。 你们轮流进行自己的回合，你作为先手。 每一回合，轮到的人拿掉1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n
     * 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
     * 
     * 链接：https://leetcode-cn.com/problems/nim-game
     *
     * 提示：
     * 
     * 1 <= n <= 2^31 - 1 <br/>
     *
     * @return
     */
    public boolean canWinNim(int n) {
        // n=4时必输，而且当我方为4的倍数时总是能输掉比赛，因为你不管拿多少个，对手总能想办法让剩下的石头数量变为4的倍数
        // 因此只需要让我方拿完石头后剩余4的倍数即可
        return n % 4 != 0;
    }

}
