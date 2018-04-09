package it.polito.dp2.WF.sol4.server;

public class ManagerInitializationFailException extends Exception {

	public ManagerInitializationFailException() {
	}

	public ManagerInitializationFailException(String message) {
		super(message);
	}

	public ManagerInitializationFailException(Throwable cause) {
		super(cause);
	}

	public ManagerInitializationFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManagerInitializationFailException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
