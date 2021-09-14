package com.chocol.arithmetic.sep2021;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
public class Day13Test {

    @Test
    public void test01() {
        assert 2 == numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}, {2, 0}});
    }

    /**
     * 447. 回旋镖的数量
     *
     * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
     * 
     * 返回平面上所有回旋镖的数量。
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-boomerangs 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 说明:
     *
     * n ==points.length <br/>
     * 1 <= n <= 500 <br/>
     * points[i].length == 2 <br/>
     * -104 <= xi, yi <= 104 <br/>
     * 所有点都 互不相同
     * 
     * @return
     */
    public int numberOfBoomerangs2(int[][] points) {
        // 暴力破解(超时)
        if (points.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int left = 0; left < points.length; left++) {
                if (i == left)
                    continue;
                for (int right = 0; right < points.length; right++) {
                    if (left == right)
                        continue;
                    // 计算length[i,left]是否等于length[i,right]
                    double leftLength = Math.sqrt(
                        Math.pow(points[i][0] - points[left][0], 2) + Math.pow(points[i][1] - points[left][1], 2));
                    double rightLength = Math.sqrt(
                        Math.pow(points[i][0] - points[right][0], 2) + Math.pow(points[i][1] - points[right][1], 2));
                    if (leftLength == rightLength)
                        ans++;
                }
            }
        }

        return ans;
    }

    public int numberOfBoomerangs(int[][] points) {
        // 枚举+哈希
        int ans = 0;
        for (int[] l : points) {
            // key-l到r点的距离平方，value-l到r点相同距离出现的次数
            Map<Integer, Integer> memo = new HashMap<>();
            for (int[] r : points) {
                // 计算两点的距离
                int dis = (l[0] - r[0]) * (l[0] - r[0]) + (l[1] - r[1]) * (l[1] - r[1]);
                memo.put(dis, memo.getOrDefault(dis, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
                // 如果l点到另外点的距离都为length，且长度相同的点有m个，那么回旋镖的个数就有A(2,m)=m*(m-1)个
                ans += (entry.getValue() * (entry.getValue() - 1));
            }
        }
        return ans;
    }

}
