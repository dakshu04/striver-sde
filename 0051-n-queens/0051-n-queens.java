class Solution {//TC->O(N!*N),SC->O(N)
    public List<List<String>> solveNQueens(int n) {
        // Step 1: Create an N x N chessboard and initialize all cells to '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');  // Fill each row with '.'

        // Step 2: Result list to store all possible solutions
        List<List<String>> res = new ArrayList<>();

        // Step 3: Arrays to track attacks
        int leftRow[] = new int[n];               // Tracks if a queen is placed in a row
        int upperDiagonal[] = new int[2 * n - 1]; // Tracks upper diagonal conflicts
        int lowerDiagonal[] = new int[2 * n - 1]; // Tracks lower diagonal conflicts

        // Step 4: Call the recursive function to solve the problem
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res; // Return the final list of solutions
    }

    private void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        // Base case: If we have placed queens in all columns, add the board to results
        if (col == board.length) {
            res.add(construct(board)); // Convert board to a list of strings and add to result
            return;
        }

        // Try placing a queen in every row of the current column
        for (int row = 0; row < board.length; row++) {
            // Step 1: Check if placing a queen here is safe (not attacked)
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                // Step 2: Place the queen
                board[row][col] = 'Q';
                leftRow[row] = 1; // Mark row as occupied
                lowerDiagonal[row + col] = 1; // Mark lower diagonal as occupied
                upperDiagonal[board.length - 1 + col - row] = 1; // Mark upper diagonal as occupied

                // Step 3: Recur to place the rest of the queens in the next column
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                // Step 4: Backtrack (Remove queen and unmark the attack positions)
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row)); // Convert row to string and add to result list
        }
        return res;
    }
}
