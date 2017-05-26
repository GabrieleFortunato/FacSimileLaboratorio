package volumi;

import eccezioni.AnnoNonValidoEccezione;
import eccezioni.NumeroCopieEccezione;
import eccezioni.PrezzoNegativoEccezione;

/**
 * Classe Biblioteca
 *
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class VolumeRaro extends Volume {

	private int numeroCopie;

	/**
	 * Metodo costruttore
	 * @param titolo
	 * @param anno
	 * @param prezzo
	 * @param prestato
	 * @param numeroCopie
	 * @throws AnnoNonValidoEccezione
	 * @throws PrezzoNegativoEccezione
	 * @throws NumeroCopieEccezione 
	 */
	public VolumeRaro(String titolo, int anno, double prezzo, boolean prestato, int numeroCopie)
			throws AnnoNonValidoEccezione, PrezzoNegativoEccezione, NumeroCopieEccezione {
		super(titolo, anno, prezzo, prestato);
		this.setNumeroCopie(numeroCopie);
	}
	
	/**
	 * Imposta il numero di copie stampate del volume raro
	 * @param numeroCopie
	 * @throws NumeroCopieEccezione 
	 */
	private void setNumeroCopie(int numeroCopie) throws NumeroCopieEccezione {
		if (numeroCopie>0){
			this.numeroCopie = numeroCopie;
		} else {
			throw new NumeroCopieEccezione();
		}
	}

	@Override
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString() {
		return super.toString()+" numero di copie stampate" + numeroCopie ;
	}
		
}