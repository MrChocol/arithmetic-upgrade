package com.chocol.arithmetic.oct2021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

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
public class Day1Test {

    @Test
    public void test01() {
        List<String> ans = fizzBuzz(15);
        System.out.println();
    }

    /**
     * 412. Fizz Buzz
     *
     * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
     * 
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。 <br/>
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。 <br/>
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。 <br/>
     * answer[i] == i 如果上述条件全不满足。 <br/>
     * 
     * 链接：https://leetcode-cn.com/problems/fizz-buzz
     *
     * 提示：
     * 
     * 1 <= n <= 104 <br/>
     *
     * 
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }

}
