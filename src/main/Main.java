/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Beyda Dur, 75881>
********************************************************************************/

package main;

import walletTransfer.Wallet;

public class Main {

	public static void main(String[] args) {
		Chain chain = new Chain("Ethereum");

		Wallet wallet1 = new Wallet("0xAb5801a7D398351b8bE11C439e05C5B3259aeC9B", 50);
		Wallet wallet2 = new Wallet("0xBc6001a3D321351b8bE11C439e05C5B4449bcD8A", 50);
		Wallet wallet3 = new Wallet("0xBc6001a3D321351b8bE11C439e05C5B4449bcD", 50);
		Wallet wallet4 = new Wallet("Bc6001a3D321351b8bE11C439e05C5B4449bcD8A", 50);
		Wallet wallet5 = new Wallet("0x34676D68Ec2F860438f02FB73F33F594880C98B8", 50);
		Wallet wallet6 = new Wallet("0x3DdfA8eC3052539b6C9549F12cEA2C295cfF5296", 50);
		Wallet wallet7 = new Wallet("0x7d2768dE32b0b80b7a3454c06BdAc94A69DDc7A9", 50);
		Wallet wallet8 = new Wallet("0xA3FD4cF465e406e2E65aF7D8B93fa5e65D4dDB5A", 50);

		chain.addWallet(wallet1); // valid
		chain.addWallet(wallet2); // valid
		chain.addWallet(wallet3);
		chain.addWallet(wallet4);
		chain.addWallet(wallet5); // valid.
		chain.addWallet(wallet6); // valid
		chain.addWallet(wallet7); // valid
		chain.addWallet(wallet8); // valid.

		chain.trans("0xAb5801a7D398351b8bE11C439e05C5B3259aeC9B", "0xBc6001a3D321351b8bE11C439e05C5B4449bcD8A", 5);
		chain.trans("0xBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB", "0xA3FD4cF465e406e2E65aF7D8B93fa5e65D4dDB5A", 5);
		chain.trans("0x3DdfA8eC3052539b6C9549F12cEA2C295cfF5296", "0x7d2768dE32b0b80b7a3454c06BdAc94A69DDc7A9", -20);

		System.out.println("\n---------------------All Transfers---------------------");
		chain.printAllTransfers();
	}

}