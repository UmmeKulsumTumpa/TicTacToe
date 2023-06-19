public class Player2PlayerGameLogic {

    private final DecorateBoard current_board;
    private final int max_size = 9;
    private final int[] winner_lane = new int[3];

    public Player2PlayerGameLogic(DecorateBoard current_board){

        this.current_board = current_board;
    }

    public String checkForWinner(){
        String symbol_x = "X";
        String symbol_o = "O";

        if(checkColumns(symbol_x) || checkRows(symbol_x) || checkDiagonal(symbol_x)){
            return symbol_x;
        }
        else if (checkColumns(symbol_o) || checkRows(symbol_o) || checkDiagonal(symbol_o)) {
            return symbol_o;
        }

        return "";
    }

    public boolean checkColumns(String symbol){

        for(int i=0;i<max_size/3;i++){
            if( current_board.buttons[i].getText() == current_board.buttons[i+3].getText() &&
                current_board.buttons[i].getText() == current_board.buttons[i+6].getText() &&
                current_board.buttons[i].getText() == symbol){
                winner_lane[0] = i; winner_lane[1] = i+3; winner_lane[2] = i+6;
                return true;
            }
        }

        return false;
    }

    public boolean checkRows(String symbol){

        for(int i=0;i<max_size;i+=3){
            if( current_board.buttons[i].getText() == current_board.buttons[i+1].getText() &&
                current_board.buttons[i].getText() == current_board.buttons[i+2].getText() &&
                current_board.buttons[i].getText() == symbol){
                winner_lane[0] = i; winner_lane[1] = i+1; winner_lane[2] = i+2;
                return true;
            }
        }

        return false;
    }

    public boolean checkDiagonal(String symbol){
        if( current_board.buttons[0].getText() == current_board.buttons[4].getText() &&
            current_board.buttons[0].getText() == current_board.buttons[8].getText() &&
            current_board.buttons[0].getText() == symbol){
            winner_lane[0] = 0; winner_lane[1] = 4; winner_lane[2] = 8;
            return true;
        }

        if( current_board.buttons[2].getText() == current_board.buttons[4].getText() &&
            current_board.buttons[2].getText() == current_board.buttons[6].getText() &&
            current_board.buttons[2].getText() == symbol){
            winner_lane[0] = 2; winner_lane[1] = 4; winner_lane[2] = 6;
            return true;
        }

        return false;
    }

    public int[] getWinner_lane() {
        return winner_lane;
    }
}
