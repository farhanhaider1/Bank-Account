import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.InvalidNameException;

public class Main {
	//name of customer
	String fName;
	String lName;
	//type of account
	String type;
	//Total number of accounts
	int numAcc;
	public static void main(String[] args) {
		//universal Scanner
		Scanner in = new Scanner(System.in);
		/* ArrayList to add new customers
		 * NOTE:
		 * 		EVERY CUSTOMER OBJECT HAS AN ITS OWN ARRAY LIST 
		 * 		THIS WILL ALLOW MULTIPLE ACCOUNTS FOR CUSTOMERS
		 */
		ArrayList<customer> cus = new ArrayList<customer>();
		
		//option to choose for case statements
		char option;
		//menu
		System.out.println(printMenu());
		option = in.next().charAt(0);
		boolean exit = false;
	    //Switch in a while loop
		while(!exit) {
			//case statements on what to do
			switch(option){
				case 'A':
				case 'a':
					System.out.println("Enter First Name: ");
					
					break;
				//quit
				case 'q':
				case 'Q':
					System.out.print("BYE!");
					exit = true;
					break;
				
			}
		}
		
		
		cus.add(new customer("far","zun","C",500,1001));
		cus.add(new customer("new", "lol","s",1100,1002));
		//add account to existing cus
		cus.get(0).acc.add(new checking(200));
		cus.get(0).deposit(600,0);
		cus.get(0).withdraw(600,0);
		cus.get(0).getId();
		System.out.println("calling cus bal  "+cus.get(0).getCusBal(0));
		System.out.println(cus.get(1).getFname());
		System.out.println(cus.get(0).toString(0));
		System.out.println(cus.get(0).getCusBal(1));
		//System.out.println(cus.get(0).getId());
		//close Scanner
		in.close();
	}
	public void askInfo(Scanner in) 
			throws InvalidNameException{
		//ask for names
		//name must be more than 1 letter
		System.out.print("Enter First Name: ");
		fName = in.next();
		if(fName.length() < 2) {
			throw new InvalidNameException("First name initial error") ;
		}
		System.out.print("Enter Last Name: ");
		lName = in.next();
		if(lName.length() < 2) {
			throw new InvalidNameException("Last name initial error") ;
		}
		
		//ask for account type
		System.out.print("Enter Account Type: ");
		type = in.next();
		
	}
	public void addNewAcc() {
		numAcc++;
	}
	//print menu
	public static String printMenu() {
		return "\t\tMenu\n"+
				"A: Add new Customer and Account\nE: Add new Account "+
				"Only\nD: Deposit\nW: Withdraw\nB: Check Balance";
	}
}
