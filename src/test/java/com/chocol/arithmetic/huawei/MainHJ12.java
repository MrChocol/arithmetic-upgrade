package com.chocol.arithmetic.huawei;

import java.util.Scanner;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/11/30
 * @since
 */
public class MainHJ12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
