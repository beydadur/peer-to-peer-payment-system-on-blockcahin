package walletTransfer;

public class Wallet {

	private String address;
	private double balance;

	public Wallet(String address, double balance) {
		this.address = address;
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet: address=" + address + ", balance=" + balance;
	}

}