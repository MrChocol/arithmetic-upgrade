package com.chocol.arithmetic.aug2021;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day11Test {

    @Test
    public void test01() {
        List<String> result = generateParenthesis(3);

        System.out.println();;
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 
     * @return
     */
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return result;
        }
        generateParenthesis("", n, n);

        return result;
    }

    public void generateParenthesis(String prefix, int left, int right) {
        // 左括号和右括号同时消耗完即跳出递归
        log.info("left:{},right:{},prefix:{}", left, right, prefix);
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }
        if (left > 0) {
            generateParenthesis(prefix + "(", left - 1, right);
        }
        if (right > left) {
            generateParenthesis(prefix + ")", left, right - 1);
        }
    }

}
