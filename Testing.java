public class Testing{
    public static void main(String[] args){
        Board board = new Board();
        board.showBoard();
        board.moveRight(board.getboard(1, 7));

        board.showBoard();

    }
}