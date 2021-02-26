package easy;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * eg:
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 *
 * @author chenjianglin
 * @date 2021/2/26
 * @since 1.0.0
 **/
public class RevertArray {
    //旋转数组的问题转化
    //两个有序数组分界点的寻找  二分查找
    //自己的解法，失败
//    public static void main(String[] args) {
//        int[] array1 = new int[]{3,4,5,1,2};
//        int[] array2 = new int[]{2,2,2,0,1};
//        Arrays.sort(array1);
//        System.out.println(array1[0]);
//        Arrays.sort(array2);
//        System.out.println(array2[0]);
//
//        printSort(3,array1);
//    }
//
//    public static void printSort(int value, int[] array) {
//        int length = array.length;
//        if (length > value && value != 0) {
//           int[] part1Array = new int[value];
//           int[] part2Array = new int[length-value];
//            for (int i = 0; i < length; i++) {
//                if (part1Array.length > i-1) {
//                    part1Array[i] = array[i];
//                }else {
//                    part2Array[i] = array[i];
//                }
//            }
//            System.out.println(Arrays.toString(part2Array));
//            System.out.println(Arrays.toString(part1Array));
//        }
//    }

    public static void main(String[] args) {
        RevertArray array = new RevertArray();
        int[] arr1 = new int[]{3, 4, 5, 1, 2};
        System.out.println(array.minArray(arr1));
        int[] arr2 = new int[]{2, 2, 2, 0, 1};
        System.out.println(array.minArray(arr2));
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int pivot = left + (right-left)/2;
            if (numbers[pivot] < numbers[right]) {
                right = pivot;
            } else if (numbers[pivot] > numbers[right]) {
                left = pivot+1;
            } else {
                right -=1;
            }

        }
        return numbers[left];
    }
}
