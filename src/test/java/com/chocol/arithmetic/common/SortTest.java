package com.chocol.arithmetic.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/12/3
 * @since
 */
@SpringBootTest
@Slf4j
public class SortTest {

    /**
     * 快速排序
     */
    @Test
    public void fastSortTest() {
        int[] arr = {4, 3, 7, 5, 10, 9, 1, 6, 8, 2};
        fastSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void fastSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }

        int left = low;
        int right = high;
        // 定义左边坑位
        int temp = arr[left];
        while (left < right) {
            // 从右边界开始从后往前找比temp小的值
            while (left < right && arr[right] > temp) {
                right--;
            }
            // 将右边的最小值赋给左边
            arr[left] = arr[right];

            // 从左边界开始从前往后查找比temp大的值
            while (left < right && arr[left] < temp) {
                left++;
            }
            // 将左边的最大值赋给右边
            arr[right] = arr[left];
        }
        // 循环完成后，需要把temp值填回坑位
        arr[left] = temp;
        System.out.println(Arrays.toString(arr));
        // 开始分冶算法
        fastSort(arr, low, left - 1);
        fastSort(arr, right + 1, high);
    }
}
