package core;
import java.io.*;
import java.util.*;
import java.text.Normalizer;

//Reto 5: Juego de adivinar palabras

/*
* Carlos desea ayudar a mejorar la ortograf�a de su hijo, por lo que ha pensado en realizar un juego de adivinar palabras.
* �l sabe que t� tienes nociones para hacer el juego y te ha pedido que lo ayudes.
* 
* Toma en cuenta lo siguiente:
* 
* Este juego deber� tener tres niveles: f�cil, intermedio y avanzado.
* El juego se podr� jugar todas las veces que se quiera hasta que el usuario introduzca 0 (cero).
* El usuario solo podr� introducir una letra a la vez
* Al momento de que el usuario introduzca la letra, el sistema desplegar� lo siguiente:
* 
* Si la letra concuerda con alguna de la palabra base, se mostrar� la letra en el lugar correspondiente
* Si la letra no corresponde con alguna de las letras de la palabra base, mostrar� un mensaje como el siguiente: Int�ntalo de nuevo!!
* Las palabras base estar�n fijadas y deben tener los siguientes lineamientos
* 		Para el nivel f�cil debe ser una palabra de 4 letras.
* 		Para el nivel intermedio debe ser una palabra de 8 letras.
* 		Para el nivel avanzado una palabra de 12 letras.
*/

public class Game {
	//Inicia lista de Arreglos de palabras por dificultad
	String [] easy= {"Vaca", "Foca", "Le�n", "Mano", "Taza"};
	String [] inter= {"Enchufar", "Abejones", "Mariachi", "Abejorro", "Acompa�o"};
	String[] hard= {"Diccionarios", "Aflojamiento", "Arqueolog�a", "Barbaridades", "Mexicanismos"};
	//Termina lista de Arreglos de palabras por dificultad
	
	public String accentStripper(String s) { //M�todo para quitar acentos en la selecci�n de dificultad
		String stripOutcome=Normalizer.normalize(s, Normalizer.Form.NFD);
		stripOutcome=stripOutcome.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return stripOutcome;
	}
	
	public int indexer() {
		return (int) (Math.random()*((6-1)+1)+1);
	}
	
	public void mainGame() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escoge una dificultad (F�cil, Intermedia o Avanzada): ");
		
		try {
			switch(accentStripper(br.readLine().toLowerCase())) {
			case "facil":
				String guess=easy[0];
				break;
			}
		} catch (Exception e) {
			System.out.println("Algo sali� mal."
					+ "\nContacta al creador de este programa (un j�ven con el apodo de Raptuno)"
					+ "\ny mu�strale este mensaje:\n");
			e.printStackTrace();
		}
	}
}
