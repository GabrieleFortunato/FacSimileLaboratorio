package volumi;


/**
 * Classe Biblioteca
 *
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class Autore {

	private String nome;
	private String cognome;
	private String codiceFiscale;	
	
	/**
	 * Metodo costruttore
	 * @param nome
	 * @param cognome
	 * @param codiceFiscale
	 */
	public Autore(String nome, String cognome, String codiceFiscale) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCodiceFiscale(codiceFiscale);
	}

	/**
	 * Imposta il nome dell'autore
	 * @param nome
	 */
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta il cognome dell'autore
	 * @param cognome
	 */
	private void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Imposta il codice fiscale dell'autore
	 * @param codiceFiscale
	 */
	private void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Restituisce il nome dell'autore
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	@Override
	/**
	 * Genera l'hashcode in base al codice fiscale
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		return result;
	}

	@Override
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString() {
		return nome+" "+cognome;
	}
		
}