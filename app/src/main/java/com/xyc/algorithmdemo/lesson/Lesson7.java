package com.xyc.algorithmdemo.lesson;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author youer
 * @date 2021/8/6
 */
public class Lesson7 {

    public static void main(String[] args) {
        Lesson7 lesson7 = new Lesson7();
        System.out.println(lesson7.reverse(123));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            x = x / 10;
        }
        return result;
    }
} 