package com.chocol.arithmetic.huawei;

import java.util.Scanner;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/11/30
 * @since
 */
public class MainHJ10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int[] memo = new int[127];
        for (char c : chars) {
            if (c >= 0 && c <= 127) {
                memo[c]++;
            }
        }
        int ans = 0;
        for (int i : memo) {
            ans = ans + (i > 0 ? 1 : 0);
        }
        System.out.println(ans);
    }
}
