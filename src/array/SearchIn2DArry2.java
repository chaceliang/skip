package array;

/**
 * Created by chace on 6/6/14.
 */
public class SearchIn2DArry2 {

    //
    //一个m,n 矩阵 每一行升序排列，每一列同样升序排列。要求找到一个数字是否在矩阵中，注意并不保证每一行头元素高于上一行末元素。
    //        1 2 3
    //        2 3 4
    //        3 4 5

    public static boolean search(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
