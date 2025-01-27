public class Board implements CheckerBoard{
private CheckerPiece[][] board = new CheckerPiece[8][8];

public Board(){
    for(int i = 1; i < board[0].length; i+= 2){
        board[7][i] = new CheckerPiece("Red",7,i);
        board[6][i-1] = new CheckerPiece("Red",6,i-1);
        board[5][i] = new CheckerPiece("Red",5,i);

        board[2][i-1] = new CheckerPiece("Black",0,i-1);
        board[1][i] = new CheckerPiece("Black",1,i);
        board[0][i-1] = new CheckerPiece("Black",0,i-1);
    }
}

public void showBoard(){
    for(int r = 0; r < board.length; r++)
        for(int c = 0; c < board[r].length; c++)
            System.out.println(board[r][c]);

}

public void moveRight(CheckerPiece s){
    int row = s.getRow();
    int col = s.getCol();
    if(s.PIECE.equals("Red"))
        row--;    
    else
        row++;
    
     col++;

     if(board[row][col] == null){
         board[s.getRow()][s.getCol()] = null;
         board[row][col] = s;
         s.setIndex(row,col);

     }
     else
        System.out.println("Invalid move");

     
        
        
        
}
public void moveLeft(CheckerPiece s){

}









}