//create ArrayList called Accounts
//Add ArrayList of accounts to it

import java.util.ArrayList;
public class customer {
	//first and last name of customer
	private String fName,lName;
	//id as an integer is final
	final int id;
	//balance of customer
	//this will have all the accounts
	//this is ArrayList of ArrayList
	//this will allow us to add multiple accounts
	ArrayList<Account> acc = new ArrayList<Account>();
	//Constructor to add new customer
	public customer(String fName,String lName,String type,
			int openBal, int id){
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		try {
			openAccnew(type,openBal,id);
		} catch (invalidAccException e) { //catch if invalid account type
			System.out.println(e.getMessage());
		}
	}
	//open new account by adding type to  Account ArrayList
	public void openAccnew(String type, int openBal,int id) 
			throws invalidAccException {	
		if(type == "c" || type == "C") {
			//create a new arrayList of accounts for new customer
			acc.add(new checking(openBal));
		}
		else if(type == "s" || type == "S") {
			acc.add(new savings(openBal));
		}
		else {
			throw new invalidAccException("Account type "+ type+
					" is invalid");
		}
	}
	//deposit money to account
	public void deposit(int amount,int index) {
		try {
			acc.get(index).deposit(amount);;
		} catch (currencyError e) {
			System.out.println(e.getMessage());
		}	
	}
	//make withdraw
	public void withdraw(int amount,int index) {
		try {
			acc.get(index).withdraw(amount);
		} catch (insufficientFundsException | currencyError e) {
			System.out.println(e.getMessage());
		}
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fName;
	}
	public String getLname() {
		return lName;
	}
	//return account balance
	public int getCusBal(int index) {
		return acc.get(index).getbal();
	}
	
	public String toString(int index) {
		return "Name: " + fName + " " +lName+
				"\nBalance: " + getCusBal(index);
	}
	public String toString() {
		return "Traditional toString error";
	}
}
