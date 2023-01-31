package com.chocol.arithmetic.exam;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] split = line.split("\\)");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            // 300,400
            if (!split[i].contains("(")) {
                break;
            }
            String as = split[i].substring(split[i].indexOf('(') + 1);
            String[] split1 = as.split(",");
            if (split1[0].startsWith("0") || "0".equals(split1[0]) || split1[1].startsWith("0")
                || "0".equals(split1[1])) {
                continue;
            }
            list.add(split1[0] + "," + split1[1]);
        }
        int maxLen = 0;
        String maxIndex = "(0,0)";
        for (int i = 0; i < list.size(); i++) {
            String[] split2 = list.get(i).split(",");
            Integer x = Integer.valueOf(split2[0]);
            Integer y = Integer.valueOf(split2[1]);
            int len = x * x + y * y;
            if (len > maxLen) {
                maxLen = len;
                maxIndex = String.format("(%d,%d)", x, y);
            }
        }
        System.out.println(maxIndex);
    }
}
