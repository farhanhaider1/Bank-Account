
public class savings implements Account{
    
	private int bal;
	private static int interestRate = 2;
	
	public savings(int bal) {
		this.bal = bal;
	}
	public savings(int bal,int rate) {
		this.bal = bal;
		interestRate = rate;
	}
	//update rate for all accounts
	@SuppressWarnings("static-access")
	public void setRate(int interestRate) {
		this.interestRate = interestRate;
	}
	public static double getInterestRate(){
		 return interestRate;
	}
	public void deposit(int amount) throws currencyError {
		bal += amount;
	}
	public void withdraw(int amount) throws insufficientFundsException,
			currencyError {
		bal -= amount;
	}
	public int getbal() {
		int interest = bal * interestRate;
		bal += interest;
		return bal;
	}
	//return information of the object
	public String toString() {
		return "Int rate: "+interestRate+"\nBal: " + getbal();
	}

}
