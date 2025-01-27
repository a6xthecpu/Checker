public class Board implements CheckerBoard{
    private CheckerPiece[][] board = new CheckerPiece[8][8];
    
    public Board(){
        for(int i = 1; i < board[0].length; i+= 2){
            board[7][i] = new CheckerPiece("Red",7,i);
            board[6][i-1] = new CheckerPiece("Red",6,i-1);
            board[5][i] = new CheckerPiece("Red",5,i);
            
            board[2][i-1] = new CheckerPiece("Black",2,i-1);
            board[1][i] = new CheckerPiece("Black",1,i);
            board[0][i-1] = new CheckerPiece("Black",0,i-1);
        }
    }
    
    public void showBoard(){
        System.out.print("\t1\t2\t3\t4\t5\t6\t7\t8\n");
        
        for(int r = 0; r < board.length; r++){
            System.out.print((r+1) + "\t");
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c] != null)
                System.out.print(board[r][c] + "\t");
                else
                System.out.print(". " + "\t");
            }
            System.out.println();
        }
    }
    
    public void moveRight(CheckerPiece s){
        if(s == null){
            System.out.println("Invalid move (Null)");
            return;
        }
        
        int row = s.getRow();
        int col = s.getCol();
        if(s.PIECE.equals("Red"))
        row--;    
        else if(s.PIECE.equals("Black"))
        row++;
        else
        System.out.println("Invalid move (No color)"); 
        
        col++;
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length){
            System.out.println("Invalid move (Out of bounds)");
            return;
        }
        if(board[row][col] == null){
            board[s.getRow()][s.getCol()] = null;
            board[row][col] = s;
            s.setIndex(row,col);
            
        }
        else
        System.out.println("Invalid move");
        
        
        
        
        
    }
    public void moveLeft(CheckerPiece s){
        if(s == null){
            System.out.println("Invalid move (Null)");
            return;
        }
        
        int row = s.getRow();
        int col = s.getCol();
        if(s.PIECE.equals("Red"))
        row--;    
        else if(s.PIECE.equals("Black"))
        row++;
        else
        System.out.println("Invalid move (No color)"); 
        
        col--;
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length){
            System.out.println("Invalid move (Out of bounds)");
            return;
        }
        if(board[row][col] == null){
            board[s.getRow()][s.getCol()] = null;
            board[row][col] = s;
            s.setIndex(row,col);
            
        }
        else
        System.out.println("Invalid move");
    }
    
    public CheckerPiece getboard(int row, int col){
        return board[row][col];
        
    }
    
    
    
    
    
    
    
}