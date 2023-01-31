package com.chocol.arithmetic.common;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/12/3
 * @since
 */
@SpringBootTest
@Slf4j
public class FindTest {

    /**
     * 二分查找
     */
    @Test
    public void fastSortTest() {
        int[] arr = {4, 3, 7, 5, 10, 9, 1, 6, 8, 2};
        Arrays.sort(arr);
        int index = binarySearch(arr, 10);
        System.out.println();
    }

    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
