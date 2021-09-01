package com.chocol.arithmetic.aug2021;

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
public class Day29Test {

    @Test
    public void test01() {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = corpFlightBookings(bookings, n);
        log.info("{}", result);
        System.out.println();
    }

    /**
     * 1109. 航班预订统计
     *
     * 这里有n个航班，它们分别从 1 到 n 进行编号。
     * 
     * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班
     * 上预订了 seatsi个座位。
     * 
     * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
     * 
     * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
     *
     * 1 <= n <= 2 * 104 <br/>
     * 1 <= bookings.length <= 2 * 104 <br/>
     * bookings[i].length == 3 <br/>
     * 1 <= firsti <= lasti <= n <br/>
     * 1 <= seatsi <= 104 <br/>
     *
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];

            for (int i1 = first - 1; i1 < last; i1++) {
                ans[i1] += seats;
            }
        }

        return ans;
    }

    /**
     * 差分法,例如数据[1,2,2,4] 差分数组为[1,1,0,2]记录每一次差分的量
     * 
     * 类似，数据nums记录每一站飞机上的人数,起点站firsti+seatsi，到了终点站飞机上的乘客全部下车lasti-seatsi
     * 
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int seats = bookings[i][2];
            // 实际上飞机的人数
            ans[bookings[i][0] - 1] += seats;
            if (bookings[i][1] < n) {
                // 终点站下掉本次航班的所有人
                ans[bookings[i][1]] -= seats;
            }

        }
        // 将差分还原累加
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }

}
