package FinalShowdown;

/**
 * Author: Vivek Raj
 * Title: TicTacToe
 */

//My libraries needed

import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;


//Im only implementing Actionlistener, not using mouse detection method.
public class TTT implements ActionListener{

	private JFrame frame;
	public static final String EMPTY = "";
	private BoardButton [][] buttons;
	private JButton restart;
	private JLabel score,message,human,ai,aiscore,humanscore;
	private JPanel board,scoreboardpanel,scorexpanel;
	private int clicks,playerscore,computerscore;
	

	public TTT() {
		
		
		frame = new JFrame("Tic-Tac-Toe");
		frame.setLayout(null);                          
		board = new JPanel();
		scorexpanel = new JPanel();
		scoreboardpanel = new JPanel();
        message = new JLabel("You go first");
		score = new JLabel("SCORE BOARD");
		score.setFont(new Font("Arial", Font.BOLD, 13));
		human = new JLabel("Human");
		ai =  new JLabel("Computer");
		humanscore= new JLabel(Integer.toString(playerscore));
		aiscore= new JLabel(Integer.toString(computerscore));
		score.setHorizontalAlignment(JLabel.CENTER);
		board.setBounds(50, 20, 199, 199); 
		scoreboardpanel.setBounds(315, 20, 170, 70); 
		message.setBounds(360, 100, 170, 60); 
		message.setFont(new Font("Arial", Font.BOLD, 13));
        restart = new JButton("Play Another Game");
        restart.addActionListener(this); 
        restart.setBounds(315,170,170,25);
		frame.add(board);
		frame.add(scoreboardpanel);
		frame.add(message);
		scoreboardpanel.add(score);
		scoreboardpanel.setLayout(new GridLayout(2,1));
		scoreboardpanel.add(scorexpanel);
		scorexpanel.setLayout(new GridLayout(2,2));
		human.setHorizontalAlignment(JLabel.CENTER);
		ai.setHorizontalAlignment(JLabel.CENTER);
		humanscore.setHorizontalAlignment(JLabel.CENTER);
		aiscore.setHorizontalAlignment(JLabel.CENTER);
		scoreboardpanel.setForeground(Color.decode("#E6E3E0"));
		scorexpanel.setBackground(Color.WHITE);
		scorexpanel.add(human);
		scorexpanel.add(ai);
		scorexpanel.add(humanscore);
		scorexpanel.add(aiscore);
		//frame.add(restart);
		frame.setSize(550,295);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);

		/**
         *Setting up layout with SetBounds and color coding the needed
         *Bolding the needed components
         *Labeling where required
         */

		buttons = new BoardButton[3][3]; 
        board.setLayout(new GridLayout(3,3,2,2));   //Gridlayout with correct width,length in between.
        board.setBackground(Color.BLACK);
		
		for (int x=0; x<3; x++) {
			for (int y=0; y<3; y++) {
				buttons[x][y] = new BoardButton(x,y);
				buttons[x][y].setBounds(0+(68*y), 0+(68*y),66 , 66);  //Setting up my board in the correct place
				board.add(buttons[x][y]);
			    buttons[x][y].setBackground(Color.WHITE);
	            buttons[x][y].setFont(new Font("Brush Script MT", Font.ITALIC, 40));
	            buttons[x][y].addActionListener(new BoardListener());
	            

			}	
			
		}
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
}
	
	//My checking for win when its a row/colom etc.
	 public void checkWin() {
	        String winner = "";

	        if((buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[0][2].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][0].getText().equals("O") && winner.equals("")) || (buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O") & winner.equals(""))) {
	            frame.add(restart);
	            winner = "computer";
	        	 message.setText("COMPUTER WINS!");
	             setPanelEnabled(board, false);
		         aiscore.setText(Integer.toString(computerscore+=2));

	        }
	        if((buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X") && winner.equals(""))  || (buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals("X") && winner.equals("")) || (buttons[0][2].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][0].getText().equals("X") && winner.equals("")) || (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X") && winner.equals(""))) {
	            winner = "you win";
	            frame.add(restart);
	            setPanelEnabled(board, false);
	        	message.setText("YOU WIN");
	            humanscore.setText(Integer.toString(playerscore+=2));

	        }

	            if((buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O") && winner.equals("")) || (buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[1][2].getText() == "O") && winner.equals("") ||(buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O") && winner.equals("")) || (buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O") && winner.equals("")) || (buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[1][0].getText().equals("O") && winner.equals("")) || (buttons[0][2].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][0].getText().equals("O") && winner.equals(""))){      
	                setPanelEnabled(board, false);
		            frame.add(restart);
	                winner = "Computer wins!";
	            	 message.setText("COMPUTER WINS!");
			         aiscore.setText(Integer.toString(computerscore+=2));

	            }
	            
	            else if((buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X") && winner.equals("")) ||(buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X") && winner.equals("")) || (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X") && winner.equals("")) || (buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[1][0].getText().equals("X") && winner.equals(""))) {
	                setPanelEnabled(board, false);
		            frame.add(restart);
	                winner = "You win";
	            	message.setText("YOU WIN");
		            humanscore.setText(Integer.toString(playerscore+=2));
		            frame.add(restart);
	            }
	           
	       
	        if(clicks > 9 && winner.equals("")) {
                winner = "draw";
	         setPanelEnabled(board, false);
	            frame.add(restart);
	            message.setText("IT'S A DRAW!");
	            humanscore.setText(Integer.toString(playerscore+=1));
		        aiscore.setText(Integer.toString(computerscore+=1));

	        }
	 }
	 
	       
	 
		 public void AiMove() {
        
	         if (!moveHorizontal())
	         {
	             if (!moveVertical())
	             {
	                 if (!moveDiagonal())
	                 {
	                	 
	                     moveRandom();
	                	 }
	                 
	             }
	         }
	     }
	    
		 /**
		  * Only thing that is called during the Ai turn, much easier to calling everything, if anything is unavailable, it will post a random move
		  */
	    private void moveRandom() {
	    	int randx=0,randy=0,i=0;
            Random rand = new Random();
            if(!moveHorizontal()) {
            while(i == 0) {
                randx=rand.nextInt(3);
                randy=rand.nextInt(3);
                if (buttons[randx][randy].getValue()==0) {
                    buttons[randx][randy].setText("O");
                    buttons[randx][randy].setForeground(Color.black);
                    buttons[randx][randy].setValue(1);
                    buttons[randx][randy].setState(true);
                    i++;
                }
                }
            }			
		}


	    private boolean moveDiagonal() {
            int firstDiagonal = checkDiagonal1();
             if (firstDiagonal != -1) {
                 buttons[firstDiagonal][firstDiagonal].setText("O");
            }
            else {
                int secondDiagonal = checkDiagonal2();

                 if (secondDiagonal != -1) {
                     buttons[2 - secondDiagonal][secondDiagonal].setText("O");
                 }
                     else {
                         return false;
                     }
                 }
            

            return true;
        }
	    
		/** 
		 * Makes the actual move for the Ai
		 * Diagonal method
		 */


		private int checkDiagonal2() {
			int playerXCount = 0;
	         int firstEmptyPosition = -1;
	         for (int i = 0; i < buttons.length; i++) {
	             if (buttons[buttons.length - i -1][i].getText().equals("X")) {
	                 playerXCount++;
	             }
	             else if (firstEmptyPosition == -1 && buttons[buttons.length - i -1][i].getText().equals("")) {
	                 firstEmptyPosition = i;
	             }
	         }
            
	         if (playerXCount == 2) {
	             return firstEmptyPosition;
	         }
	         else {
	             return -1;
	         }
		}


		private int checkDiagonal1() {
			int playerXCount = 0;
	         int firstEmptyPosition = -1;
	         for (int i = 0; i < buttons.length; i++) {
	             if (buttons[i][i].getText().equals("X")) {
	                 playerXCount++;
	             }
	             else if (firstEmptyPosition == -1 && buttons[i][i].getText().equals("")) {
	                 firstEmptyPosition = i;
	             }
	         }
             
	         if (playerXCount == 2) {
	             return firstEmptyPosition;
	         }
	         else {
	             return -1;
	         }
		}
		
		/**
		    * Checks if a Diagonal row is about to be completed
		    *    by the player and blocks it if so.
		    *
		    * Returns true if the AI made a move.
		    */


		private boolean moveVertical() {
	    	int firstRowVertical = checkVertical(0);
	    	 if (firstRowVertical != -1) {
	             buttons[0][firstRowVertical].setText("O");
	        }
	        else {
	            int secondRowVertical = checkVertical(1);

	             if (secondRowVertical != -1) {
	                 buttons[1][secondRowVertical].setText("O");
	             }
	             else {
	                 int thirdRowVertical = checkVertical(2);

	                 if (thirdRowVertical != -1) {
	                     buttons[2][thirdRowVertical].setText("O");
	                 }
	                 else {
	                     return false;
	                 }
	             }
	        }

	        return true;
	    }
			
		/**
		    * Checks if a vertical row is about to be completed
		    *    by the player and blocks it if so.
		    *
		    * Returns true if the AI made a move.
		    */


		private int checkVertical(int col) {
			int playerXCount = 0;
	         int firstEmptyPosition = -1;
	         for (int i = 0; i < buttons.length; i++) {
	             if (buttons[col][i].getText().equals("X")) {
	                 playerXCount++;
	             }
	             else if (firstEmptyPosition == -1 && buttons[col][i].getText().equals("")) {
	                 firstEmptyPosition = i;
	             }
	         }

	         if (playerXCount == 2) {
	             return firstEmptyPosition;
	         }
	         else {
	             return -1;
	         }
	         
		}


		/**
	    * Checks if a horizontal row is about to be completed
	    *    by the player and blocks it if so.
	    *
	    * Returns true if the AI made a move.
	    */
	    private boolean moveHorizontal() {
	        int firstRowHorizontal = checkHorizontal(0);

	        if (firstRowHorizontal != -1) {
	             buttons[firstRowHorizontal][0].setText("O");
	        }
	        else {
	            int secondRowHorizontal = checkHorizontal(1);

	             if (secondRowHorizontal != -1) {
	                 buttons[secondRowHorizontal][1].setText("O");
	             }
	             else {
	                 int thirdRowHorizontal = checkHorizontal(2);

	                 if (thirdRowHorizontal != -1) {
	                     buttons[thirdRowHorizontal][2].setText("O");
	                 }
	                 else {
	                     return false;
	                 }
	             }
	        }

	        return true;
	    }

	     /**
	     * Returns the position to place an X if a horizontal row is
	     *    about to be made, otherwise returns -1
	     */
	    public int checkHorizontal(int row) {
	         int playerXCount = 0;
	         int firstEmptyPosition = -1;

	         for (int i = 0; i < buttons.length; i++) {
	             if (buttons[i][row].getText().equals("X")) {
	                 playerXCount++;
	             }
	             else if (firstEmptyPosition == -1 && buttons[i][row].getText().equals("")) {
	                 firstEmptyPosition = i;
	             }
	         }
	         if (playerXCount == 2) {
	             return firstEmptyPosition;
	         }
	         else {
	             return -1; 
	         }
	     }
		 
	 /**
	  * When the button is pressed, the board has to be cleared and then the Ai has to make the move first!
	  */
				
	  public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Play Another Game")){
           board.removeAll();
           frame.remove(restart);
           frame.repaint();
           board.setBounds(50, 20, 199, 199); 
           board.setLayout(new GridLayout(3,3,2,2));
           board.setBackground(Color.black);
           for (int x=0; x<3; x++) {
   			for (int y=0; y<3; y++) {
   				buttons[x][y] = new BoardButton(x,y);
   				buttons[x][y].setBounds(0+(68*y), 0+(68*y),66 , 66);
   				board.add(buttons[x][y]);
   			    buttons[x][y].setBackground(Color.WHITE);
   	            buttons[x][y].setFont(new Font("Brush Script MT", Font.ITALIC, 40));
   	            buttons[x][y].addActionListener(new BoardListener());
           }
           }
          board.revalidate();
          board.repaint();
          clicks=0;
          Aimode();
          checkWin();
          message.setText("");
        }
	  }
	 

	 private void Aimode() {
		 for (int x=0; x<3; x++) {
				for (int y=0; y<3; y++) {
					 if(buttons[x][y].getText()=="") {
						 buttons[1][1].setText("O");		
	}
				}
		 }
	 }
	 
	 /**
	  * To let the Ai move first in the second turn
	  * panel isEnabled as when there is no winner, vice versa there is not.
	  */
	 
	  public void setPanelEnabled(JPanel panel, Boolean isEnabled) {
	        panel.setEnabled(isEnabled);
	        Component[] components = panel.getComponents();

	        for(int i = 0; i < components.length; i++) {
	            if(components[i].getClass().getName() == "javax.swing.JPanel") {
	                setPanelEnabled((JPanel) components[i], isEnabled);
	            }

	            components[i].setEnabled(isEnabled);
	        }
	    } 

	/**
	 * Using boardbutton to implement a boardlistener class then recording the number of clicks and responding with the needed Ai move.
	 */
	  
	 class BoardListener implements ActionListener {
	        public void actionPerformed (ActionEvent e) {
	            BoardButton buttonClicked = (BoardButton)e.getSource();
	            if(buttonClicked.getState()==false) {
	            	message.setText("");
                    clicks++;
                  if(clicks%2==0) {
	                   checkWin();
                       AiMove();
	                	clicks++;
	                }
	                else{
	                	clicks++;
	                	buttonClicked.setText("X");
	                	checkWin();
	                    AiMove();
	                }
	            }  
	           buttonClicked.setState(true);
	        }    
	 }
	 
	    
	public static void main(String args[]) {
		TTT theApp = new TTT();
	}
	
	}
	

