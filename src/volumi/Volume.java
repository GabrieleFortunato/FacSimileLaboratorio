package volumi;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashSet;
import eccezioni.AnnoEccezione;
import eccezioni.AutoreNonPresenteEccezione;
import eccezioni.PrezzoEccezione;
import utility.Utility;

public class Volume {

	private String codice;
	private String titolo;
	private int anno;
	private double prezzo;
	private boolean stato;
	private HashSet<Autore> autori;
	private final int zero = 0;
	
	/**
	 * Metodo costruttore
	 * @param titolo
	 * @param anno
	 * @param prezzo
	 * @param stato
	 * @throws AnnoEccezione 
	 * @throws PrezzoEccezione 
	 */
	public Volume(String titolo, int anno, double prezzo, boolean stato) 
			throws AnnoEccezione, PrezzoEccezione {
		this.setTitolo(titolo);
		this.setAnno(anno);
		this.setPrezzo(prezzo);
		this.setStato(stato);
		this.setAutori(new HashSet<>());
	}

	/**
	 * Imposta il codice del volume
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Restituisce il titolo del volume
	 * @return
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Restituisce l'anno di produzione del volume
	 * @return
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Restituisce il prezzo del volume
	 * @return
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * Restituisce lo stato del volume
	 * @return
	 */
	public boolean isStato() {
		return stato;
	}

	/**
	 * Restituisce gli autori del volume
	 * @return
	 */
	public HashSet<Autore> getAutori() {
		return autori;
	}

	/**
	 * Imposta il titolo del volume
	 * @param titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Imposta l'anno di produzione del volume
	 * @param anno
	 * @throws AnnoEccezione 
	 */
	public void setAnno(int anno) throws AnnoEccezione {
		GregorianCalendar data = new GregorianCalendar();
		int annoCorrente = data.get(Calendar.YEAR);
		if (anno<=annoCorrente) {
			this.anno = anno;
		} else {
			throw new AnnoEccezione();
		}
	}

	/**
	 * Imposta il prezzo del volume
	 * @param prezzo
	 * @throws PrezzoEccezione 
	 */
	public void setPrezzo(double prezzo) throws PrezzoEccezione {
		if (prezzo>=zero) {
			this.prezzo = prezzo;
		} else {
			throw new PrezzoEccezione();
		}
	}

	/**
	 * Imposta lo stato del volume
	 */
	public void setStato(boolean stato) {
		this.stato = stato;
	}

	/**
	 * Imposta gli autori del volume
	 * @param autori
	 */
	public void setAutori(HashSet<Autore> autori) {
		this.autori = autori;
	}
	
	/**
	 * Aggiunge un autore al volume
	 * @param autore
	 */
	public void aggiungiAutore(Autore autore) {
		autori.add(autore);
	}
	
	/**
	 * Rimuove un autore dal volume
	 * @param autore
	 * @throws AutoreNonPresenteEccezione
	 */
	public void rimuoviAutore(Autore autore) throws AutoreNonPresenteEccezione {
		if (autori.contains(autore)) {
			autori.remove(autore);
		} else {
			throw new AutoreNonPresenteEccezione();
		}
	}
	
	@Override
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString() {
		return 
				"Codice: "+codice+" Titolo: "+titolo+" Anno: "+anno+" Prezzo: "+Utility.arrotonda(prezzo,2)
				+" Prestato: "+stato+" Autori: "+autori;
	}
	
	/**
	 * Ordina i volumi in base al prezzo
	 * @return
	 */
	public static Comparator<Volume> ordinaPerPrezzo(){
		return new OrdinaPerPrezzo();
	}

	/**
	 * Ordina i volumi in base al nome del primo autore
	 * @return
	 */
	public static Comparator<Volume> ordinaPerNomeAutore(){
		return new OrdinaPerNomeAutore();
		
	}
	
}