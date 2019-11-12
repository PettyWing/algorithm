package com.xyc.algorithmdemo.structure;

/**
 * 循环队列
 * Created by xieyusheng on 2019/11/11.
 */

public class Queue {
    private int[] array;
    private int front;  // 队头
    private int rear;   // 队尾

    public Queue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队的元素
     * @throws Exception
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        // 给队尾元素赋值
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     *
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int element = array[front];
        front = (front + 1) % array.length;
        return element;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }
}
