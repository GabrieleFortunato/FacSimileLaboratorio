package eccezioni;

public class PrezzoNegativoEccezione extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Stampa a video un messaggio quando viene lanciata l'eccezione
	 * @param message
	 */
	public void printMessage(String message){
		System.out.println(message);
	}
	
}
