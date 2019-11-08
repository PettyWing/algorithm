package com.xyc.algorithmdemo.sort;

/**
 * 快速排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 * 不稳定排序
 * 设定一个基准值（一般是第一个元素），比他大的都放在右边，比他小的都放在左边，然后把最后的坐标值和基准值位置交换
 * Created by xieyusheng on 2019/11/7.
 */

public class QuickSort {

    /**
     * @param aar
     * @param startIndex
     * @param endIndex
     */
    public void sort(int[] aar, int startIndex, int endIndex) {
        int pivotIndex = partition(aar, startIndex, endIndex);
        // 根据第一次分离的结果，递归对两边进行排序
        sort(aar, pivotIndex + 1, endIndex);
        sort(aar, startIndex, pivotIndex - 1);
    }

    /**
     * 双边快速排序,给数组分边-数据会根据startIndex为基准值，给数据分边，并且返回基准值的坐标
     *
     * @param aar
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int partition(int[] aar, int startIndex, int endIndex) {
        int pivot = aar[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制右边坐标左移
            while (left < right && aar[right] > pivot) {
                right--;
            }
            // 控制左边坐标右移
            while (left < right && aar[left] <= pivot) {
                left++;
            }
            // 交换left和right所指向的元素
            if (left < right) {
                int tmp = aar[right];
                aar[right] = aar[left];
                aar[left] = tmp;
            }
        }
        // 将left的值和基准值交换
        aar[startIndex] = aar[left];
        aar[left] = pivot;
        return left;
    }

    /**
     * 单边快速排序,给数组分边-数据会根据startIndex为基准值，给数据分边，并且返回基准值的坐标
     *
     * @param aar
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int partition1(int[] aar, int startIndex, int endIndex) {
        int pivot = aar[startIndex];
        int mark = startIndex;
        // 从起始位置开始，依次把如果i这个点的值比pivot小，则把他和mark点进行交换
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (aar[i] < pivot) {
                mark++;
                int tmp = aar[mark];
                aar[mark] = aar[i];
                aar[i] = tmp;
            }
        }
        aar[startIndex] = aar[mark];
        aar[mark] = pivot;
        return mark;
    }

}
