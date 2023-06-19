import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player2Player implements ActionListener {

    private boolean x_turn;
    private final int max_size = 9;
    private final String set_X = "X";
    private final String set_O = "O";
    private final DecorateBoard decorateBoard;

    public Player2Player(DecorateBoard decorateBoard){

        this.decorateBoard = decorateBoard;

        for(int i=0;i<max_size;i++){
            this.decorateBoard.buttons[i].addActionListener(this);
        }
        decorateBoard.reset_button.addActionListener(this);

        firstTurn();
    }

    public void firstTurn(){

        // always x has the first turn in this logic
        x_turn = true;
        decorateBoard.show_text.setText("X turn");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // reset the game-board
        if(e.getSource()==decorateBoard.reset_button){
            resetAllButtons();
        }
        else{
            // check all buttons which has been clicked
            for(int i=0;i<max_size;i++){

                if(e.getSource()==decorateBoard.buttons[i]){

                    if(x_turn){
                        playForX(i);
                    }
                    else{
                        playForO(i);
                    }

                    isAnyWinner();
                }
            }
        }
    }

    public void resetAllButtons() {

        for (int i = 0; i < max_size; i++) {
            decorateBoard.buttons[i].setText(null);
            decorateBoard.buttons[i].setBackground(new Color(255, 255, 255));
            decorateBoard.buttons[i].setEnabled(true);
        }
        firstTurn();
    }

    public void playForX(int i){

        if(decorateBoard.buttons[i].getText() != null && !decorateBoard.buttons[i].getText().equals("")){
            return;
        }

        decorateBoard.buttons[i].setForeground(new Color(0, 0, 57));
        decorateBoard.buttons[i].setText(set_X);
        x_turn = false;
        decorateBoard.show_text.setText("O turn");
    }

    public void playForO(int i){

        if(decorateBoard.buttons[i].getText() != null && !decorateBoard.buttons[i].getText().equals("")){
            return;
        }

        decorateBoard.buttons[i].setForeground(new Color(0, 0, 57));
        decorateBoard.buttons[i].setText(set_O);
        x_turn = true;
        decorateBoard.show_text.setText("X turn");
    }

    public void isAnyWinner(){

        Player2PlayerGameLogic flag = new Player2PlayerGameLogic(decorateBoard);

        String winner_symbol = flag.checkForWinner();
        int[] winner_lane = flag.getWinner_lane();

        if(winner_symbol != ""){
            afterWinningAction(winner_symbol, winner_lane);
        }

        isDrawMatch();
    }

    public void isDrawMatch(){

        for(int i=0;i<max_size;i++){
            if(decorateBoard.buttons[i].getText() == null){
                return;
            }
        }

        resetAllButtons();
    }

    public void afterWinningAction(String symbol, int[] winner_lane){

        for (int j : winner_lane) {
            decorateBoard.buttons[j].setBackground(new Color(0, 255, 0));
        }

        decorateBoard.show_text.setText(symbol+" wins");
        muteAllButtons();
    }

    public void muteAllButtons(){
        for (int i=0; i<max_size; i++){
            decorateBoard.buttons[i].setEnabled(false);
        }
    }

}
