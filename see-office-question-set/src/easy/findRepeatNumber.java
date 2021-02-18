package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * eg:
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * limit: 2 <= n <= 100000
 *
 * @author chenjianglin
 * @date 2021/2/18
 * @since 1.0.0
 **/
public class findRepeatNumber {
    //题目分析: nums.length==n   nums[] 取值范围 [0,n-1] 并知道
    // 若是有序无重复数值 则有此关系 nums[i]=i
    // 反之就是重复数组，这时候满足输出条件
    //此题中，若乱序的数组出现重复值，则其经过排序后的数组必有一个位置不满足 num[i]=i的关系
    public static int returnRepeatNumber(int[] nums) {
        int t;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[nums[i]]) {//借鉴萝卜坑位的思想
                return nums[i];
            }
            t = nums[i];
            nums[i] = nums[t];
            nums[t] = t;
        }
        return -1;
    }

    public static int returnRePeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(returnRepeatNumber(nums));
        System.out.println(returnRePeatNumber2(nums));
    }
}
