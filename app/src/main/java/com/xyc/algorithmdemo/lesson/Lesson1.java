package com.xyc.algorithmdemo.lesson;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author youer
 * @date 2021/1/22
 */
public class Lesson1 {
    public static void main(String[] args) {
        Lesson1 lesson1 = new Lesson1();
        System.out.println(Arrays.toString(lesson1.twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 这里j=i+1,要从i的下一个数开始做处理
                if (nums[j] == newTarget) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

}