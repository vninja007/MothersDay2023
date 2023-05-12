package main;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Board extends JFrame {


    private JLabel turn;
    private JTextField movefield;
    private String turnS;
    
    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(movefield.getText());
            movefield.setText("");
        }
    };

	private ChessLabel[] labels = new ChessLabel[] {
    
    // black

    new ChessLabel("\u265C"), 
    new ChessLabel("\u265E"), new ChessLabel("\u265D"), new ChessLabel("\u265B"), 
    new ChessLabel("\u265A"), new ChessLabel("\u265D"), new ChessLabel("\u265E"), 
    new ChessLabel("\u265C"),
    new ChessLabel("\u265F"), new ChessLabel("\u265F"), new ChessLabel("\u265F"), 
    new ChessLabel("\u265F"), new ChessLabel("\u265F"), new ChessLabel("\u265F"), 
    new ChessLabel("\u265F"), new ChessLabel("\u265F"), 
    
    
    // empty
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "),
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "), new ChessLabel(" "), 
    new ChessLabel(" "), new ChessLabel(" "),
    // white
    
    new ChessLabel("\u2659"), 
    new ChessLabel("\u2659"), new ChessLabel("\u2659"), new ChessLabel("\u2659"),
    new ChessLabel("\u2659"), new ChessLabel("\u2659"), new ChessLabel("\u2659"), 
    new  ChessLabel("\u2659"), new ChessLabel("\u2656"), new ChessLabel("\u2658"), new ChessLabel("\u2657"), 
    new ChessLabel("\u2655"), new ChessLabel("\u2654"), new ChessLabel("\u2657"), 
    new ChessLabel("\u2658"), new ChessLabel("\u2656")
    };

    public Board() 
    {
    	turnS = "White";
    	turn = new JLabel();
    	turn.setText("TURN: "+turnS);
    	turn.setFont(new Font("Serif", Font.PLAIN, 14));
    	turn.setSize(600, 100);
    	movefield = new JTextField();
    	movefield.addActionListener(action);
    } // Board()

    public String getMove() {
    	return movefield.getText();
    }
    public void display()
    {
        setTitle("Chess board with unicode images");

        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container contentPane = getContentPane();
        JPanel chessBoard = new JPanel();
        GridLayout gridLayout = new GridLayout(8, 8);
        

        chessBoard.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < labels.length; i++) 
        {
            if(i % 8 == 0) row ++; // increment row number
            labels[i].set(i, row);
            chessBoard.add(labels[i]);
        } // i
        
        setSize(600, 700);
        setLocationRelativeTo(null);
        contentPane.add(chessBoard);
    	turn.setText("TURN: "+turnS);
        contentPane.add(turn, BorderLayout.NORTH);
        contentPane.add(movefield, BorderLayout.SOUTH);
        setVisible(true);
     } // display()

} // class Board