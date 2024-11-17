/**
 * Exception thrown when an illegal word is used
 */
public class IllegalWordException extends IllegalArgumentException {
	
	
	private static final long serialVersionUID = 1L;

	public IllegalWordException(String message) {
		super(message);
	}
}