
public interface Account {
	//will add int amount to balance
	public void deposit(int amount);
	//will subtract int amount to balance
	public void withdraw(int amount);
	//return int balance
	public int getbal();
	//return information of the object
	public String toString();
}
