/**
 * This class represent The Menu
 * 
 * @author Lior Maimon 
 * mmn13 , Question 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu{
	//instance variables
	private ArrayList<Item> itemList;
	/**
	 * empty constructor, make an empty item list
	 */
	public Menu(){
		this.itemList = new ArrayList<Item>();
	}
	/**
	 * Add an item to the current list
	 * @param item - The item to add to the list
	 */
	public void addItem(Item item){
		this.itemList.add(item);
	}
	/**
	 * method that read the file that represent the menu
	 * @throws FileNotFoundException
	 */
	public void readFile() throws FileNotFoundException{
		String itemName;
		String itemType;
		double itemPrice;
		Scanner input;
		try{
			input = new Scanner(new File("menu.txt"));
		}
		catch(FileNotFoundException e){
			throw e;
		}
		while(input.hasNextLine()){
			itemName = input.nextLine();
			itemType = input.nextLine();
			itemPrice = Double.parseDouble(input.nextLine());
			
			addItem(new Item(itemName, itemType, itemPrice));	
		}
		input.close();
	}
	/**
	 * return a pointer to the menu
	 * @return pointer to the menu
	 */
	public ArrayList<Item> getMenu(){ 
		return this.itemList;
	}
	/**
	 * method toString
	 */
	@Override
	public String toString(){
		String output = "";
		for(Item item : itemList){
			output += item;
		}
		return output;
	}
	
}
