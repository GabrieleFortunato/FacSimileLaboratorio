package volumi;
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
	 * Restituisce il nome dell'autore
	 * @return
	 */
	public String getNome() {
		return nome;
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

	@Override
	/**
	 * Restituisce l'hashCode dell'autore
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString() {
		return "Nome: "+nome+" Cognome: "+cognome+" Codice fiscale: "+codiceFiscale;
	}
		
}