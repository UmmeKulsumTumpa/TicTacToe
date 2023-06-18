import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player2Player implements ActionListener {

    private boolean x_turn;
    private final int max_size = 9;
    private final String set_X = "X";
    private final String set_O = "O";
    DecorateBoard decorateBoard;

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
            // will set this later with a dialogue box
//            if(isBoardEmpty()){
//
//            }

            // check all buttons which has been clicked
            for(int i=0;i<max_size;i++){

                if(e.getSource()==decorateBoard.buttons[i]){

                    if(x_turn){
                        playForX(i);
                    }
                    else{
                        playForO(i);
                    }
                }
            }
        }
    }

    public void resetAllButtons() {

        for (int i = 0; i < max_size; i++) {
            decorateBoard.buttons[i].setText(null);
        }
        firstTurn();
    }

    public boolean isBoardEmpty(){

        for(int i=0;i<max_size;i++){
            if(decorateBoard.buttons[i].getText().equals("")){
                return false;
            }
        }

        return true;
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

    public void checkForWinner(){


    }

}
