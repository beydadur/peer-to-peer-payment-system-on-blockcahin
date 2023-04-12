package walletTransfer;

public class Transfer {

	private Wallet from;
	private Wallet to;
	private double amount;
	private boolean success;

	public Transfer(Wallet from, Wallet to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.success = false;
	}

	public Wallet getFrom() {
		return from;
	}

	public void setFrom(Wallet from) {
		this.from = from;
	}

	public Wallet getTo() {
		return to;
	}

	public void setTo(Wallet to) {
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Transfer:\n  from=" + from + "\n  to=" + to + "\n  amount=" + amount + "\n  success=" + success;
	}

}