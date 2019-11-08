package com.xyc.algorithmdemo.structure;

/**
 * Created by xieyusheng on 2019/11/8.
 */

public class Array {
    private int[] array;
    // 当前数组中元素的个数
    private int size;

    /**
     * 数组的最大长度
     *
     * @param capacity
     */
    public Array(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }


    /**
     * 数组插入元素
     *
     * @param element
     * @param index
     * @throws Exception
     */
    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        if (size >= array.length) {

        }
        // 所有的元素向后挪动一位
        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public int delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int result = array[index];
        // 所有的元素向前挪动一位
        for (int i = index; i < size - 1; i--) {
            array[i] = array[i + 1];
        }
        size--;
        return result;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    public void output() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
