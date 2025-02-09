/**
 * CheckerBoard
 * It is a class that represents a checker board.
 * A checker board is an 8x8 grid with alternating black and white squares.
 * The board is set up so that each player has 12 pieces.
 * 
 * @since 0.1
 */
public class CheckerBoard {
    private final CheckerPiece[][] board = new CheckerPiece[8][8];

    /**
     * Constructor for CheckerBoard.
     * Initializes the board with pieces for both players.
     */
    public CheckerBoard() {
        for (int i = 1; i < board[0].length; i += 2) {
            board[7][i] = new CheckerPiece(true);
            board[6][i - 1] = new CheckerPiece(true);
            board[5][i] = new CheckerPiece(true);

            board[2][i - 1] = new CheckerPiece(false);
            board[1][i] = new CheckerPiece(false);
            board[0][i - 1] = new CheckerPiece(false);
        }
    }

    /**
     * Displays the current state of the board.
     */
    public void showBoard() {
        System.out.print("\t1\t2\t3\t4\t5\t6\t7\t8\n");

        for (int r = 0; r < board.length; r++) {
            System.out.print((r + 1) + "\t");
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] != null)
                    System.out.print(board[r][c] + "\t");
                else
                    System.out.print(". " + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Moves a piece to the right.
     * 
     * @param row the row of the piece to move
     * @param col the column of the piece to move
     */
    public void moveRight(int row, int col) {
        CheckerPiece checker = board[row][col];
        if (isNullPiece(row, col))
            return;

        if (eatRight(row, col))
            return;

        int[] newPosition = calculateNewPosition(row, col, checker.isRed(), true);
        int newRow = newPosition[0];
        int newCol = newPosition[1];

        if (isOutOfBounds(newRow, newCol)) {
            return;
        }
        movePiece(row, col, newRow, newCol);
    }

    /**
     * Moves a piece to the left.
     * 
     * @param row the row of the piece to move
     * @param col the column of the piece to move
     */
    public void moveLeft(int row, int col) {
        if (isNullPiece(row, col))
            return;

        if (eatLeft(row, col))
            return;

        CheckerPiece checker = board[row][col];
        int[] newPosition = calculateNewPosition(row, col, checker.isRed(), false);
        int newRow = newPosition[0];
        int newCol = newPosition[1];

        if (isOutOfBounds(newRow, newCol)) {
            return;
        }
        movePiece(row, col, newRow, newCol);
    }

    /**
     * Gets the checker piece at the specified position.
     * 
     * @param row the row of the piece
     * @param col the column of the piece
     * @return the checker piece at the specified position
     */
    public CheckerPiece getChecker(int row, int col) {
        return board[row][col];
    }

    /**
     * Attempts to capture an opponent's piece by moving right.
     * 
     * @param row the row of the piece to move
     * @param col the column of the piece to move
     * @return true if the capture was successful, false otherwise
     */
    private boolean eatRight(int row, int col) {
        int assist = 0;
        if (board[row][col].isRed()) {
            row--;
            assist = -1;
        } else {
            row++;
            assist = 1;
        }

        col++;
        if (canCapture(row, col, row, col, row + assist, col + 1)) {
            board[row + assist][col + 1] = board[row][col];
            board[row][col] = null;
            return true;
        }
        return false;
    }

    /**
     * Attempts to capture an opponent's piece by moving left.
     * 
     * @param row the row of the piece to move
     * @param col the column of the piece to move
     * @return true if the capture was successful, false otherwise
     */
    private boolean eatLeft(int row, int col) {
        if (board[row][col] == null) {
            System.out.println("Invalid move (Null)");
            return false;
        }

        int assist = 0;
        if (board[row][col].isRed()) {
            row--;
            assist = -1;
        } else {
            row++;
            assist = 1;
        }

        col--;
        if (canCapture(row, col, row, col, row + assist, col - 1)) {
            board[row + assist][col - 1] = board[row][col];
            board[row][col] = null;
            return true;
        }
        return false;
    }

    /**
     * Checks if the piece at the specified position is null.
     * 
     * @param row the row of the piece
     * @param col the column of the piece
     * @return true if the piece is null, false otherwise
     */
    private boolean isNullPiece(int row, int col) {
        if (board[row][col] == null) {
            System.out.println("Invalid move (null)");
            return true;
        }
        return false;
    }

    /**
     * Calculates the new position for a piece based on its current position, color, and direction.
     * 
     * @param row the current row of the piece
     * @param col the current column of the piece
     * @param isRed true if the piece is red, false otherwise
     * @param moveRight true if the piece is moving right, false otherwise
     * @return an array containing the new row and column
     */
    private int[] calculateNewPosition(int row, int col, boolean isRed, boolean moveRight) {
        int newRow = row;
        int newCol = moveRight ? col + 1 : col - 1;
        if (isRed)
            newRow--;
        else
            newRow++;
        return new int[] { newRow, newCol };
    }

    /**
     * Checks if the specified position is out of bounds.
     * 
     * @param newRow the row of the new position
     * @param newCol the column of the new position
     * @return true if the position is out of bounds, false otherwise
     */
    private boolean isOutOfBounds(int newRow, int newCol) {
        if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[newRow].length) {
            System.out.println("Invalid move (Out of bounds)");
            return true;
        }
        return false;
    }

    /**
     * Moves a piece to a new position on the board.
     * 
     * @param row the current row of the piece
     * @param col the current column of the piece
     * @param newRow the new row of the piece
     * @param newCol the new column of the piece
     */
    private void movePiece(int row, int col, int newRow, int newCol) {
        CheckerPiece checker = board[row][col];
        if (board[newRow][newCol] == null) {
            board[row][col] = null;
            board[newRow][newCol] = checker;
        } else {
            System.out.println("Invalid move (Piece in way)");
        }
    }

    /**
     * Checks if a capture move is valid.
     * 
     * @param row the current row of the piece
     * @param col the current column of the piece
     * @param assistRow the row of the piece to be captured
     * @param assistCol the column of the piece to be captured
     * @param targetRow the row of the target position
     * @param targetCol the column of the target position
     * @return true if the capture move is valid, false otherwise
     */
    private boolean canCapture(int row, int col, int assistRow, int assistCol, int targetRow, int targetCol) {
        if (row < 1 || row >= board.length - 2 || col < 1 || col >= board[0].length - 2) {
            System.out.println("Invalid move (Out of bounds)");
            return false;
        }
        if (board[assistRow][assistCol] == null) {
            System.out.println("Invalid move (No piece to eat)");
            return false;
        }
        if (board[assistRow][assistCol].isRed() == board[row][col].isRed()) {
            System.out.println("Invalid move (Same color)");
            return false;
        }
        if (board[targetRow][targetCol] != null) {
            System.out.println("Invalid move (Blocked)");
            return false;
        }
        return true;
    }
}