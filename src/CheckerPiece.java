/**
 * CheckerPiece.java
 * This class represents a checker piece.
 * A checker piece can be red or black and can be a queen.
 * A queen is a piece that can move any number of squares in any direction.
 * A piece that is not a queen can only move forward.
 * A piece can only move diagonally.
 * @since 0.1
 */
public class CheckerPiece {
    private boolean isRed;
    private boolean isQueen;

    public CheckerPiece(boolean isRed) {
        this.isRed = isRed;
    }

    public boolean isRed() {
        return isRed;
    }

    public boolean isQueen() {
        return isQueen;
    }

    public void makeQueen() {
        this.isQueen = true;
    }
}