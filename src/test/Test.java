package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import biblioteca.Biblioteca;
import eccezioni.AnnoEccezione;
import eccezioni.NumeroCopieStampateEccezione;
import eccezioni.PrezzoEccezione;
import eccezioni.VolumeGi�PresenteEccezione;
import volumi.Autore;
import volumi.Volume;
import volumi.VolumeRaro;

public class Test {
	
	private static final int zero = 0;
	private static final int autoriPerLibro = 3;
	private static final int numAutori = 5;
	private static final int maxPrezzo = 50;
	private static final int numVolumi = 100;
	private static final int incrementoAnno = 200;
	private static final int maxNumeroCodice = 300;
	private static final int minAnno = 1900;
	private static final int minCopie = minAnno;
	private static final int incrementoCopie = minAnno;
	private static final double probVolumeClassico = 0.1;
	private static final String nome = "nome";
	private static final String cognome = "cognome";
	private static final String codicefiscale = "codicefiscale";
	private static final String titolo = "titolo";
	private static final String annoEccezione = "anno non valido";
	private static final String prezzoEccezione = "prezzo non valido";
	private static final String numeroCopieEccezione = "prezzo non valido";
	private static final String codicePresenteEccezione = "codice gi� presente";
	private static final String collezioneGenerata = "Collezione generata";
	private static final String collezioneOrdinata = "Collezione ordinata";
	private static final String nomeFile = "output.txt";		

		/**
		 * Metodo main
		 * @param args
		 */
		public static void main(String[] args) {	
			Autore[] autori = autori();
			Volume[] volumi = volumi(autori);
			Biblioteca biblioteca = biblioteca(volumi);
			ArrayList<Volume> collezione = creaCollezione(biblioteca);
			stampaCollezione(collezione);
		}

		/**
		 * Stampa la collezione generata
		 * @param collezione
		 * @param output
		 */
		private static void stampaCollezioneOrdinata(ArrayList<Volume> collezione, 
				PrintStream output){
			System.out.println(collezioneOrdinata);
			output.println(collezioneOrdinata);
			for (Volume v:collezione){
				System.out.println(v);
				output.println(v);
			}
		}

		/**
		 * Ordina la collezione
		 * @param collezione
		 */
		private static void ordinaCollezione(ArrayList<Volume> collezione){
			Collections.sort(
					collezione,Volume.ordinaPerPrezzo().thenComparing(Volume.ordinaPerNomeAutore())
			);
		}

		/**
		 * Stampa la collezione generata
		 * @param collezione
		 * @param output
		 */
		private static void stampaCollezioneGenerata(ArrayList<Volume> collezione, 
				PrintStream output){
			System.out.println(collezioneGenerata);
			output.println(collezioneGenerata);
			for (Volume v:collezione){
				System.out.println(v);
				output.println(v);
			}
		}

		/**
		 * Stampa la collezione
		 * @param collezione
		 */
		private static void stampaCollezione(ArrayList<Volume> collezione){
			try {
				PrintStream output = new PrintStream(new File(nomeFile));
				stampaCollezioneGenerata(collezione,output);
				ordinaCollezione(collezione);
				stampaCollezioneOrdinata(collezione,output);
				output.flush();
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Crea una collezione di volumi a partire da quelli presenti nella biblioteca
		 * @param biblioteca
		 * @return
		 */
		private static ArrayList<Volume> creaCollezione(Biblioteca biblioteca){
			ArrayList<Volume> collezione = new ArrayList<>();
			Iterator<String> iter = biblioteca.iterator();
			while(iter.hasNext()){
				String codice = iter.next();
				Volume volume = biblioteca.volume(codice);
				volume.setCodice(codice);
				collezione.add(volume);
			}		
			return collezione;
		}

		/**
		 * Crea la biblioteca
		 * @param volumi
		 * @return
		 */
		private static Biblioteca biblioteca(Volume[] volumi){
			Random random = new Random();
			Biblioteca biblioteca = new Biblioteca();
			for (Volume v:volumi){
				try {
					int number = random.nextInt(maxNumeroCodice);
					String titolo = v.getTitolo();
					String codice = titolo+Integer.toHexString(number);
					biblioteca.aggiungiVolume(v, codice);
				} catch (VolumeGi�PresenteEccezione e) {
					e.stampaMessaggio(codicePresenteEccezione);
				}
			}
			return biblioteca;
		}

		/**
		 * Crea un volume classico
		 * @param i
		 * @param autore
		 * @return
		 * @throws AnnoNonValidoEccezione
		 * @throws PrezzoNegativoEccezione
		 */
		private static Volume volume(int i,Autore[] autore) {
			Volume volume = null;
			try {
				Random random = new Random();
				volume = new Volume(
						titolo+i,minAnno+random.nextInt(incrementoAnno),
						random.nextDouble()*maxPrezzo,random.nextBoolean()
				);
				for (int j=zero;j<autoriPerLibro;j++){
					int ind = random.nextInt(autore.length);
					Autore a = autore[ind];
					volume.aggiungiAutore(a);
				}
			} catch (AnnoEccezione e) {
				e.stampaMessaggio(annoEccezione);
			} catch (PrezzoEccezione e) {
				e.stampaMessaggio(prezzoEccezione);
			}
			return volume;
		}

		/**
		 * Crea un volume raro
		 * @param i
		 * @param autore
		 * @return
		 * @throws AnnoNonValidoEccezione
		 * @throws PrezzoNegativoEccezione
		 * @throws NumeroCopieEccezione
		 */
		private static VolumeRaro volumeRaro(int i,Autore[] autore) {
			VolumeRaro volume = null;
			try {
				Random random = new Random();
				int numeroCopie = minCopie+random.nextInt(incrementoCopie);
				volume = new VolumeRaro(
						titolo+i,minAnno+random.nextInt(incrementoAnno),
						random.nextDouble()*maxPrezzo,random.nextBoolean(),numeroCopie
				);
				for (int j=zero;j<autoriPerLibro;j++){
					int ind = random.nextInt(autore.length);
					Autore a = autore[ind];
					volume.aggiungiAutore(a);
				}
			} catch (AnnoEccezione e) {
				e.stampaMessaggio(annoEccezione);
			} catch (PrezzoEccezione e) {
				e.stampaMessaggio(prezzoEccezione);
			} catch (NumeroCopieStampateEccezione e) {
				e.stampaMessaggio(numeroCopieEccezione);
			}
			return volume;
		}

		/**
		 * Crea 100 volumi
		 * @param autori
		 * @return
		 */
		private static Volume[] volumi(Autore[] autore){
			Random random = new Random();
			Volume[] volume = new Volume[numVolumi];
			for (int i=zero;i<volume.length;){
				double prob = random.nextDouble();
				if (prob>probVolumeClassico){
					volume[i] = volume(i,autore);					
				} else{
					volume[i] = volumeRaro(i,autore);
				}
				if (volume[i]!=null) {
					i++;
				}
			}		
			return volume;
		}

		/**
		 * Crea alcuni autori
		 * @return
		 */
		private static Autore[] autori(){
			Autore[] autore = new Autore[numAutori];
			for (int i=zero;i<autore.length;i++){
				autore[i] = new Autore(nome+i,cognome+i,codicefiscale+i);
			}
			return autore;
		}

}
