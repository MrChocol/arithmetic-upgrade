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
public class Day1Test {

    @Test
    public void test01() {
        String version1 = "1.01", version2 = "1.001";
        int result = compareVersion(version1, version2);
        System.out.println();
    }

    /**
     * 1109. 航班预订统计
     *
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     * 
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1
     * ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     * 
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本
     * 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     * 
     * 返回规则如下：
     * 
     * 如果version1>version2返回1， 如果version1<version2 返回 -1， 除此之外返回 0。
     * 
     * 链接：https://leetcode-cn.com/problems/compare-version-numbers
     *
     * 提示：
     * 
     * 1 <= version1.length, version2.length <= 500 <br/>
     * version1 和 version2 仅包含数字和 '.' <br/>
     * version1 和 version2 都是 有效版本号 <br/>
     * version1 和 version2 的所有修订号都可以存储在 32 位整数 中 <br/>
     *
     * 
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            // Integer.parseInt 会把001 01直接解析成1
            int v1 = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            int v2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * 利用累计算法比较每一段的最终大小
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion2(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();

        int v1 = 0, v2 = 0;
        while (v1 < length1 || v2 < length2) {
            int x = 0;
            for (; v1 < length1 && version1.charAt(v1) != '.'; v1++) {
                x = x * 10 + version1.charAt(v1) - '0';
            }
            // 需要跳过.号
            v1++;
            int y = 0;
            for (; v2 < length2 && version2.charAt(v2) != '.'; v2++) {
                y = y * 10 + version2.charAt(v2) - '0';
            }
            // 需要跳过.号
            v2++;

            if (x != y) {
                return x > y ? 1 : -1;
            }
        }

        return 0;
    }

}
