/**
 * This class represent an Order Item
 * 
 * @author Lior Maimon 
 * mmn13 , Question 1
 */
import java.awt.Checkbox;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Order {
	//instance variables
	private Item item;
	private JComboBox quantity;
	JCheckBox checkBox;

	/**
	 * construct a new Order with given order item his combo box and his check box
	 * @param orderedItem - Item parameter represent an ordered Item
	 * @param itemQuantity - represent the quantity of that item
	 * @param cBox - represent if the item need to be order
	 */
	public Order(Item orderedItem , JComboBox itemQuantity, JCheckBox cBox){
		this.item = orderedItem;
		this.quantity = itemQuantity;
		this.checkBox = cBox;
	}
	/**
	 * set the checkbox of that item
	 * @param val - boolean represent how to set the check box
	 */
	public void setCheckBox(boolean val){
		this.checkBox.setSelected(val);;
	}
	/**
	 * Return pointer to the checkBox of that item
	 * @return pointer to the checkBox
	 */
	public JCheckBox getCheckBox(){
		return checkBox;
	}
	/**
	 * set the quantity of the item
	 * @param itemQuantity - JComboBox that contain the quantity ordered of that item
	 */
	public void setQuantity(JComboBox itemQuantity){
		quantity = itemQuantity;
	}
	/**
	 * Return the quantity of the item
	 * @return the quantity of the item as a string
	 */
	public JComboBox getQuantity(){
		return this.quantity;
	}
	/**
	 * Return the name of the item
	 * @return the name of the item as a string
	 */
	public String getName(){
		return item.getName();
	}
	/**
	 * Return the price of the item
	 * @return a double that represent the price of the item
	 */
	public double getPrice(){
		return item.getPrice();
	}
	/**
	 * method toString
	 */
	public String toString(){
		String output = String.format("%n%-10s %-10.2f %-10d%n" ,item.getName(), item.getPrice(), quantity.getSelectedItem()); 
		return output;
	}
	
	
}
