# IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**

```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

INLAB QUESTIONS WILL BE ANNOUNCED AT COURSE WEBSITE AT THE START OF EACH LAB: [https://sites.google.com/a/ku.edu.tr/comp132/programming-labs](https://sites.google.com/a/ku.edu.tr/comp132/programming-labs)

# Lab-7 Prelab: P2P Payment System on a Blockchain

In this programming lab, you will be mainly practicing with **Exception Handling concepts** by implementing an application that simulates a **Peer-to-Peer (P2P) payment system on a blockchain**. The payment system only involves sending and receiving money from one Wallet to another. Each sending/receiving operation is called a “Transfer”.

You are provided with a Java project template, and you should do your development on this template. In the given Java project, a main program code Main.java is provided to test your code. Note that we may test your codes with other test cases as well. You are free to add extra helper methods (such as getters, setters, and toString) or variables if you think they are needed. You should also decide on the visibility of the variables (public, protected, private) yourself.

Your project should have three packages: walletTransfer, exception, and main. walletTransfer package must include four classes, namely Wallet, WalletValidator, Transfer, and TransferValidator. The exception package must include InvalidWalletException, NoSuchWalletException, InvalidTransferException classes. The main package (given) must include two classes, namely Main (already given) and Chain. The details of these types are described as follows.

## Wallet Class

Each object of the Wallet class has the following fields and constructor:
- A field address of type String.
- A field balance of type double.
- A constructor with the signature Wallet(String address, double balance) where you set your fields with the parameters of the constructor.

## WalletValidator Class

Each object of this class has the following methods:

- **validateAddress:** This method takes a Wallet as a parameter and validates two things:

    -   If the first two characters of the address of the wallet are different than 0x, it throws InvalidWalletException (Hint: you can use the startsWith method of the String class to achieve this).

    -  If the length of the address is different than 42, it throws InvalidWalletException.

- **validateExistence**(Map<String, Wallet> wallets, String address, String chainName): In this method, if wallets Map (with keys as the wallet addresses and values are the Wallet objects) does not contain a wallet with the given address, it throws NoSuchWalletException. 

## Transfer Class

Has the following:

- A field from of type Wallet
- A field to of type Wallet
- A field amount of type double
- A field success of type boolean

A constructor with the signature Transfer(Wallet from, Wallet to, double amount), where you set your fields with the parameters of the constructor.

## TransferValidator Class

This class has the following method:

**validateAmount**: this method takes an amount as a parameter. If the amount is smaller than 0, it throws InvalidTransferException.

## Chain Class

Each object of Chain class has the following variables and methods:

- A field name of type String
- A field walletValidator of type WalletValidator
- A field transferValidator of type TransferValidator
- A field wallets of type HashMap<String, Wallet>

**Note**: The keys of the map are the addresses of the wallets. The values of the map are Wallet objects. 

- A field transfers of type ArrayList\<Transfer\>
  
### **Methods:**  
  
Constructor with the signature **public Chain(String name)** where you set your fields with the parameters of the constructor and initialize the fields that you need to initialize.

- **addWallet** method, which takes a Wallet as a parameter. In this method: 
    - walletValidator validates the address of the wallet
        - If the address is valid, it should add the wallet to the wallet's hashmap.
        - If the address is invalid, it should catch the Exception, print the error message and return.

- **trans**(String fromAddress, String toAddress, double amount) method. In this method: 
  
   - walletValidator validates the existence of the wallet with fromAddress.
     - If fromAddress is valid, it should get the wallet with fromAddress from the wallet's hashmap.
     - If fromAddress is not valid, it should catch the Exception, print the error message, and return.
  - walletValidator validates the existence of the wallet with toAddress.
    - If the toAddress is valid, it should get the wallet with the toAddress from the wallet's hashmap.
    - If toAddress is not valid, it should catch the Exception, print the error message, and return.
  - At this point, we are sure that both wallets are valid. Now, we can create a Transfer.
  - After the Transfer is created, transferValidator validates the amount. If the amount is valid, it sets the success of the Transfer to true and updates the balances of both wallets.
    - If the amount is invalid, it should catch the Exception, set the success of the Transfer to false, print the error message, and return.
    - It adds the transfer to the transfers list (doesn't matter if the transfer is successful or not). In your exception handling code, you have to use the finally block to achieve this.

- **printAllTransfers** method, which prints the information of all transfers.

## InvalidWalletException Class

This is a custom exception class. It basically takes an error message and prints "Wallet is invalid because " + error message, which states why this exception was thrown. For example, if the length of the address of a wallet is different than 42, it should print "Wallet is invalid because the length of the address should be 42". Another example is that if the address doesn't start with "0x", it should print "Wallet is invalid because wallet address must start with 0x".

## InvalidTransferException Class

This is another custom exception class. It basically takes an error message and prints "Transfer is invalid because " + error message, which states why this exception was thrown. For example, if the amount of the transfer is smaller than 0, it should print "Transfer is invalid because amount should be greater than 0".

## NoSuchWalletException Class

This is another custom exception class. It basically takes an error message and prints "Transfer aborted because " + error message, which states why this exception was thrown. For example, a wallet with address {address of the wallet} is given as one of the wallets, and this wallet does not exist in the specified chain, it should print "Transfer aborted because wallet with address {address of the given wallet} does not exist on {Chain Name} chain".
  
## Sample output:
    
The following is the output of the provided test code in Main class.

  ``` console
exception.InvalidWalletException: Wallet is invalid because length of the contract address should be 42 including 0x in the beginning
exception.InvalidWalletException: Wallet is invalid because an address must start with 0x
exception.NoSuchWalletException: Transfer aborted because address 0xBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB does not exist on Ethereum chain
exception.InvalidTransferException: Transfer is invalid because Amount should be greater than 0

---------------------All Transfers---------------------
Transfer:
 from=Wallet: address=0xAb5801a7D398351b8bE11C439e05C5B3259aeC9B, balance=45.0
 to=Wallet: address=0xBc6001a3D321351b8bE11C439e05C5B4449bcD8A, balance=55.0
 amount=5.0
 success=true
Transfer:
 from=Wallet: address=0x3DdfA8eC3052539b6C9549F12cEA2C295cfF5296, balance=50.0
 to=Wallet: address=0x7d2768dE32b0b80b7a3454c06BdAc94A69DDc7A9, balance=50.0
 amount=-20.0
 success=false

  
  ``` 



