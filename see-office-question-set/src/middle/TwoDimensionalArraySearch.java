package middle;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * eg:
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 *
 * limit:
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @author chenjianglin
 * @date 2021/2/19
 * @since 1.0.0
 **/
public class TwoDimensionalArraySearch {
    //1.创建二维数组的方式  二维数组的性质(行是二维数组的长度,列是每一行的长度)

    //2.行方向上 从左到右递增的顺序排序   列方向上从上到下递增的顺序排序

    //3.排序完后对二维数组进行遍历

    //思路:遍历new int[n][1] 时进行外层循环进行比对排序，里层循环也进行比对排序    里层循环基于外层循环进行排序

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        TwoDimensionalArraySearch search = new TwoDimensionalArraySearch();
        System.out.println(search.findNumberIn2DArray(matrix, 5));
        System.out.println(search.findNumberIn2DArray2(matrix, 5));
        System.out.println(search.findNumberIn2DArray3(matrix, 5));
    }

    //暴力破解
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //线性查找()
    //从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。
    // 如果当前元素小于目标值，则移到下边一行。   排序后的二维数组有次特性

    /**
     * 1.当前元素的值大于目标值 得往左找，往下找不行
     * 2.当前元素的值小于目标值 得往下找，往左找不行
     *
     *
     * 时间复杂度  n(O)= N+M
     */

    public boolean findNumberIn2DArray2(int[][] matrix,int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int number = matrix[row][column];
            if (number == target) {
                return true;
            } else if (number > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    //二分查找  时间复杂度n*log^m
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length-1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (target == matrix[i][middle]) {
                    return true;
                }
                if (target > matrix[i][middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }
}
