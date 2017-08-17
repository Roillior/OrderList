/**
 * This class represent an Item
 * 
 * @author Lior Maimon  
 * mmn13 , Question 1
 */

public class Item {
	//instance variables
	private String name;
	private String type;
	private double price;
	/**
	 * construct a new Item with a given name type and price
	 * @param itemName - represent the name of the item
	 * @param itemType - represent the type of the item - can be one of the option : First Course , Second Course , Dessert or Drink
	 * @param itemPrice - represent the price of the item
	 *
	 */
	public Item(String itemName, String itemType, double itemPrice ){
		this.name = itemName;
		this.type = itemType;
		this.price = itemPrice;
	}
	/**
	 * Return the name of the item
	 * @return the name of the item as a string
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Return the Type of the item
	 * @return the type of the item as a String
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * Return the price of the item
	 * @return a double that represent the price of the item
	 */
	public double getPrice(){
		return this.price;
	}
	/**
	 * set the name of the item
	 * @param itemName - The item new name 
	 */
	public void setName(String itemName){
		this.name = itemName;
	}
	/**
	 * set the type of the item
	 * @param itemType - The item new type
	 */
	public void setType(String itemType){
		this.type = itemType;
	}
	/**
	 * set the price of the item
	 * @param itemPrice - The item new price
	 */
	public void setPrice(double itemPrice){
		this.price = itemPrice;
	}
	/**
	 * method toString
	 */
	@Override
	public String toString(){
		return (name + "    "+type+"    "+String.valueOf(price)+"    ");
	}
	
}
