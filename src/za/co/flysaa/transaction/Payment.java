package za.co.flysaa.transaction;

public class Payment {
	private String type;
	private double amount;
	private double balance;

	public Payment() {

	}

	public String getType() {
		return type;
	}

	public void setAmount(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
