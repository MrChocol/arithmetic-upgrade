package com.chocol.arithmetic.aug2021;

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
public class Day19Test {

    @Test
    public void test01() {
        char[] chars =
            {'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
                'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        int result = compress(chars);
        assert 6 == result;
    }

    /**
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * 
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 
     * 如果这一组长度为 1 ，则将字符追加到 s 中。 否则，需要向 s 追加字符，后跟这一组的长度。 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10
     * 以上，则在 chars 数组中会被拆分为多个字符。
     * 
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * 
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     * 
     * 链接：https://leetcode-cn.com/problems/string-compression
     *
     * @return
     */
    public int compress(char[] chars) {
        int write = 0;
        int length = chars.length;
        int left = 0;
        for (int read = 0; read < length; read++) {
            // 当到了末尾或者read到了子串右边界的地方
            if (read == length - 1 || chars[read] != chars[read + 1]) {
                // 将后面的字符往前赋值
                chars[write++] = chars[read];
                int len = read + 1 - left;
                if (len > 1) {
                    // 记录赋值的位置，需要在赋值位置后面写入数字
                    int temp = write;
                    while (len > 0) {
                        // 先取余，把个位数进行处理
                        chars[write++] = (char)(len % 10 + '0');
                        len /= 10;
                    }
                    // 最后需要把数字在数组中的位置进行翻转
                    reverser(chars, temp, write - 1);
                }
                left = read + 1;
            }
        }

        return write;
    }

    private void reverser(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }

}
