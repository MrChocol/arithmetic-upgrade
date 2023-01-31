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
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Map<Integer,Integer> ans = new HashMap<>(size);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] split = line.split(" ");
            ans.merge(Integer.valueOf(split[0]),Integer.valueOf(split[1]), Integer::sum);
        }
        ans.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }}
