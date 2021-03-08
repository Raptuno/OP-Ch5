package core;
import java.io.*;
import java.util.*;
import java.text.Normalizer;

//Reto 5: Juego de adivinar palabras

/*
* Carlos desea ayudar a mejorar la ortografía de su hijo, por lo que ha pensado en realizar un juego de adivinar palabras.
* Él sabe que tú tienes nociones para hacer el juego y te ha pedido que lo ayudes.
* 
* Toma en cuenta lo siguiente:
* 
* Este juego deberá tener tres niveles: fácil, intermedio y avanzado.
* El juego se podrá jugar todas las veces que se quiera hasta que el usuario introduzca 0 (cero).
* El usuario solo podrá introducir una letra a la vez
* Al momento de que el usuario introduzca la letra, el sistema desplegará lo siguiente:
* 
* Si la letra concuerda con alguna de la palabra base, se mostrará la letra en el lugar correspondiente
* Si la letra no corresponde con alguna de las letras de la palabra base, mostrará un mensaje como el siguiente: Inténtalo de nuevo!!
* Las palabras base estarán fijadas y deben tener los siguientes lineamientos
* 		Para el nivel fácil debe ser una palabra de 4 letras.
* 		Para el nivel intermedio debe ser una palabra de 8 letras.
* 		Para el nivel avanzado una palabra de 12 letras.
*/

public class Game {
	//Inicia lista de Arreglos de palabras por dificultad
	String [] easy= {"Vaca", "Foca", "León", "Mano", "Taza"};
	String [] inter= {"Enchufar", "Abejones", "Mariachi", "Abejorro", "Acompaño"};
	String[] hard= {"Diccionarios", "Aflojamiento", "Arqueología", "Barbaridades", "Mexicanismos"};
	//Termina lista de Arreglos de palabras por dificultad
	
	public String accentStripper(String s) { //Método para quitar acentos en la selección de dificultad
		String stripOutcome=Normalizer.normalize(s, Normalizer.Form.NFD);
		stripOutcome=stripOutcome.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return stripOutcome;
	}
	
	public int indexer() {
		return (int) (Math.random()*((6-1)+1)+1);
	}
	
	public void mainGame() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escoge una dificultad (Fácil, Intermedia o Avanzada): ");
		
		try {
			switch(accentStripper(br.readLine().toLowerCase())) {
			case "facil":
				String guess=easy[0];
				break;
			}
		} catch (Exception e) {
			System.out.println("Algo salió mal."
					+ "\nContacta al creador de este programa (un jóven con el apodo de Raptuno)"
					+ "\ny muéstrale este mensaje:\n");
			e.printStackTrace();
		}
	}
}
