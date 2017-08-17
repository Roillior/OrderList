/**
 * This class represent the main method
 * 
 * @author Lior Maimon 
 * mmn13 , Question 1
 */

import javax.swing.JFrame;
import javax.swing.UIManager;

public class MenuTest {
	//main method of the program
	public static void main(String[] args){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		
		JFrame frame = new JFrame("Order List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.add(new MenuPanel());
		frame.setVisible(true);
	}
}
