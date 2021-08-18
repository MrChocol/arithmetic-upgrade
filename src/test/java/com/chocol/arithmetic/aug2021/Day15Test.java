package com.chocol.arithmetic.aug2021;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
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
public class Day15Test {

    @Test
    public void test01() {
        List<String> result = letterCombinations("23");
        System.out.println();
    }

    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     *
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return ans;
        }
        Map<Integer, List<Character>> mapping = new HashMap<>(8);
        mapping.put(50, Arrays.asList('a', 'b', 'c'));
        mapping.put(51, Arrays.asList('d', 'e', 'f'));
        mapping.put(52, Arrays.asList('g', 'h', 'i'));
        mapping.put(53, Arrays.asList('j', 'k', 'l'));
        mapping.put(54, Arrays.asList('m', 'n', 'o'));
        mapping.put(55, Arrays.asList('p', 'q', 'r', 's'));
        mapping.put(56, Arrays.asList('t', 'u', 'v'));
        mapping.put(57, Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int ascii = digits.charAt(i);
            if (mapping.containsKey(ascii)) {
                List<Character> characters = mapping.get(ascii);
                if (i == 0) {
                    res = characters.stream().map(String::valueOf).collect(Collectors.toList());;
                } else {
                    res = build(res, characters);
                }
            }
        }

        ans = res;

        return ans;
    }

    private List<String> build(List<String> dp, List<Character> phoneMap) {
        List<String> res = new ArrayList<>();
        for (String s : dp) {
            for (Character character : phoneMap) {
                res.add(s + character);
            }
        }

        return res;
    }

}
