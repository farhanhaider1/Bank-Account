
public class checking implements Account {
	//first name of account holder
	private String fName;
	//last name of account holder
	private String lName;
	//balance of account
	private int bal;
	//id of account holder
	private int id;
	//
	
	public checking(String fName,String lName) {
		this.fName = fName;
		this.lName = lName;
		//open account with $0
		bal = 0;
	}
	//constructor 2 if initial account is provided
	public checking(String fName,String lName,
			int bal){
		this.fName = fName;
		this.lName = lName;
		//open account with this bal.
		this.bal = bal;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		
	}
	public String getFname() {
		return fName;
	}
	public String getLname() {
		return lName;
	}
	public int getbal() {
		return bal;
	}
	
	public void deposit(int amount) {
		bal += amount;
	}
	//reduce balance by amount
	public void withdraw(int amount) 
			throws insufficientFundsException, currencyError {
		if(amount < 0) {
			throw new currencyError("less than 0 not allowed\n");
		}
		else if(bal < amount) {
			throw new insufficientFundsException("Amount requested ($"+amount+") is "+
		"more than available balance\n");
		}
		//make the withdrawal
		bal -= amount;
	}
	//returns information about the account
	public String toString() {
		return "Name: "+ fName + " " + lName;	
	}

}
