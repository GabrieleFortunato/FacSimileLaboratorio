package volumi;

import java.util.Comparator;

public class OrdinaPerPrezzo implements Comparator<Volume> {

	@Override
	/**
	 * Confronta due volumi in base al prezzo
	 */
	public int compare(Volume v1, Volume v2) {
		if (v1.getPrezzo()>v2.getPrezzo()){
			return -1;
		} else if (v1.getPrezzo()<v2.getPrezzo()){
			return 1;
		} else {
			return 0;
		}
	}

}
