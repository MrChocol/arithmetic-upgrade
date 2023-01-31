package com.chocol.arithmetic.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainHJ14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<String> ans = new ArrayList<>(size);
        sc.nextLine();
        while (sc.hasNext()){
            String line = sc.nextLine();
            ans.add(line);
        }
        Collections.sort(ans);

        for (String an : ans) {
            System.out.println(an);
        }
    }
}
