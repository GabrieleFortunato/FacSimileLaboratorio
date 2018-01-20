package eccezioni;

public class PrezzoEccezione extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Stampa a video un messaggio quando viene lanciata l'eccezione
	 * @param messaggio
	 */
	public void stampaMessaggio(String messaggio) {
		System.out.println(messaggio);
	}
	
}
