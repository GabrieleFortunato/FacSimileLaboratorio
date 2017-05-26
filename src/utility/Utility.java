package utility;

/**
 * Classe Biblioteca
 *
 * @author Gabriele Fortunato
 * @version 1.0 
 */
public class Utility {

	/**
	 * Arrotonda un numero decimale
	 * @param a
	 * @param b
	 * @return
	 */
	public static double round(double a, double b){
		return Math.floor(a*Math.pow(10, b))/Math.pow(10, b);
	}
	
}
