package com.chocol.arithmetic.huawei;

import java.util.Scanner;

public class MainHJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();
        int[] memo = new int[128];
        for (int i = 0; i < line.length(); i++) {
            memo[line.charAt(i)]++;
        }
        String target = sc.nextLine();

        System.out.println(memo[target.toLowerCase().charAt(0)]);
    }
}
