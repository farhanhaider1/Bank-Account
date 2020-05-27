
public class checking implements Account {
	//balance of account
	private int bal;
	
	public checking() {
		bal = 0;
	}
	//constructor 2 if initial account is provided
	public checking(int bal){
		//open account with this bal.
		this.bal = bal;
	}

	public int getbal() {
		return bal;
	}
	/* 
	 * Process:
	 * 		Increase balance by provided amount if allowed
	 * Action allowed if:
	 * 		Amount > 0 
	 * Exceptions:
	 * 		currencyError thrown
	 */
	public void deposit(int amount) 
			throws currencyError {
		if(amount <= 0) {
			throw new currencyError("Deposit must be greater than $0");
		}
		//perform action
		bal += amount;
	}
	/* 
	 * Process:
	 * 		Reduce balance by provided amount if allowed
	 * Action allowed if:
	 * 		Amount > 0 <= balance
	 * Exceptions:
	 * 		insufficientFundsException and currencyError thrown
	 */
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
		return "Balance: " + bal;	
	}

}
