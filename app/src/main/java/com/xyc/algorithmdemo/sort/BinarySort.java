package com.xyc.algorithmdemo.sort;

import com.xyc.algorithmdemo.binary.BinaryHeap;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 * 不稳定排序
 * Created by xieyusheng on 2019/11/8.
 */

public class BinarySort {

    BinaryHeap binaryHeap = new BinaryHeap();

    public void heapSort(int[] arr) {
        // 将二叉树变成最小二叉堆
        for (int i = (arr.length - 2) / 2; i > 0; i--) {
            binaryHeap.downAdjust(arr, i, arr.length);
        }
        // 将数组进行排序，输出的数据放到最后面
        for (int i = arr.length - 1; i > 0; i--) {
            // 将二叉树的顶端和数组的最后一位交换，从后往前构建二叉树
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            // 重新调整二叉树
            binaryHeap.downAdjust(arr, 0, i);
        }
    }
}
