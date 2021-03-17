package core;
import java.io.*;
import java.util.*;
import java.text.Normalizer;

//Reto 5: Juego de adivinar palabras

/*
* Carlos desea ayudar a mejorar la ortografáa de su hijo, por lo que ha pensado en realizar un juego de adivinar palabras.
* ál sabe que tá tienes nociones para hacer el juego y te ha pedido que lo ayudes.
* 
* Toma en cuenta lo siguiente:
* 
* Este juego deberá tener tres niveles: fácil, intermedio y avanzado.
* El juego se podrá jugar todas las veces que se quiera hasta que el usuario introduzca 0 (cero).
* El usuario solo podrá introducir una letra a la vez
* Al momento de que el usuario introduzca la letra, el sistema desplegará lo siguiente:
* 
* Si la letra concuerda con alguna de la palabra base, se mostrará la letra en el lugar correspondiente
* Si la letra no corresponde con alguna de las letras de la palabra base, mostrará un mensaje como el siguiente: Intántalo de nuevo!!
* Las palabras base estarán fijadas y deben tener los siguientes lineamientos
* 		Para el nivel fácil debe ser una palabra de 4 letras.
* 		Para el nivel intermedio debe ser una palabra de 8 letras.
* 		Para el nivel avanzado una palabra de 12 letras.
*/

public class Game {
	//Inicia lista de Arreglos de palabras por dificultad
	public String [] easy= {"Vaca", "Foca", "León", "Mano", "Taza"};
	public String [] inter= {"Enchufar", "Abejones", "Mariachi", "Abejorro", "Acompaño"};
	public String[] hard= {"Diccionarios", "Aflojamiento", "Arqueología", "Barbaridades", "Mexicanismos"};
	//Termina lista de Arreglos de palabras por dificultad
	
	public String accentStripper(String s) { //Mátodo para quitar acentos en la selección de dificultad
		String stripOutcome=Normalizer.normalize(s, Normalizer.Form.NFD);
		stripOutcome=stripOutcome.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return stripOutcome;
	}
	
	public int indexer(int max) {
		return (int) (Math.random()*(((max-1)-0)+1));
	}
	
	public void mainGame(String diff) {
		Engine1 eng1=new Engine1();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String cmp;
		String guess;
		
		switch(diff) {
		case "facil":
			cmp=new String(eng1.stringInit(easy, indexer(5)));
			guess=eng1.gameInit(cmp);
			eng1.mainScript(cmp, guess, br);
			break;
		case "intermedia":
			cmp=new String(eng1.stringInit(inter, indexer(5)));
			guess=eng1.gameInit(cmp);
			eng1.mainScript(cmp, guess, br);
			break;
		case "avanzada":
			cmp=new String(eng1.stringInit(hard, indexer(5)));
			guess=eng1.gameInit(cmp);
			eng1.mainScript(cmp, guess, br);
			break;
		}
	}
}
