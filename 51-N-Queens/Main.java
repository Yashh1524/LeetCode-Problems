import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: n = 1
        int n1 = 1;
        System.out.println("N = " + n1);
        List<List<String>> result1 = solution.solveNQueens(n1);
        printSolutions(result1);

        // Test case 2: n = 4
        int n2 = 4;
        System.out.println("\nN = " + n2);
        List<List<String>> result2 = solution.solveNQueens(n2);
        printSolutions(result2);

        // Test case 3: n = 5 (Extra test)
        int n3 = 5;
        System.out.println("\nN = " + n3);
        List<List<String>> result3 = solution.solveNQueens(n3);
        printSolutions(result3);
    }

    private static void printSolutions(List<List<String>> solutions) {
        System.out.println("Total solutions: " + solutions.size());
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ans.clear(); // Clear previous results
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        placeQueens_helper(board, 0);
        return ans;
    }

    private void placeQueens_helper(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            ans.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens_helper(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check same column upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
