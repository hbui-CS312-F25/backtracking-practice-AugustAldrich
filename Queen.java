import java.util.ArrayList;
import java.util.List;

public class Queen {

    public static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static void solveNQueens(int[][] board, int col, List<int[][]> results) {
        int N = board.length;
        if (col == N) {
            int[][] copy = new int[N][N];
            for (int i = 0; i < N; i++)
                copy[i] = board[i].clone();
            results.add(copy);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                solveNQueens(board, col + 1, results);
                board[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        List<int[][]> results = new ArrayList<>();

        solveNQueens(board, 0, results);

        System.out.println("Total solutions for " + N + " queens: " + results.size());
        for (int[][] b : results) {
            for (int[] row : b) {
                for (int cell : row)
                    System.out.print(cell + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
