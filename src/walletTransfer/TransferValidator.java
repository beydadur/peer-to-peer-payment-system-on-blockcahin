package walletTransfer;

import exception.InvalidTransferException;

public class TransferValidator {

	public void validateAmount(double amount) throws InvalidTransferException {
		if (amount < 0) {
			throw new InvalidTransferException("Transfer is invalid because Amount should be greater than 0");
		}
	}
	
	public void validateAmount(Wallet w, double d) throws InvalidTransferException {
		if (w.getBalance() < d) {
			throw new InvalidTransferException("Transfer is invalid because Amount should be greater than 0");
		}
	}
}