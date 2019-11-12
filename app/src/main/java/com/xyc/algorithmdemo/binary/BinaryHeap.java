package com.xyc.algorithmdemo.binary;

/**
 * 二叉堆
 * 二叉树可以物理结构可以用数组，父节点位置为a,子节点位置为2a+1,2a+2
 * Created by xieyusheng on 2019/11/7.
 */

public class BinaryHeap {
    /**
     * 构建堆
     */
    public void buildHeap(int[] arr) {
        // 从最后一个非叶子节点开始，依次做下沉
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }
    }

    /**
     * "下沉"调整，将一个完全二叉树变成最小二叉堆
     *
     * @param arr
     * @param parentIndex
     * @param length
     */
    public void downAdjust(int[] arr, int parentIndex, int length) {
        // tmp保存父节点的值，用于最后的赋值
        int tmp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子节点，并且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子节点，则直接break
            if (tmp <= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = tmp;
    }

    /**
     * 上浮，当一个新的元素进来的时候，重新构建最小二叉堆，并可以输出最小的元素
     *
     * @param aar
     */
    public void upAdjust(int[] aar) {
        int childIndex = aar.length - 1;
        int parentIndex = (childIndex - 1) / 2; // 向下取整
        // 保存插入的叶子节点值，用于最后的赋值
        int tmp = aar[childIndex];
        while (childIndex > 0 && tmp < aar[parentIndex]) {
            aar[childIndex] = aar[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        aar[parentIndex] = tmp;
    }
}
