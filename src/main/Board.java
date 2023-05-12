package main;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Board extends JFrame {

	
    private JLabel turn;
    private JTextField movefield;
    private String turnS;
    private String matestatus;
    
    public int[][] getMoves(char piece, int dx, int dy){
    	int[][] possible;
    	switch(piece) {
    	case 'N':
    		possible = new int[][] {
    		           {dx-1,dy-2},
    		           {dx+1,dy-2},
    		           {dx-2,dy-1},
    		           {dx+2,dy-1},
    		           {dx-2,dy+1},
    		           {dx+2,dy+1},
    		           {dx-1,dy+2},
    		           {dx+1,dy+2}
    		           
    		};
    		break;
    	case 'R':
    		possible = new int[][] {
    			{dx-7,dy},
    			{dx-6,dy},
    			{dx-5,dy},
    			{dx-4,dy},
    			{dx-3,dy},
    			{dx-2,dy},
    			{dx-1,dy},
    			{dx+1,dy},
    			{dx+2,dy},
    			{dx+3,dy},
    			{dx+4,dy},
    			{dx+5,dy},
    			{dx+6,dy},
    			{dx+7,dy},
    			{dx,dy-7},
    			{dx,dy-6},
    			{dx,dy-5},
    			{dx,dy-4},
    			{dx,dy-3},
    			{dx,dy-2},
    			{dx,dy-1},
    			{dx,dy+1},
    			{dx,dy+2},
    			{dx,dy+3},
    			{dx,dy+4},
    			{dx,dy+5},
    			{dx,dy+6},
    			{dx,dy+7}
    			
    		};
    		break;
    	case 'B':
    		possible = new int[][] {
    				{dx-7,dy-7},
        			{dx-6,dy-6},
        			{dx-5,dy-5},
        			{dx-4,dy-4},
        			{dx-3,dy-3},
        			{dx-2,dy-2},
        			{dx-1,dy-1},
        			{dx+1,dy+1},
        			{dx+2,dy+2},
        			{dx+3,dy+3},
        			{dx+4,dy+4},
        			{dx+5,dy+5},
        			{dx+6,dy+6},
        			{dx+7,dy+7},
        			{dx+7,dy-7},
        			{dx+6,dy-6},
        			{dx+5,dy-5},
        			{dx+4,dy-4},
        			{dx+3,dy-3},
        			{dx+2,dy-2},
        			{dx+1,dy-1},
        			{dx-1,dy+1},
        			{dx-2,dy+2},
        			{dx-3,dy+3},
        			{dx-4,dy+4},
        			{dx-5,dy+5},
        			{dx-6,dy+6},
        			{dx-7,dy+7}
    		};
    		break;
    	default:
    		//King move
    		possible = new int[][] {
    			{dx-1,dy-1},
    			{dx-1,dy},
    			{dx-1,dy+1},
    			{dx,dy-1},
    			{dx,dy+1},
    			{dx+1,dy-1},
    			{dx+1,dy},
    			{dx+1,dy+1}
    			
    		};
    		break;
    	case 'Q':
    		possible = new int[][] {
    			{dx-7,dy},
    			{dx-6,dy},
    			{dx-5,dy},
    			{dx-4,dy},
    			{dx-3,dy},
    			{dx-2,dy},
    			{dx-1,dy},
    			{dx+1,dy},
    			{dx+2,dy},
    			{dx+3,dy},
    			{dx+4,dy},
    			{dx+5,dy},
    			{dx+6,dy},
    			{dx+7,dy},
    			{dx,dy-7},
    			{dx,dy-6},
    			{dx,dy-5},
    			{dx,dy-4},
    			{dx,dy-3},
    			{dx,dy-2},
    			{dx,dy-1},
    			{dx,dy+1},
    			{dx,dy+2},
    			{dx,dy+3},
    			{dx,dy+4},
    			{dx,dy+5},
    			{dx,dy+6},
    			{dx,dy+7},
    			{dx-7,dy-7},
    			{dx-6,dy-6},
    			{dx-5,dy-5},
    			{dx-4,dy-4},
    			{dx-3,dy-3},
    			{dx-2,dy-2},
    			{dx-1,dy-1},
    			{dx+1,dy+1},
    			{dx+2,dy+2},
    			{dx+3,dy+3},
    			{dx+4,dy+4},
    			{dx+5,dy+5},
    			{dx+6,dy+6},
    			{dx+7,dy+7},
    			{dx+7,dy-7},
    			{dx+6,dy-6},
    			{dx+5,dy-5},
    			{dx+4,dy-4},
    			{dx+3,dy-3},
    			{dx+2,dy-2},
    			{dx+1,dy-1},
    			{dx-1,dy+1},
    			{dx-2,dy+2},
    			{dx-3,dy+3},
    			{dx-4,dy+4},
    			{dx-5,dy+5},
    			{dx-6,dy+6},
    			{dx-7,dy+7}
    		};
    		
    	}
    	return possible;
    }
    Action action = new AbstractAction()
    {
        public void actionPerformed(String txt) {
        	int dx = -1, dy = -1, givenx = -1, giveny = -1;
        	char piece;
        	char mvx = (char)-1;
        	int mvy = -1;
        	char file;
        	
        	int[][] possible;
        	
        	System.out.println(txt);
        	if(txt.charAt(txt.length()-1)=='#') {
        		matestatus = ", CHECKMATE";
        		actionPerformed(txt.substring(0, txt.length()-1));
        		matestatus = ", CHECKMATE";
        		display();
        		return;
        	}
        	else if(txt.charAt(txt.length()-1)=='+') {
        		matestatus = ", Check";
        		actionPerformed(txt.substring(0, txt.length()-1));

        		matestatus = ", Check";
        		display();
        		return;
        	}
        	else {
        		matestatus = "";
        	}
        	
            if(txt.length() == 2) {
            	//pawnmove
            	int dest = Integer.parseInt(txt.substring(1,2));
            	file = txt.charAt(0);
            	int src = dest + 1;
            	if(turnS.equals("White")) {
            		src = dest-1;
            	}
            	if(labels[(8-src) * 8 + (file-97)].getName().equals("Empty")) {
            		if(turnS.equals("White")) {
            			src = dest-2;
            		}
            		else {
            			src = dest+2;
            		}
            	}
            	if(!labels[(8-src) * 8 + (file-97)].getName().equals("Black Pawn")
            			&& !labels[(8-src) * 8 + (file-97)].getName().equals("White Pawn")) {return;}
            	swap(file, src, file, dest);
            	return;
            }
            else if(txt.indexOf("=") != -1 && txt.indexOf("x") == -1) {
            	//promotion
            	file = txt.charAt(0);
            	//piece = txt.charAt(0);
            	dx = file-97;
            	
            	if(turnS.equals("White")) {
            		if(labels[8+dx].getName().equals("White Pawn") 
            				&& labels[dx].getName().equals("Empty")) {
            			switch(txt.charAt(txt.length()-1)) {
            			case 'Q':
            				labels[dx] = new ChessLabel("\u2655");
            				break;
            			case 'N':
            				labels[dx] = new ChessLabel("\u2658");
            				break;
            			case 'R':
            				labels[dx] = new ChessLabel("\u2656");
            				break;
            			case 'B':
            				labels[dx] = new ChessLabel("\u2657");
            				break;
            			default:
            				return;
            			}

                    	labels[8+dx] = new ChessLabel("");
            		}
            		else {return;}
            	}
            	else if(turnS.equals("Black")) {
            		if(labels[48+dx].getName().equals("Black Pawn") 
            				&& labels[56+dx].getName().equals("Empty")) {
            			switch(txt.charAt(txt.length()-1)) {
            			case 'Q':
            				labels[56+dx] = new ChessLabel("\u265B");
            				break;
            			case 'N':
            				labels[56+dx] = new ChessLabel("\u265E");
            				break;
            			case 'R':
            				labels[56+dx] = new ChessLabel("\u265C");
            				break;
            			case 'B':
            				labels[56+dx] = new ChessLabel("\u265D");
            				break;
            			default:
            				return;
            			}

                    	labels[48+dx] = new ChessLabel("");
            		}
            		else {return;}
            	}
            	else {return;}
            	dispose();
            	display();
            	if(turnS.equals("White")) {
                	turnS = "Black";
                }
                else {
                	turnS = "White";
                }
            	return;
            	
            }
            else if(txt.indexOf("=") != -1 && txt.indexOf("x") != -1) {
            	//promotion
            	char dfile = txt.charAt(2);
            	char sfile = txt.charAt(0);
            	
            	//piece = txt.charAt(0);
            	dx = dfile-97;
            	int sx = sfile-97;
            	if(turnS.equals("White")) {
            		if(labels[8+sx].getName().equals("White Pawn") 
            				&& !labels[dx].getName().equals("Empty")) {
            			switch(txt.charAt(txt.length()-1)) {
            			case 'Q':
            				labels[dx] = new ChessLabel("\u2655");
            				break;
            			case 'N':
            				labels[dx] = new ChessLabel("\u2658");
            				break;
            			case 'R':
            				labels[dx] = new ChessLabel("\u2656");
            				break;
            			case 'B':
            				labels[dx] = new ChessLabel("\u2657");
            				break;
            			default:
            				return;
            			}
            			labels[8+sx] = new ChessLabel(" ");
            		}
            		else {return;}
            	}
            	else if(turnS.equals("Black")) {
            		if(labels[48+sx].getName().equals("Black Pawn") 
            				&& !labels[56+dx].getName().equals("Empty")) {
            			switch(txt.charAt(txt.length()-1)) {
            			case 'Q':
            				labels[dx] = new ChessLabel("\u265B");
            				break;
            			case 'N':
            				labels[dx] = new ChessLabel("\u265E");
            				break;
            			case 'R':
            				labels[dx] = new ChessLabel("\u265C");
            				break;
            			case 'B':
            				labels[dx] = new ChessLabel("\u265D");
            				break;
            			default:
            				return;
            			}
            			labels[48+sx] = new ChessLabel(" ");
            		}
            		else {
            			return;
            		}
            	}
            	else {return;}
            	dispose();
            	display();
            	if(turnS.equals("White")) {
                	turnS = "Black";
                }
                else {
                	turnS = "White";
                }
            	return;
            	
            }
            else if(txt.equals("O-O")) {
            	System.out.println("Castling!");
            	if(turnS.equals("Black")) {
            		if(labels[4].getName().equals("Black King") && labels[7].getName().equals("Black Rook")) {
            			labels[6] = labels[4];
            			labels[4] = new ChessLabel(" ");
            			labels[5] = labels[7];
            			labels[7] = new ChessLabel(" ");
            		}
            		else {return;}
            	}
            	else if(turnS.equals("White")) {
            		System.out.println(labels[60].getName().equals("White King"));
            		System.out.println(labels[63].getName().equals("White Rook"));
            		
            		if(labels[60].getName().equals("White King") && labels[63].getName().equals("White Rook")) {
            			labels[62] = labels[60];
            			labels[60] = new ChessLabel(" ");
            			labels[61] = labels[63];
            			labels[63] = new ChessLabel(" ");            			
            		}
            		else {return;}
            	}
            	dispose();
            	display();
            	if(turnS.equals("White")) {
                	turnS = "Black";
                }
                else {
                	turnS = "White";
                }
            	return;
            }
            else if(txt.equals("O-O-O")) {
            	System.out.println("Long Castling!");
            	if(turnS.equals("Black")) {
            		if(labels[4].getName().equals("Black King") && labels[0].getName().equals("Black Rook")) {
            			labels[2] = labels[4];
            			labels[4] = new ChessLabel(" ");
            			labels[3] = labels[0];
            			labels[0] = new ChessLabel(" ");
            		}
            		else {return;}
            	}
            	else if(turnS.equals("White")) {
            		System.out.println(labels[60].getName().equals("White King"));
            		System.out.println(labels[63].getName().equals("White Rook"));
            		
            		if(labels[60].getName().equals("White King") && labels[56].getName().equals("White Rook")) {
            			labels[58] = labels[60];
            			labels[60] = new ChessLabel(" ");
            			labels[59] = labels[56];
            			labels[56] = new ChessLabel(" ");            			
            		}
            		else {return;}
            	}
            	dispose();
            	display();
            	if(turnS.equals("White")) {
                	turnS = "Black";
                }
                else {
                	turnS = "White";
                }
            	return;
            }
            
            else if(txt.length() == 3 && txt.indexOf('x')==-1) {
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	piece = txt.charAt(0);
            	dx = file-97;
            	System.out.println(dy*8+dx);
            	possible = getMoves(piece, dx, dy);
            }
            else if(txt.length() == 4 && txt.indexOf('x')==-1) {
            	givenx = txt.charAt(1)-97;
            	txt = txt.substring(0,1) + txt.substring(2);
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	piece = txt.charAt(0);
            	dx = file-97;
            	System.out.println(dy*8+dx);
            	possible = getMoves(piece, dx, dy);
            }
            else if(txt.length() == 5 && txt.indexOf('x')==-1) {
            	givenx = txt.charAt(1)-97;
            	giveny = 8-Integer.parseInt(txt.substring(2,3));
            	txt = txt.substring(0,1) + txt.substring(3);
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	piece = txt.charAt(0);
            	dx = file-97;
            	System.out.println(dy*8+dx);
            	possible = getMoves(piece, dx, dy);
            }
            
            
            
            else if(txt.length() == 4 && txt.indexOf('x')!=-1) {
            	txt = txt.substring(0,1)+ txt.substring(2);
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	dx = file-97;
            	if((int)txt.charAt(0) >= 97) {
            		piece = 'P';
            		if(turnS.equals("White")) {
                    	possible = new int[][] {
                    		{dx-1,dy+1},
                    		{dx+1,dy+1}
                    	};
            		}
            		else {
            			possible = new int[][] {
                    		{dx-1,dy-1},
                    		{dx+1,dy-1}
                    	};
            		}
            	}
            	else {
            		piece = txt.charAt(0);
                	possible = getMoves(piece, dx, dy);
            	}
            	System.out.println(dy*8+dx);
            }
            else if(txt.length() == 5 && txt.indexOf('x')!=-1) {
            	givenx = txt.charAt(1)-97;
            	txt = txt.substring(0,1)+ txt.substring(3);
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	dx = file-97;
            	if((int)txt.charAt(0) >= 97) {
            		piece = 'P';
            		if(turnS.equals("White")) {
                    	possible = new int[][] {
                    		{dx-1,dy+1},
                    		{dx+1,dy+1}
                    	};
            		}
            		else {
            			possible = new int[][] {
                    		{dx-1,dy-1},
                    		{dx+1,dy-1}
                    	};
            		}
            	}
            	else {
            		piece = txt.charAt(0);
                	possible = getMoves(piece, dx, dy);
            	}
            	System.out.println(dy*8+dx);
            }
            else if(txt.length() == 6 && txt.indexOf('x')!=-1) {
            	givenx = txt.charAt(1)-97;
            	giveny = 8-Integer.parseInt(txt.substring(2,3));
            	txt = txt.substring(0,1) + txt.substring(4);
            	dy = 8-Integer.parseInt(txt.substring(2,3));
            	file = txt.charAt(1);
            	dx = file-97;
            	if((int)txt.charAt(0) >= 97) {
            		piece = 'P';
            		if(turnS.equals("White")) {
                    	possible = new int[][] {
                    		{dx-1,dy+1},
                    		{dx+1,dy+1}
                    	};
            		}
            		else {
            			possible = new int[][] {
                    		{dx-1,dy-1},
                    		{dx+1,dy-1}
                    	};
            		}
            	}
            	else {
            		piece = txt.charAt(0);
                	possible = getMoves(piece, dx, dy);
            	}
            	System.out.println(dy*8+dx);
            }
            
            else {
            	possible = new int[0][0];
            	piece = ' ';
            	file = ' ';
            	swap(txt.charAt(1), Integer.parseInt(txt.substring(2,3)), txt.charAt(3), Integer.parseInt(txt.substring(4,5)));
            }
  
        	for(int[] move: possible) {
        		int x = move[0];
        		int y = move[1];
        		System.out.println("X"+x);
        		System.out.println("Y"+y);
        		if(!(x >= 0 && x < 8)) {continue;}
        		if(!(y >= 0 && y < 8)) {continue;}
        		
        		System.out.println(8*y+x);
        		System.out.println(labels[8*y+x].getShortName());
        		System.out.println(piece);
        		if(giveny!= -1) {
        			if(labels[8*y+x].getShortName()==piece && labels[8*y+x].getColor().equals(turnS) && x == givenx && y == giveny) {
	        			mvx = (char)(x+97);
	        			mvy = 8-y;
	        			break;
	        		}
        		}
        		else if(givenx!= -1) {
        			if(labels[8*y+x].getShortName()==piece && labels[8*y+x].getColor().equals(turnS) && x == givenx) {
	        			mvx = (char)(x+97);
	        			mvy = 8-y;
	        			break;
	        		}
        		}
        		else {
	        		if(labels[8*y+x].getShortName()==piece && labels[8*y+x].getColor().equals(turnS)) {
	        			mvx = (char)(x+97);
	        			mvy = 8-y;
	        			break;
	        		}
        		}
        	}
        	if(mvy == -1) {return;}
        	swap(mvx,mvy, file, 8-dy);
        	
            
        }
        public void actionPerformed(ActionEvent e)
        {
            String txt = movefield.getText();
            actionPerformed(txt);
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
    	turn.setFont(new Font("Serif", Font.PLAIN, 30));
    	turn.setSize(100, 100);
    	movefield = new JTextField();
    	movefield.addActionListener(action);
    	matestatus = "";
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
    	turn.setText("TURN: "+turnS+matestatus);
        this.add(turn, BorderLayout.NORTH);
        this.add(movefield, BorderLayout.SOUTH);
        setVisible(true);
     } // display()

} // class Board