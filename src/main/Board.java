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
            String txt = movefield.getText();
            System.out.println(txt);
            if(txt.length() == 4) {
            	txt = "P" + txt;
            }
            swap(txt.charAt(1), Integer.parseInt(txt.substring(2,3)), txt.charAt(3), Integer.parseInt(txt.substring(4,5)));
            
            
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
    	turn.setSize(100, 100);
    	movefield = new JTextField();
    	movefield.addActionListener(action);
    } // Board()

    
    //true if capture, false if not.
    private boolean swap(char srcx, int srcy, char destx, int desty) {
    	int srcind = (8-srcy) * 8 + (srcx-97);
    	int destind = (8-desty) * 8 + (destx-97);
    	boolean ret = false;
    	if(labels[destind].getName().equals("Empty") ==false)
    		ret = true;
    	labels[destind] = labels[srcind];
    	labels[srcind] = new ChessLabel("");

        this.dispose();
        if(turnS.equals("White")) {
        	turnS = "Black";
        }
        else {
        	turnS = "White";
        }
        
    	display();
    	return ret;
    }
    
    public String getMove() {
    	return movefield.getText();
    }
    
    
    //DO NOT TOUCH UNLESS NECESSARY.
    public void display()
    {
        setTitle("Chess board with unicode images");

        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.revalidate();
        
        this.getContentPane().removeAll(); // now you can use the frame variable
        
        this.repaint();
        this.pack();
        Container contentPane = getContentPane();
        JPanel chessBoard = new JPanel();
        
        GridLayout gridLayout = new GridLayout(9, 9);
      
        

        chessBoard.setLayout(gridLayout);
        
        chessBoard.add(new JLabel(" "));
        chessBoard.add(new JLabel("a"));
        chessBoard.add(new JLabel("b"));
        chessBoard.add(new JLabel("c"));
        chessBoard.add(new JLabel("d"));
        chessBoard.add(new JLabel("e"));
        chessBoard.add(new JLabel("f"));
        chessBoard.add(new JLabel("g"));
        chessBoard.add(new JLabel("h"));
        
        
        
        
        
        

        int row = -1;
        for (int i = 0; i < labels.length; i++) 
        {
            if(i % 8 == 0) {
            	row ++; // increment row number
            	chessBoard.add(new JLabel(""+(8-row)));
            }
            labels[i].set(i, row);
            chessBoard.add(labels[i]);
        } // i
        setSize(700, 800);
        setLocationRelativeTo(null);
        chessBoard.revalidate();
        this.getContentPane().revalidate();
        
        this.add(chessBoard);
    	turn.setText("TURN: "+turnS);
        this.add(turn, BorderLayout.NORTH);
        this.add(movefield, BorderLayout.SOUTH);
        setVisible(true);
     } // display()

} // class Board