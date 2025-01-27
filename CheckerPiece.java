public class CheckerPiece {
    final String PIECE;
    private int row, col;

    public CheckerPiece(String piece, int row, int col) {
        PIECE = piece;
        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
            }

    public void setIndex(int row, int col){
        this.row = row;
        this.col = col;
    }

    public String toString(){
        if(PIECE.equals("Red"))
            return "R";
        else if(PIECE.equals("Black"))
            return "B";
        else
            return " ";
    }
        
 



    }



    

