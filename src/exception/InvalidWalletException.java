package exception;

public class InvalidWalletException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidWalletException(String str) {
		super(str);
	}

}