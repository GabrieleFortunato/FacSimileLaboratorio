package biblioteca;

import java.util.Iterator;
import java.util.TreeMap;
import eccezioni.VolumeNonPresenteEccezione;
import eccezioni.VolumePresenteEccezione;
import volumi.Volume;

/**
 * Classe Biblioteca
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class Biblioteca implements Iterable<String>{

	private TreeMap<String,Volume> volumi;
	
	/**
	 * Metodo costruttore
	 */
	public Biblioteca(){
		this.setVolumi(new TreeMap<>());
	}

	/**
	 * Imposta i volumi presenti in biblioteca
	 * @param volumi
	 */
	private void setVolumi(TreeMap<String,Volume> volumi) {
		this.volumi = volumi;
	}
	
	/**
	 * Aggiunge un volume alla biblioteca
	 * @param codice
	 * @param volume
	 * @throws VolumePresenteEccezione 
	 */
	public void aggiungiVolume(String codice, Volume volume) 
			throws VolumePresenteEccezione{
		if (!volumePresente(codice)){
			volumi.put(codice, volume);
		} else {
			throw new VolumePresenteEccezione();
		}
	}
	
	/**
	 * Rimuove un volume alla biblioteca
	 * @param codice
	 * @param volume
	 * @throws VolumeNonPresenteEccezione 
	 */
	public void rimuoviVolume(String codice) throws VolumeNonPresenteEccezione{
		if (volumePresente(codice)){
			volumi.put(codice, ottieniVolume(codice));
		} else {
			throw new VolumeNonPresenteEccezione();
		}
	}
	
	/**
	 * Ottiene il volume presente in biblioteca con un dato codice
	 * @param codice
	 * @return
	 */
	public Volume ottieniVolume(String codice){
		return volumi.get(codice);
	}
	
	/**
	 * Verifica la presenza in biblioteca 
	 * di un volume con un dato codice
	 * @param codice
	 * @return
	 */
	private boolean volumePresente(String codice){
		return volumi.keySet().contains(codice);
	}

	@Override
	/**
	 * Itera sui volumi in ordine alfabetico di codice
	 */
	public Iterator<String> iterator() {
		return volumi.keySet().iterator();
	}
	
}