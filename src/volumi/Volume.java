package volumi;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashSet;
import eccezioni.AnnoNonValidoEccezione;
import eccezioni.AutoreNonPresenteEccezione;
import eccezioni.PrezzoNegativoEccezione;
import utility.Utility;

/**
 * Classe Biblioteca
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class Volume {

	private String codice;
	private String titolo;
	private int anno;
	private double prezzo;
	private boolean prestato;
	private HashSet<Autore> autori;
	
	/**
	 * Metodo costruttore
	 * @param titolo
	 * @param anno
	 * @param prezzo
	 * @param prodotto
	 * @throws AnnoNonValidoEccezione 
	 * @throws PrezzoNegativoEccezione 
	 */
	public Volume(String titolo, int anno, double prezzo, boolean prestato) 
			throws AnnoNonValidoEccezione, PrezzoNegativoEccezione {
		this.setTitolo(titolo);
		this.setAnno(anno);
		this.setPrezzo(prezzo);
		this.setPrestato(prestato);
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
	 * Imposta il titolo delolume
	 * @param titolo
	 */
	private void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Imposta l'anno di produzione del volume
	 * @param anno
	 * @throws AnnoNonValidoEccezione 
	 */
	private void setAnno(int anno) throws AnnoNonValidoEccezione {
		if (anno<=new GregorianCalendar().get(Calendar.YEAR)){
			this.anno = anno;
		} else {
			throw new AnnoNonValidoEccezione();
		}
	}

	/**
	 * Imposta il prezzo del volume
	 * @param prezzo
	 * @throws PrezzoNegativoEccezione 
	 */
	private void setPrezzo(double prezzo) throws PrezzoNegativoEccezione {
		if (prezzo>0){
			this.prezzo = prezzo;
		} else {
			throw new PrezzoNegativoEccezione();
		}
	}

	/**
	 * Imposta la variabile che il controlla 
	 * se il volume è stato prodotto oppure no 
	 * @param prodotto
	 */
	private void setPrestato(boolean prodotto) {
		this.prestato = prodotto;
	}
	
	/**
	 * Imposta gli autori del volume
	 * @param autori
	 */
	private void setAutori(HashSet<Autore> autori) {
		this.autori = autori;
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
	 * Restituisce la variabile che il controlla 
	 * se il volume è stato prodotto oppure no 
	 * @param prodotto
	 */
	public boolean isPrestato() {
		return prestato;
	}

	/**
	 * Restituisce gli autori del volume
	 * @return
	 */
	public HashSet<Autore> getAutori() {
		return autori;
	}

	/**
	 * Aggiungi un autore
	 * @param autore
	 */
	public void aggiungiAutore(Autore autore){
		autori.add(autore);
	}
	
	/**
	 * Rimuove un autore
	 * @param autore
	 * @throws AutoreNonPresenteEccezione
	 */
	public void rimuoviAutore(Autore autore) throws AutoreNonPresenteEccezione{
		if (autori.contains(autore)){
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
				"Codice: "+codice+" Titolo: "+titolo+" Anno: "+anno+" Prezzo: " 
				+ Utility.round(prezzo,2)+" Prestato="+prestato+" Autori: "+autori;
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