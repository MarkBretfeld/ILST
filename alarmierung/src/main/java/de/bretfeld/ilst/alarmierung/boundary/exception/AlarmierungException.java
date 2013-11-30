/**
 * 
 */
package de.bretfeld.ilst.alarmierung.boundary.exception;

/**
 * Exception die ausgegeben, wenn bei der Alarmierung etwas schief läuft. Das
 * kann z.B. eine IOException sein, wenn der Stream ein Problem hat. Dies wird
 * nun in dieser {@link AlarmierungException} gekapselt, um eine genauerer
 * Definition zu erhalten.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class AlarmierungException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Bei der Alarmierung ist ein Fehler aufgetreten.";
	
	public AlarmierungException(Exception e) {
		super(MESSAGE, e);
	}
	
	public AlarmierungException(String message, Exception e) {
		super(message, e);
	}

}
