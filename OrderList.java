/**
 * This class represent the Order item list
 * 
 * @author Lior Maimon 
 * mmn13 , Question 1
 */

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderList {
	//instance variables
	private double priceOfOrder;
	private ArrayList<Order> orderList;
	/**
	 * empty constructor, initialize the priceOfOrder to zero and make an empty order list
	 */
	public OrderList(){
		orderList = new ArrayList<Order>();
		priceOfOrder = 0;
	}
	/**
	 * Add an item to the current order list
	 * @param item - The item to add to the list
	 */
	public void addItem(Order item){
		orderList.add(item);
	}
	/**
	 * Return the current list length and update the price
	 * @return an integer represent the length of the order list
	 */
	public int getListLength(){
		int counter = 0;
		int temp;
		boolean check;
		for(Order item : orderList){
			temp = (int) item.getQuantity().getSelectedItem();
			check = item.getCheckBox().isSelected();
			if(temp != 0 && check){
				priceOfOrder += ((item.getPrice()) * temp);
				counter++;
			}
		}
		return counter;
	}
	/**
	 * methode to reset the order - make all combo box 0 and cancel the mark of all check boxes
	 * @return a double that represent the amount of money the item list cost
	 */
	public void resetQuantity(){
		for(Order item : orderList){
			item.getQuantity().setSelectedIndex(0);
			item.setCheckBox(false);
		}
	}
	/**
	 * Return the current list price
	 * @return a double represent the price of the current order
	 */
	public double getpriceOfOrder(){
		priceOfOrder = 0;
		for(Order item : orderList){
			priceOfOrder += (item.getPrice()) * (int)(item.getQuantity().getSelectedItem());
		}
		return priceOfOrder;
	}
	/**
	 * method that get a panel and print to it the order
	 * @param panel - represent the panrl we want to print to
	 */
	public void printOrder(JPanel panel){
		for(Order item : orderList){
			if((int)item.getQuantity().getSelectedItem() != 0 && item.getCheckBox().isSelected()){
				panel.add(new JLabel(item.getName()));
				panel.add(new JLabel(String.valueOf(item.getPrice())));
				panel.add(new JLabel(item.getQuantity().getSelectedItem().toString()));
				
			}
		}
	}
	/**
	 * method toString
	 */
	public String toString(){
		String output;
		output = String.format("%-10s %-10s %-10s%n" ,"Name", "Price", "Quantity");
		for(Order item : orderList){
			if((int)item.getQuantity().getSelectedItem() != 0){
				output += (item + "\n");
			}
		}
		return output;
	}
	
	
}
