package vivocodes;

import java.awt.event.*;
import javax.swing.*;

public class PrimeFactorApp implements ActionListener{ //My Class implementing ActionListener for the button Action event
    private JLabel textLabel, firstLineLabel, secondLineLabel; //My private members
    private JTextField textField; 
    private JButton button;
	private JFrame frame; 

	public PrimeFactorApp() {
		frame = new JFrame("Factoring App");  //My frame 
        textLabel = new JLabel("Enter a number to factorize:"); //My label 
        firstLineLabel = new JLabel(""); //The first line is set to nothing for now
        secondLineLabel = new JLabel(""); //Second line is set to nothing for now
        textField = new JTextField("",300); //Textfield created and size set
        button = new JButton("Find Prime Factorization"); //Button with what is printed on it
        textLabel.setBounds(25, 10, 250, 25); //Positioning my label exactly as in the demo picture of the assignment
        textField.setBounds(25, 40, 340, 25); //Positioning my textfield exactly as in the demo picture of the assignment
        firstLineLabel.setBounds(25, 70, 260, 25); //Positioning my firstline/secondline exactly as in the demo picture of the assignment
        secondLineLabel.setBounds(25, 100, 260, 25);
        button.setBounds(25, 170, 340, 25); //Positioning my button exactly as in the demo picture of the assignment
        frame.add(textLabel); //adding everything to the frame.
        frame.add(textField); 
        frame.add(firstLineLabel);
        frame.add(secondLineLabel);
        frame.add(button);
		button.addActionListener(this); //for actionevent to take place for buttons
		frame.setLayout(null); //layout null as im using setBounds
        frame.setSize(400,250); //size of the original demo
        frame.setVisible(true); //Make it visible
		frame.setResizable(false); //cant resize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on close
	}
	
	  public void actionPerformed(ActionEvent e) {
		           try { if (e.getActionCommand().equals("Find Prime Factorization")){ //When button is pressed
		            	if (textField.getText().length() > 12){   //If the character length is more than 12
		                    firstLineLabel.setSize(firstLineLabel.getPreferredSize());  //This is put in so all the 9's get printed or it would stop at a limit
		                    firstLineLabel.setText("Input number can be no larger than 999999999999"); //Setting firstlabel to input
		                    return; //returning out of it
		                }
		            	long number = Long.parseLong(textField.getText()); //This is to get the number written in the textfield as a long number
		                if (number < 1) { //If the number is less than 1, then print the following.
				        	  firstLineLabel.setText("Input is invalid!");
				        	  secondLineLabel.setText(""); //doing this so, if a user does a calculation, then enters text, it will set the second label to nothing
                              return;
		                }
		            	firstLineLabel.setText("The prime factorization of " + number + " is");  
		                String factors = ""; //Initialising my string
	            	    long divider = (long)Math.sqrt(number); //My max divisor
	            	    for (int i = 2; i <= divider; i++) { //for loop to keep going till the number is found
	            	        while (number % i == 0) {
	            	            number /= i;
	            	            divider = (long)Math.sqrt(number);
	            	            if (number == 1)
	            	                factors = factors + Integer.valueOf(i).toString();
	            	            else
	            	                factors = factors + Integer.valueOf(i).toString() + " x ";  //print the numbers as strings with the addition of x
	            	        }
	            	    }
	            	    if (number != 1)
	            	        factors = factors + Long.valueOf(number).toString();  //Check for the last prime divisor
	                    secondLineLabel.setText(factors); //return the factors in the second line label
		                         }
		           }
		          catch (NumberFormatException ex) {  //any exceptions such as decimals, text so on will be invalid.
		        	  firstLineLabel.setText("Input is invalid!");
		        	  secondLineLabel.setText("");
		          }
		                  }
	
	public static void main(String args[]) { //main method to test and call the app
		PrimeFactorApp theApp = new PrimeFactorApp();
	}
}
