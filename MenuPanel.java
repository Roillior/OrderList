/**
 * This class represent the Panel
 * extends JPanel
 * 
 * @author Lior Maimon 
 * mmn13 , Question 1
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	//instance variables
	private final String FIRST_COURSE = "First Course";
	private final String SECOND_COURSE = "Second Course";
	private final String DESSERT = "Dessert";
	private final String DRINK = "Drink";
	private Menu menu;
	private OrderList orderList;
	private static Formatter output;
	JPanel menuJPanel;
	JPanel buttonsJPanel;
	JPanel firstCourseJPanel;
	JPanel secondCourseJPanel;
	JPanel dessertJPanel;
	JPanel drinkJPanel;
	JButton orderButton;
	JButton cancelButton;
	JLabel firstCourseLbl;
	JLabel secondCourseLbl;
	JLabel dessertLbl;
	JLabel drinkLbl;
	/**
	 * construct a new Panel represent the menu
	 */
	public MenuPanel(){
		orderList = new OrderList();
		setLayout(new BorderLayout());
		buttonsJPanel = new JPanel();
		menuJPanel = new JPanel(new GridLayout(2,2)); //panel spot for each type
		add(menuJPanel , BorderLayout.CENTER);
		//each item type will be in his own panel (show max 10 item in each type)
		firstCourseJPanel = new JPanel(new GridLayout(10 , 1));
		dessertJPanel = new JPanel(new GridLayout(10 , 1));
		secondCourseJPanel = new JPanel(new GridLayout(10 , 1));
		drinkJPanel = new JPanel(new GridLayout(10 , 1));
		//add the courses panels to the menu panel
		menuJPanel.add(firstCourseJPanel);
		menuJPanel.add(dessertJPanel);
		menuJPanel.add(secondCourseJPanel);
		menuJPanel.add(drinkJPanel);
		//set the labels
		firstCourseLbl = new JLabel("First Course");
		dessertLbl = new JLabel("Dessert");
		secondCourseLbl = new JLabel("Second Course");
		drinkLbl = new JLabel("Drinks");
		//add the labels
		firstCourseJPanel.add(firstCourseLbl);
		dessertJPanel.add(dessertLbl);
		secondCourseJPanel.add(secondCourseLbl);
		drinkJPanel.add(drinkLbl);
		menu = new Menu(); 
		try{
			menu.readFile();
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "The File menu.txt is not found", "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
		}
		printMenu(firstCourseJPanel, dessertJPanel, secondCourseJPanel, drinkJPanel);
		orderButton = new JButton("Order");
		cancelButton = new JButton("Cancel");
		orderButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
		buttonsJPanel.add(orderButton);
		buttonsJPanel.add(cancelButton);
		add(buttonsJPanel , BorderLayout.SOUTH);
	}
	//private method to print the menu get 4 panels - 1 for each type
	private void printMenu(JPanel first, JPanel dessert, JPanel second, JPanel drink) {
		
		Integer[] quantity = {0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
		ArrayList<Item> itemList = menu.getMenu();
		
		for(Item item : itemList){
			JPanel temp = new JPanel();
			JComboBox itemQuantity = new JComboBox(quantity);
			JCheckBox checkBox = new JCheckBox();
			orderList.addItem(new Order(item , itemQuantity , checkBox));
			temp.add(new JLabel(item.getName()));
			temp.add(new JLabel(String.valueOf(item.getPrice()) + "  "));
			temp.add(itemQuantity);
			temp.add(checkBox);
			//put the item in the right panel
			if(item.getType().equals(FIRST_COURSE)){
				first.add(temp);
			}
			else if(item.getType().equals(DESSERT)){
				dessert.add(temp);
			}
			else if(item.getType().equals(SECOND_COURSE)){
				second.add(temp);
			}
			else if(item.getType().equals(DRINK)){
				drink.add(temp);
			}
			else{ //error occur
				System.out.println("Item Type can be only one of the 4 option \n"+FIRST_COURSE+"\n"
						+ DESSERT+"\n"+SECOND_COURSE+"\n"+DRINK);
				System.exit(1);
			}
		}
	}
	/**
	 * method paintComponent
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	//private method ButtomListener - bottoms performers implements ActionListener
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			Object src = event.getSource();
			
			if(src == cancelButton){ //if click cancel exit the application
				System.exit(0);
			}
			else if(src == orderButton){
				int num = orderList.getListLength();
				if(num == 0){
					JOptionPane.showMessageDialog(null, "You Didnt Order Anything");
				}
				else{
					Object[] choice = {"Order Now", "Change", "Cancel"};
					JPanel orderJPanel = new JPanel(new GridLayout(num + 2 , 2));
					orderJPanel.add(new JLabel("Name          "));
					orderJPanel.add(new JLabel("Price     "));
					orderJPanel.add(new JLabel("Quantity     "));
					orderList.printOrder(orderJPanel);
					orderJPanel.add(new JLabel("The Bill is:"));
					orderJPanel.add(new JLabel(String.valueOf(orderList.getpriceOfOrder())));
					int check = JOptionPane.showOptionDialog(null, orderJPanel, "Your Order Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choice, choice[2]);
					if(check == JOptionPane.OK_OPTION || check == JOptionPane.CANCEL_OPTION){
						if(check == JOptionPane.OK_OPTION){
							String fileName = JOptionPane.showInputDialog("Please enter your name and your id number, (i.e AviRon123456789)");
							if(fileName != null){
								try{
									output = new Formatter(fileName + ".txt");
								}
								catch(FileNotFoundException e){
									System.err.println("Error opening file. Terminating.");
									System.exit(1);
								}
								output.format("%s%n%s%s", orderList, "The Bill Is: ", String.valueOf(orderList.getpriceOfOrder()));
								if(output != null){
									output.close();
								}
							}
						}
						orderList.resetQuantity();
					}
				}
			}
		}
	}
}
