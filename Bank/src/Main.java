import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.InvalidNameException;

public class Main {
	//name of customer
	static String fName;
	static String lName;
	//type of account
	static String type;
	//Total number of accounts
	static int numAcc;
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
					try {
						//get first name
						getFname(in);
						//get last name
						getLastName(in);
					} catch (InvalidNameException e) {
						System.out.println(e.getMessage());
					}
					//ask for menu option again
					System.out.println(printMenu());
					option = in.next().charAt(0);
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
	public static void getFname(Scanner in) 
			throws InvalidNameException{
		boolean fRight = false;
		//while loop to ask for full name again
		//ask for names
		//name must be more than 1 letter
		//allow 3 tries and if fail -> throw error
		int fNameCount = 3; //first name input counter
		//using while loop to 
		while(fRight != true) {
			System.out.print("Enter First Name: ");
			fName = in.next();
			if(fName.length() < 2) {
				fRight = false;
				//reduce counter number
				fNameCount--;
				//print number of tries left
				System.out.println("TRY AGAIN: ("+ fNameCount+" of 3)");
				//if failed 4th time, throw error
				if(fNameCount == 0) {
					throw new InvalidNameException("First name initial error") ;
				}
			}
			else {
				fRight = true;
			}
		} //while loop for first name ends here
		
		//ask for account type
		System.out.print("Enter Account Type: ");
		type = in.next();
		fRight = true;
	}
	public static void getLastName(Scanner in) 
			throws InvalidNameException {
		
		boolean fRight = false;
		//while loop to ask for last name again
		//name must be more than 1 letter
		//allow 3 tries and if fail -> throw error
		int fNameCount = 3; //first name input counter
		//using while loop to 
		while(fRight != true) {
			System.out.print("Enter Last Name: ");
			lName = in.next();
			if(fName.length() < 2) {
				fRight = false;
				//reduce counter number
				fNameCount--;
				//print number of tries left
				System.out.println("TRY AGAIN: ("+ fNameCount+" of 3)");
				//if failed 4th time, throw error
				if(fNameCount == 0) {
					throw new InvalidNameException("Last name initial error") ;
				}
			}
			else {
				fRight = true;
			}
		} //while loop for last name ends here
	}
	public static void addNewAcc() {
		numAcc++;
	}
	//print menu
	public static String printMenu() {
		return "\t\tMenu\n"+
				"A: Add new Customer and Account\nE: Add new Account "+
				"Only\nD: Deposit\nW: Withdraw\nB: Check Balance";
	}
}
