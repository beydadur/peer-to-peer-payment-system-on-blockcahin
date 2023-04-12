package main;

import java.util.ArrayList;
import java.util.HashMap;

import exception.InvalidTransferException;
import exception.InvalidWalletException;
import exception.NoSuchWalletException;
import walletTransfer.Transfer;
import walletTransfer.TransferValidator;
import walletTransfer.Wallet;
import walletTransfer.WalletValidator;

public class Chain {

	private String name;
	private WalletValidator walletValidator = new WalletValidator();
	private TransferValidator transferValidator = new TransferValidator();
	private HashMap<String, Wallet> wallets = new HashMap<String, Wallet>();
	private ArrayList<Transfer> transfers = new ArrayList<Transfer>();

	public Chain(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WalletValidator getWalletValidator() {
		return walletValidator;
	}

	public void setWalletValidator(WalletValidator walletValidator) {
		this.walletValidator = walletValidator;
	}

	public TransferValidator getTransferValidator() {
		return transferValidator;
	}

	public void setTransferValidator(TransferValidator transferValidator) {
		this.transferValidator = transferValidator;
	}

	public HashMap<String, Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(HashMap<String, Wallet> wallets) {
		this.wallets = wallets;
	}

	public ArrayList<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(ArrayList<Transfer> transfers) {
		this.transfers = transfers;
	}

	@Override
	public String toString() {
		return "Chain [name=" + name + ", walletValidator=" + walletValidator + ", transferValidator="
				+ transferValidator + ", wallets=" + wallets + ", transfers=" + transfers + "]";
	}

	void addWallet(Wallet wallet) {

		try {
			walletValidator.validateAddress(wallet);
			wallets.put(wallet.getAddress(), wallet);
		} catch (InvalidWalletException e) {
			System.out.println(e);
			return;
		}

	}

	void trans(String fromAddress, String toAddress, double amount) {
		try {
			walletValidator.validateExistence(wallets, fromAddress, name);

		} catch (NoSuchWalletException e) {
			System.out.println(e);
			return;
		}
		Wallet w1 = wallets.get(fromAddress);

		try {
			walletValidator.validateExistence(wallets, toAddress, name);
		} catch (NoSuchWalletException e) {
			System.out.println(e);
			return;
		}
		Wallet w2 = wallets.get(toAddress);

		Transfer transfer = new Transfer(w1, w2, amount);
		try {
			transferValidator.validateAmount(amount);
			transfer.setSuccess(true);
			w1.setBalance(w1.getBalance() - amount);
			w2.setBalance(w2.getBalance() + amount);
		} catch (InvalidTransferException e) {
			transfer.setSuccess(false);
			System.out.println(e);
			return;
		} finally {
			transfers.add(transfer);
		}

	}

	void printAllTransfers() {
		for (Transfer t : transfers) {
			System.out.println(t);
		}
	}
	
	void removeFailedTransfers() {
		
	}
}
