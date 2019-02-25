package medium;

/**
 * @author: godder
 * @date: 2019/2/24
 */

/**
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 *
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 示例 :
 *
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 */
public class BattleshipsInABoard_419 {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int result = 0, row = board.length, col = board[0].length;
        boolean[][] isCounted = new boolean[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                char pos = board[i][j];
                if (pos == '.' || isCounted[i][j]) {
                    continue;
                }
                isCounted[i][j] = true;
                result++;
                if (i + 1 < row && board[i+1][j] == 'X') {
                    int k = i + 1;
                    while (k < row && board[k][j] == 'X') {
                        isCounted[k++][j] = true;
                    }
                }
                if (j + 1 < col && board[i][j+1] == 'X') {
                    int k = j + 1;
                    while (k < col && board[i][k] == 'X') {
                        isCounted[i][k++] = true;
                    }
                }
            }
        }
        return result;
    }
}
