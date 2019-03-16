package medium;

/**
 * @author: godder
 * @date: 2019/2/25
 */

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 *
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 */

public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int M = matrix.length, N = matrix[0].length;
        int[] result = new int[M * N];
        result[0] = matrix[0][0];
        int row = 0, col = 0; // 表示上一次遍历最后一次的下标
        // 用 i 表示当前顺序下的所有元素的下标之和 （把所有matrix看作方阵，然后越界的地方跳过）
        for (int i = 1, num = 1; num < M * N; i++) {
            // 退出条件
            // if (row == M - 1 && col == N - 1) {
            //     break;
            // }
            // i 为 odd时 开始下标为上一次结束 col + 1 (即使越界), 向下遍历
            if (i % 2 == 1) {
                col++;
                // 向下遍历
                while (col >= 0 && row < M) {
                    if (col < N) {
                        result[num++] = matrix[row][col];
                    }
                    col--;
                    row++;
                }
                // 恢复多余的最后一次向下遍历操作(不然会有越界问题)
                col++;
                row--;
            }
            // i 为 even时 开始下标为上一次结束 row + 1 (即使越界), 向上遍历
            else {
                row++;
                // 向上遍历
                while (row >= 0 && col < N) {
                    if (row < M) {
                        result[num++] = matrix[row][col];
                    }
                    row--;
                    col++;
                }
                // 恢复多余的最后一次向下遍历操作(不然会有越界问题)
                row++;
                col--;
            }
        }
        return result;
    }
}
