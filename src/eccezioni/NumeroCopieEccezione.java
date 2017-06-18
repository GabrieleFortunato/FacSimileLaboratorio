package eccezioni;

import java.util.logging.Logger;

/**
 * Classe Biblioteca
 *
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class NumeroCopieEccezione extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stampa a video un messaggio quando viene lanciata l'eccezione
	 * @param message
	 */
	public void printMessage(String message){
		Logger.getLogger(message);
	}
	
}


