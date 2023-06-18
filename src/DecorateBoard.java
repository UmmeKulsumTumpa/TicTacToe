import javax.swing.*;
import java.awt.*;

public class DecorateBoard {

    JFrame board;
    JPanel display_bar;
    JLabel show_text;
    JButton reset_button;
    JPanel bottom_bar;
    JPanel center_panel;
    JButton[] buttons = new JButton[9];

    public DecorateBoard() {

        board = new JFrame();
        board.setSize(500, 700);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setLayout(new BorderLayout());
        board.setTitle("Tic Tac Toe");
        board.setResizable(false);

        // top display bar
        show_text = new JLabel();
        show_text.setBackground(new Color(0, 0, 57));
        show_text.setForeground(new Color(0, 255, 255));
        show_text.setFont(new Font("Ink Free", Font.BOLD, 40));
        show_text.setHorizontalAlignment(JLabel.CENTER);
        show_text.setVerticalAlignment(JLabel.CENTER);
        //show_text.setText("Tic Tac Toe");

        display_bar = new JPanel();
        display_bar.setLayout(new BorderLayout());
        display_bar.setBackground(new Color(0, 0, 57));
        display_bar.setPreferredSize(new Dimension(100, 100));
        display_bar.add(show_text);

        // bottom display bar
        reset_button = new JButton();
        reset_button.setFocusable(false);
        reset_button.setText("Reset");
        reset_button.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        reset_button.setForeground(new Color(0, 0, 57));
        reset_button.setBackground(new Color(255, 255, 255));

        bottom_bar = new JPanel();
        bottom_bar.setBackground(new Color(0, 0, 57));
        bottom_bar.setPreferredSize(new Dimension(100, 100));
        bottom_bar.setLayout(new BoxLayout(bottom_bar, BoxLayout.X_AXIS));
        bottom_bar.add(Box.createHorizontalGlue());
        bottom_bar.add(reset_button);
        bottom_bar.add(Box.createHorizontalGlue());

        // center panel
        center_panel = new JPanel();
        center_panel.setBackground(new Color(0, 0, 57));
        center_panel.setLayout(new GridLayout(3,3, 10, 10));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].setForeground(new Color(0, 0, 57));
            buttons[i].setBackground(new Color(255, 255, 255));
            buttons[i].setFont(new Font("Carter One", Font.BOLD, 50));
            center_panel.add(buttons[i]);
        }

        // add all components to board
        board.add(display_bar, BorderLayout.NORTH);
        board.add(bottom_bar, BorderLayout.SOUTH);
        board.add(center_panel, BorderLayout.CENTER);
        board.setVisible(true);

    }
}
