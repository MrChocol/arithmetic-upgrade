package com.chocol.arithmetic.sep2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day22Test {

    @Test
    public void test01() {
        assert 30 == getSum(11, 19);
    }

    /**
     * 371. 两整数之和
     *
     * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
     *
     * 提示：
     *
     * -1000 <= a, b <= 1000 <br/>
     *
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            // a和b先进行与运算，如果两位都为1则向左进一位，这一步目的在于取a和b的进位
            int carry = (a & b) << 1;
            // a和b进行异或运算，即无进位的运算，两个位相同为0，相异为1,a保存无进位的运算结果
            a = a ^ b;
            // 将进位赋值给b
            b = carry;
        }
        return a;
    }

}
