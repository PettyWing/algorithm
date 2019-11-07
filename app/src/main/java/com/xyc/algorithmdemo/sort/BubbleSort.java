package com.xyc.algorithmdemo.sort;

/**
 * 冒泡排序
 * O(n2)
 * Created by xieyusheng on 2019/11/7.
 */

public class BubbleSort {

    /**
     * 普通排序
     */
    public void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 带上记录是否已经有序的标志
     */
    public void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标志，每轮的初始值为true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //表明有元素交换，还没有有序
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 带上记录是否已经有序的标志并且记录最后一次数据交换的位置
     * O(n2)
     */
    public void sort3(int[] array) {
        int lastExchangeIndex = 0;
        // 数列的边界
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            // 有序标志，每轮的初始值为true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //表明有元素交换，还没有有序
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }
}
