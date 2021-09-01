package com.chocol.arithmetic.aug2021;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

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
public class Day24Test {

    @Test
    public void test01() {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        int result = numRescueBoats(people, limit);
        assert 4 == result;
    }

    /**
     * 881. 救生艇
     * 
     * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
     * 
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
     * 
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     * 
     * 1 <= people.length <= 50000
     * 
     * 1 <= people[i] <= limit <= 30000
     * 
     * 链接：https://leetcode-cn.com/problems/boats-to-save-people
     *
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        // 最多只能载两人
        Arrays.sort(people);
        // 左指针跟右指针匹配，如果两者之和大于limit时，则这个范围呢需要两两配对，右指针后面的都需要单独的船
        int split = 0;
        for (; split < people.length; split++) {
            if (people[split] == limit) {
                break;
            }
        }
        int ans = people.length - split;

        int left = 0;
        int right = split - 1;
        while (left <= right) {
            if (left == right) {
                return ++ans;
            }
            if (people[left] + people[right] > limit) {
                ans++;
                right--;
            } else {
                ans++;
                left++;
                right--;
            }
        }

        return ans;
    }

}
