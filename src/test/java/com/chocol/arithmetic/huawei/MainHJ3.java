package com.chocol.arithmetic.huawei;

import java.util.*;

public class MainHJ3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> ans = new ArrayList<>();
        // 需要循环读取
        while (sc.hasNext()) {
            // 样本大小
            int size = sc.nextInt();
            Set<Integer> set = new HashSet<>(size);
            // 获取样本
            while (sc.hasNext() && size > 0) {
                size--;
                set.add(sc.nextInt());
            }
            ArrayList<Integer> memo = new ArrayList<>(set);
            Collections.sort(memo);
            ans.addAll(memo);
        }
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
