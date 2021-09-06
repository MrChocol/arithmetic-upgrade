package com.chocol.arithmetic.sep2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chocol.arithmetic.SolBase;

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
public class Day5Test extends SolBase {

    @Test
    public void test01() {
        int result = rand10();
        System.out.println();
    }

    /**
     * 470. 用 Rand7() 实现 Rand10()
     *
     * 已有方法rand7可生成 1 到 7 范围内的均匀随机整数，试写一个方法rand10生成 1 到 10 范围内的均匀随机整数。
     * 
     * 不要使用系统的Math.random()方法。
     * 
     * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
     * 
     * @return
     */
    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

}
