package com.chocol.arithmetic.huawei;

import java.util.Scanner;

public class MainHJ13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length-1; i >=0; i--) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb);
    }
}
