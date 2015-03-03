/**
 * 
 */
package de.bretfeld.ilst.funk.basic.exception;

/**
 * Exception die ausgegeben, wenn bei der Tonerzeugunh etwas schief läuft. Das
 * kann z.B. eine IOException sein, wenn der Stream ein Problem hat. Dies wird
 * nun in dieser {@link TonePlayerException} gekapselt, um eine genauerer
 * Definition zu erhalten.
 * 
 * @author Mark Bretfeld
 * @version 0.1
 * 
 */
public class TonePlayerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Bei der Tonerzeugung ist ein Problem aufgetreten.";
	
	public TonePlayerException(Exception e) {
		super(MESSAGE, e);
	}
	
	public TonePlayerException(String message, Exception e) {
		super(message, e);
	}

}
