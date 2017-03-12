/**
 * 
 */
package utiles;

/**
 * @author hevacho
 *
 */
public class NoRollBackException extends Exception {

	
	private static final long serialVersionUID = -3350729388184417077L;

	/**
	 * 
	 */
	public NoRollBackException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoRollBackException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoRollBackException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NoRollBackException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NoRollBackException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
