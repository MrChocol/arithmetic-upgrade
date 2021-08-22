package com.chocol.arithmetic.aug2021;

import org.junit.jupiter.api.Test;
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
public class Day20Test {

    @Test
    public void test01() {
        int[][] ghosts = {{1, 0}, {0, 3}};
        int[] target = {0, 1};
        boolean result = escapeGhosts(ghosts, target);
        assert true == result;
    }

    /**
     * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是'target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从'ghosts[i] =
     * [xi, yi]'出发。所有输入均为 整数坐标 。
     * 
     * 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。
     * 
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     * 
     * 只有在你有可能成功逃脱时，输出 true ；否则，输出 false 。
     * 
     * 链接：https://leetcode-cn.com/problems/escape-the-ghosts
     *
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // 只用判断ghost和吃豆人到达终点的距离大小即可判断是否能安全到达(守株待兔)
        // 就是比较曼哈段距离(两点之间x坐标与y坐标的距离)
        int manTargetStep = Math.abs(target[0]) + Math.abs(target[1]);

        for (int i = 0; i < ghosts.length; i++) {
            int ghostTargetStep = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
            if (ghostTargetStep <= manTargetStep) {
                return false;
            }
        }

        return true;
    }

}
