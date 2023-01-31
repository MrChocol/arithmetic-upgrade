package com.chocol.arithmetic.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/11/30
 * @since
 */
public class Main2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String s = String.valueOf(size);
        char[] chars = s.toCharArray();
        int[] memo = new int[10];
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            if(memo[chars[i]-'0']==0){
                sb.append(chars[i]-'0');
            }
            memo[chars[i]-'0']++;
        }
        System.out.println(sb);
    }}
