package com.chocol.arithmetic.dec2021;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.DO.TreeNode;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/7
 * @since
 */
@SpringBootTest
public class Day2Test {

    @Test
    public void test01() {
        String num1 = "1234", num2 = "567";
        assert multiply2(num1, num2).equals("699678");
        System.out.println();
    }

    /**
     * 43. 字符串相乘
     *
     * 
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 
     * 说明：
     *
     * num1和num2的长度小于110。<br/>
     * num1 和num2 只包含数字0-9。<br/>
     * num1 和num2均不以零开头，除非是数字 0 本身。<br/>
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。<br/>
     *
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        String ans = "0";
        // 对每次的乘积进行累加
        for (int i = chars1.length - 1; i >= 0; i--) {
            int x = chars1[i] - '0';
            StringBuilder curr = new StringBuilder();
            // 还需要补位，个位*十位需要在最后加一个0，个位*百位需要加2个0
            for (int k = num1.length() - 1; k > i; k--) {
                curr.append("0");
            }
            // 进位
            int carry = 0;
            for (int j = chars2.length - 1; j >= 0; j--) {
                int y = chars2[j] - '0';
                int dp = x * y + carry;
                curr.append(dp % 10);
                carry = dp / 10;
            }
            if (carry != 0) {
                curr.append(carry % 10);
            }

            ans = addStr(ans, curr.reverse().toString());
        }

        return ans;
    }

    /**
     * 计算两个字符串的和
     * 
     * @param str1
     * @param str2
     */
    private String addStr(String str1, String str2) {
        int carry = 0;
        int l1 = str1.length() - 1;
        int l2 = str2.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (l1 >= 0 || l2 >= 0 || carry != 0) {
            int x = l1 >= 0 ? str1.charAt(l1) - '0' : 0;
            int y = l2 >= 0 ? str2.charAt(l2) - '0' : 0;
            int sum = x + y + carry;
            ans.append(sum % 10);
            carry = sum / 10;
            l1--;
            l2--;
        }

        return ans.reverse().toString();
    }

    /**
     * 如果num1和num2都是最小值，那么结果位数则为m+n-1 如果都为最大值，那么结果位数为m+n
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int[] ans = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = chars1.length - 1; i >= 0; i--) {
            int x = chars1[i] - '0';
            // 计算位数
            for (int j = chars2.length - 1; j >= 0; j--) {
                int base = i + j + 1;
                int y = chars2[j] - '0';
                int dp =  (x * y + carry) +ans[base];
                ans[base] = dp % 10;
                carry = dp / 10;
            }
            if (carry != 0) {
                ans[i] = carry % 10;
                carry=0;
            }
        }

        StringBuilder res = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while (index < ans.length) {
            res.append(ans[index]);
            index++;
        }
        return res.toString();
    }
}
