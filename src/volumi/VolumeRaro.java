package volumi;

import eccezioni.NumeroCopieStampateEccezione;
import eccezioni.PrezzoEccezione;
import eccezioni.AnnoEccezione;

public class VolumeRaro extends Volume {

	private int numeroCopie;

	/**
	 * Metodo costruttore
	 * @param titolo
	 * @param anno
	 * @param prezzo
	 * @param stato
	 * @param numeroCopie
	 * @throws AnnoEccezione
	 * @throws PrezzoEccezione
	 * @throws NumeroCopieStampateEccezione 
	 */
	public VolumeRaro(String titolo, int anno, double prezzo, boolean stato, int numeroCopie)
			throws AnnoEccezione, PrezzoEccezione, NumeroCopieStampateEccezione {
		super(titolo, anno, prezzo, stato);
		this.setNumeroCopie(numeroCopie);
	}

	/**
	 * Imposta il numero di copie stampate del volume raro
	 * @param numeroCopie
	 * @throws NumeroCopieStampateEccezione 
	 */
	private void setNumeroCopie(int numeroCopie) throws NumeroCopieStampateEccezione {
		if (numeroCopie>0) {
			this.numeroCopie = numeroCopie;
		} else {
			throw new NumeroCopieStampateEccezione();
		}
	}

	@Override
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString() {
		return super.toString()+" numero di copie stampate: "+numeroCopie;
	}
	
}
