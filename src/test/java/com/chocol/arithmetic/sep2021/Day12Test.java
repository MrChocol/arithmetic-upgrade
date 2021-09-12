package com.chocol.arithmetic.sep2021;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day12Test {

    @Test
    public void test01() {
        assert !checkValidString(
            "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }

    /**
     * 678. 有效的括号字符串
     *
     * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
     * 
     * 任何左括号 (必须有相应的右括号 )。 <br/>
     * 任何右括号 )必须有相应的左括号 (。 <br/>
     * 左括号 ( 必须在对应的右括号之前 )。 <br/>
     * 可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。 一个空字符串也被视为有效字符串。 <br/>
     * 
     * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
     *
     * 说明:
     * 
     * 字符串大小将在 [1，100] 范围内。
     * 
     * @return
     */
    public boolean checkValidString(String s) {
        // 存储左括号的栈
        Deque<Integer> leftStack = new LinkedList<>();
        // 存储星号的栈
        Deque<Integer> startStack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
                continue;
            }
            if (c == '*') {
                startStack.push(i);
                continue;
            }
            if (c == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!startStack.isEmpty()) {
                    startStack.pop();
                } else {
                    return false;
                }
            }
        }

        // 两个栈可能还不为空,但是每个左括号必须在星号之前
        while (!leftStack.isEmpty() && !startStack.isEmpty()) {
            if (leftStack.peek() < startStack.peek()) {
                // 左括号在星号之前
                leftStack.pop();
                startStack.pop();
            } else {
                return false;
            }
        }

        return leftStack.isEmpty();
    }

}
