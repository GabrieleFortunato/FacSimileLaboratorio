package volumi;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe Biblioteca
 *
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class OrdinaPerNomeAutore implements Comparator<Volume> {

	@Override
	/**
	 * Confronta due volumi in base al nome del primo autore
	 */
	public int compare(Volume v1, Volume v2) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Autore> a = new ArrayList<>(v1.getAutori());
		ArrayList<Autore> b = new ArrayList<>(v2.getAutori());
		
		return a.get(0).getNome().compareTo(b.get(0).getNome());
	
	}

}
