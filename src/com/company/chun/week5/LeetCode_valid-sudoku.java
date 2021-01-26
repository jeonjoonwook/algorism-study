class Solution {
    static final int BOARD_SIZE = 9;
    public boolean isValidSudoku(char[][] board) {
        // 각 행&열 검사
        for (int i = 0; i < BOARD_SIZE; i++) {
            int[] row = new int[10];
            int[] col = new int[10];
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != '.') {
                    row[board[i][j] - '0']++;
                    if (row[board[i][j] - '0'] > 1)
                        return false;
                }

                if (board[j][i] != '.') {
                    col[board[j][i] - '0']++;
                    if (col[board[j][i] - '0'] > 1)
                        return false;
                }
            }
        }

        int leftY = 0, leftX = 0, rightY = 3, rightX = 3;
        while (rightY <= BOARD_SIZE && rightX <= BOARD_SIZE) {
            int[] cnt = new int[10];
            for (int r = leftY; r < rightY; r++) {
                for (int c = leftX; c < rightX; c++) {
                    if (board[r][c] == '.')
                        continue;
                    cnt[board[r][c] - '0']++;
                    if (cnt[board[r][c] - '0'] > 1) {
                        return false;
                    }
                }
            }

            if (rightX == BOARD_SIZE) {
                leftY += 3;
                leftX = 0;
                rightY += 3;
                rightX = 3;
            } else {
                rightX += 3;
                leftX += 3;
            }
        }
        return true;
    }
}