package walletTransfer;

import java.util.Map;
import exception.InvalidWalletException;
import exception.NoSuchWalletException;

public class WalletValidator {

	public void validateAddress(Wallet w) throws InvalidWalletException {

		if (!w.getAddress().startsWith("0x")) {
			throw new InvalidWalletException("Wallet is invalid because an address must start with 0x");
		}

		if (w.getAddress().length() != 42) {
			throw new InvalidWalletException(
					"Wallet is invalid because length of the contract address should be 42 including 0x in the beginning");
		}

	}

	public void validateExistence(Map<String, Wallet> wallets, String address, String chainName)
			throws NoSuchWalletException {

		if (!wallets.containsKey(address)) {
			throw new NoSuchWalletException("Transfer aborted because wallet with address " + address
					+ " does not exist on " + chainName + " chain");
		}
	}
}