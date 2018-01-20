package biblioteca;
import java.util.Iterator;
import java.util.TreeMap;

import eccezioni.VolumeGi‡PresenteEccezione;
import eccezioni.VolumeNonPresenteEccezione;
import volumi.Volume;

public class Biblioteca {
	
	private TreeMap<String,Volume> volumi;
	
	/**
	 * Metodo costruttore
	 */
	public Biblioteca() {
		setVolumi(new TreeMap<>());
	}

	/**
	 * Imposta i volumi presenti nella biblioteca
	 * @param volumi
	 */
	private void setVolumi(TreeMap<String,Volume> volumi) {
		this.volumi = volumi;
	}
	
	/**
	 * Verificare la presenza in biblioteca di un volume con un dato codice
	 * @param codice
	 * @return
	 */
	private boolean volumePresente(String codice) {
		return volumi.containsKey(codice);
	}
	
	/**
	 * Restituisce il volume con un dato codice
	 * @param codice
	 * @return
	 */
	public Volume volume(String codice) {
		return volumi.get(codice);
	}
	
	/**
	 * Aggiunge un volume alla biblioteca
	 * @param volume
	 * @param codice
	 * @throws VolumeGi‡PresenteEccezione
	 */
	public void aggiungiVolume(Volume volume, String codice) throws VolumeGi‡PresenteEccezione {
		if (!volumePresente(codice)) {
			volumi.put(codice, volume);
		} else {
			throw new VolumeGi‡PresenteEccezione();
		}
	}
	
	/**
	 * Rimuove dalla biblioteca un volume con un dato codice
	 * @param codice
	 * @throws VolumeNonPresenteEccezione 
	 */
	public void rimuoviVolume(String codice) throws VolumeNonPresenteEccezione {
		if (volumePresente(codice)) {
			volumi.remove(codice, volume(codice));
		} else {
			throw new VolumeNonPresenteEccezione();
		}
	}

	/**
	 * Itera sui volumi in ordine alfabetico di codice
	 */
	public Iterator<String> iterator() {
		return volumi.keySet().iterator();

	}
	
}