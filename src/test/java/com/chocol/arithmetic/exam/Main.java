package com.chocol.arithmetic.exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = String.valueOf(in.nextInt());
            String b = String.valueOf(in.nextInt());
            int carry = 0;
            StringBuilder ans = new StringBuilder();
            int ai = a.length() - 1;
            int bi = b.length() - 1;
            while (ai >= 0 || bi >= 0) {
                int i = 0;
                if (ai >= 0) {
                    i = a.charAt(ai) - '0';
                }
                int j = 0;
                if (bi >= 0) {
                    j = (b.charAt(bi) - '0');
                }
                int sum = i + j + carry;
                carry = sum / 10;
                ans.append(sum % 10);
                ai--;
                bi--;
            }
            if (carry != 0) {
                ans.append(carry % 10);
            }

            System.out.println(ans.reverse().toString());
        }
    }
}
