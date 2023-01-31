package com.chocol.arithmetic.huawei;

import java.util.Scanner;

public class MainHJ91 {

    /**
     * n*m代表格子数，走方格是按照方格边缘线走的，因此获取到的m和n需要加1
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int n = Integer.parseInt(split[0]) + 1;
            int m = Integer.parseInt(split[1]) + 1;

            // dp[x][y]表示从(0,0)到dp[x][y]的走法数量
            // dp[x][y] = dp[x-1][y]+dp[x-1][y-1]+dp[x][y-1]
            int[][] dp = new int[n][m];
            // 填充两边
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < m; j++) {
                dp[0][j] = 1;
            }
            for (int x = 1; x < n; x++) {
                for (int y = 1; y < m; y++) {
                    dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
                }
            }
            System.out.println(dp[n - 1][m - 1]);
        }
    }
}
