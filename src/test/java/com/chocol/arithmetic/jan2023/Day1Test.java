package com.chocol.arithmetic.jan2023;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @author 陈力
 * @date 2023-01-30 14:31:50
 * @since
 */
@Slf4j
@SpringBootTest
public class Day1Test {

    @Test
    public void test01() {
        String fruits = "l|*e*et|c**o|*de|";
        int res = countAsterisks(fruits);
        assert res == 2;
        System.out.println(res);
    }

    /**
     * 2315. 统计星号
     * 给你一个字符串s，每两个连续竖线'|'为 一对。换言之，第一个和第二个'|'为一对，第三个和第四个'|'为一对，以此类推。
     * <p>
     * 请你返回 不在 竖线对之间，s中'*'的数目。
     * <p>
     * 注意，每个竖线'|'都会 恰好属于一个对。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/count-asterisks/
     * <p>
     * 1 <= s.length <= 1000
     * s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
     * s 包含 偶数 个竖线 '|' 。
     *
     * @return
     */
    public int countAsterisks(String s) {
        int res = 0;
        String[] split = s.split("\\|");
        // 取偶数的字符串统计星号
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                res += split[i].length() - split[i].replaceAll("\\*", "").length();
            }
        }
        return res;
    }

}
