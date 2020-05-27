
public interface Account {;
	//will add int amount to balance
	public void deposit(int amount) 
			throws currencyError;
	//will subtract int amount to balance
	//must make sure enough funds are available (insufficientFundsException)
	//currency less than 0 not allowed (currencyError)
	public void withdraw(int amount) 
			throws insufficientFundsException, currencyError;
	//return int balance
	public int getbal();
	//return information of the object
	public String toString();
}
