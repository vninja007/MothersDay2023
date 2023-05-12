package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class ChessLabel extends JLabel {

    Font font     = new Font("Ariel", Font.PLAIN, 72);
    Color bgLight = new Color(222, 184, 135);
    Color bgDark  = new Color(139, 69, 19);
    String s;
    public ChessLabel(String s)
    {
        super(s);
        this.s = s;
    }

    void set(int idx, int row)
    {
      setFont(font);
          setOpaque(true);
          setBackground((idx+row)%2 == 0 ? bgDark : bgLight);
          setHorizontalAlignment( SwingConstants.CENTER );
    }
    public String getName() {
    	if(s.equals("")) {return "Empty";}
    	if(s.equals("\u265C")) {return "Black Rook";}
    	if(s.equals("\u265E")) {return "Black Knight";}
    	if(s.equals("\u265D")) {return "Black Bishop";}
    	if(s.equals("\u265B")) {return "Black Queen";}
    	if(s.equals("\u265A")) {return "Black King";}
    	if(s.equals("\u265F")) {return "Black Pawn";}
    	
    	if(s.equals("\u2656")) {return "White Rook";}
    	if(s.equals("\u2658")) {return "White Knight";}
    	if(s.equals("\u2657")) {return "White Bishop";}
    	if(s.equals("\u2655")) {return "White Queen";}
    	if(s.equals("\u2654")) {return "White King";}
    	if(s.equals("\u2659")) {return "White Pawn";}
    	
    	
    	return "Empty";
    }
    public char getShortName() {
    	if(s.equals("")) {return ' ';}
    	if(s.equals("\u265C")) {return 'R';}
    	if(s.equals("\u265E")) {return 'N';}
    	if(s.equals("\u265D")) {return 'B';}
    	if(s.equals("\u265B")) {return 'Q';}
    	if(s.equals("\u265A")) {return 'K';}
    	if(s.equals("\u265F")) {return 'P';}
    				
    	
    	
    	if(s.equals("\u2656")) {return 'R';}
    	if(s.equals("\u2658")) {return 'N';}
    	if(s.equals("\u2657")) {return 'B';}
    	if(s.equals("\u2655")) {return 'Q';}
    	if(s.equals("\u2654")) {return 'K';}
    	if(s.equals("\u2659")) {return 'P';}
    	
    	
    	return ' ';
    }
    public String getColor() {
    	if(s.equals("")) {return "Empty";}
    	if(s.equals("\u265C")) {return "Black";}
    	if(s.equals("\u265E")) {return "Black";}
    	if(s.equals("\u265D")) {return "Black";}
    	if(s.equals("\u265B")) {return "Black";}
    	if(s.equals("\u265A")) {return "Black";}
    	if(s.equals("\u265F")) {return "Black";}
    				
    	
    	
    	if(s.equals("\u2656")) {return "White";}
    	if(s.equals("\u2658")) {return "White";}
    	if(s.equals("\u2657")) {return "White";}
    	if(s.equals("\u2655")) {return "White";}
    	if(s.equals("\u2654")) {return "White";}
    	if(s.equals("\u2659")) {return "White";}
    	return "Empty";
    }
    public String toString() {return getName();}

}