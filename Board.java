public class Board{
private Checker[][] board = new Checker[8][8];

public Board(){
    for(int i = 1; i < board[0].length; i+= 2){
        board[7][i] = new RedChecker("Red");
        board[6][i-1] = new RedChecker();
        board[5][i] = new RedChecker();

        board[0][i-1] = new BlackChecker();
        board[0][i] = new BlackChecker();
        board[0][i-1] = new BlackChecker();
    }
}

public void showBoard(){
    for(int r = 0; r < board.length; r++)
        for(int c = 0; c < board[r].length; c++)
            System.out.println(board[r][c]);

}









}