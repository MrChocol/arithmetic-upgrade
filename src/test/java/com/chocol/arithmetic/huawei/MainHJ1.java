package com.chocol.arithmetic.huawei;

import java.util.Scanner;

public class MainHJ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] s = line.split(" ");
        System.out.println(s[s.length-1].length());
    }
}
