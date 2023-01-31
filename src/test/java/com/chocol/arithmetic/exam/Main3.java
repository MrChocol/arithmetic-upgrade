package com.chocol.arithmetic.exam;

import java.util.*;

public class Main3 {

    /**
     * 3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
     * 4-5-6-7-8-8-8
     *
     * 3-3-3-3-8-8-8-8
     * K-K-K-K
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 当前手中的牌
        String[] curr = sc.nextLine().split("-");
        // 已经出过的牌
        String[] his = sc.nextLine().split("-");

        // 牌库 0-3,2-12,B-13,c-14
        int[] all = new int[15];
        Arrays.fill(all, 4);
        // 大王小王各一张
        all[13] = 1;
        all[14] = 1;

        // 牌库去掉历史牌和自己手上的牌
        for (int i = 0; i < curr.length; i++) {
            if ("B".equals(curr[i])) {
                all[13]--;
            } else if ("C".equals(curr[i])) {
                all[13]--;
            } else if ("2".equals(curr[i])) {
                all[12]--;
            } else if ("A".equals(curr[i])) {
                all[11]--;
            } else if ("K".equals(curr[i])) {
                all[10]--;
            } else if ("Q".equals(curr[i])) {
                all[9]--;
            } else if ("J".equals(curr[i])) {
                all[8]--;
            } else {
                all[Integer.parseInt(curr[i]) - 3]--;
            }
        }
        // 牌库去掉历史牌和自己手上的牌
        for (int i = 0; i < his.length; i++) {
            if ("B".equals(his[i])) {
                all[13]--;
            } else if ("C".equals(his[i])) {
                all[13]--;
            } else if ("2".equals(his[i])) {
                all[12]--;
            } else if ("A".equals(his[i])) {
                all[11]--;
            } else if ("K".equals(his[i])) {
                all[10]--;
            } else if ("Q".equals(his[i])) {
                all[9]--;
            } else if ("J".equals(his[i])) {
                all[8]--;
            } else {
                all[Integer.parseInt(his[i]) - 3]--;
            }
        }

        int right = 11;
        int left = 10;
        StringBuilder ans = new StringBuilder();
        while (all[right] == 0) {
            right--;
        }
        // 遍历剩下的牌，获取最长的3-A之间的
        while (left >= 4 && right >= 4) {
            // left向前移动，如果还有牌则继续向前
            int memo = 1;
            while (left >=4 && all[left] > 0) {
                memo++;
                left--;
            }
            if (memo >= 5) {
                // 拼接right到left的所有字符串
                for (int i = left + 1; i <= right; i++) {
                    if (i == 11) {
                        ans.append("A");
                    } else if (i == 10) {
                        ans.append("K");
                    } else if (i == 9) {
                        ans.append("Q");
                    } else if (i == 8) {
                        ans.append("J");
                    } else {
                        ans.append(i + 3);
                    }
                    if (i != right) {
                        ans.append("-");
                    }
                }
                System.out.println(ans.toString());
                return;
            }
            // 如果没有牌，先判断当前连续长度是否大于5，如果有则直接返回，没有则right==left-1，left=right-1
            if (left >= 4) {
                right = left - 1;
                left = right - 1;
            }
        }
        System.out.println("NO-CHAIN");
    }
}
