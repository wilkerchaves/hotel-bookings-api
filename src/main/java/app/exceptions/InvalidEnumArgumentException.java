package app.exceptions;

public class InvalidEnumArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEnumArgumentException(String msg) {
		super(msg);
	}
	

}
