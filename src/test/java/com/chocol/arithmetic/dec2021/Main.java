package com.chocol.arithmetic.dec2021;

import java.util.Scanner;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/11/30
 * @since
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int empBot = scanner.nextInt();
            System.out.println(getMaxBot(empBot));
        }
    }

    public static int getMaxBot(int empBot) {
        if (empBot < 2) {
            return 0;
        }
        int bot = 0;
        while (empBot > 1) {
            if (empBot == 2) {
                bot++;
                return bot;
            } else {
                int i = empBot / 3;
                bot += i;
                empBot = empBot % 3 +i;
            }
        }
        return bot;
    }
}
