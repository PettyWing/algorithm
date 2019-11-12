package com.xyc.algorithmdemo.structure;

/**
 * 链表
 * Created by xieyusheng on 2019/11/8.
 */

public class NodeList {
    // 头结点
    private Node head;
    // 尾节点
    private Node last;
    // 链表的长度
    private int size;

    /**
     * 插入数据
     *
     * @param data  插入元素
     * @param index 插入位置
     * @throws Exception
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node node = new Node(data);
        if (size == 0) {
            // 空链表
            head = node;
            last = node;
        } else if (index == 0) {
            // 插入头部
            node.next = head;
            head = node;
        } else if (index == size) {
            // 插入尾部
            last.next = node;
            last = node;
        } else {
            Node prev = get(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node node = null;
        if (index == 0) {
            node = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prev = get(index - 1);
            node = last;
            prev.next = last.next;
            last = prev;
        } else {
            Node prev = get(index - 1);
            node = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return node;
    }

    /**
     * 链表中查找元素
     *
     * @param index 查找的位置
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void output() {
        Node tmp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
