package core;
import java.io.*;
import java.util.*;

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
 * Si la letra concuerda con alguna de la palabra base, se mostrar� la letra en el lugar correspondiente
 * Si la letra no corresponde con alguna de las letras de la palabra base, mostrar� un mensaje como el siguiente: Int�ntalo de nuevo!!
 * Las palabras base estarán fijadas y deben tener los siguientes lineamientos:
 * 		Para el nivel fácil debe ser una palabra de cuatro letras.
 * 		Para el nivel intermedio debe ser una palabra de ocho letras.
 * 		Para el nivel avanzado debe ser una palabra de 12 letras.
 */

public class Main {
	
	public void exitTripper(){
		Runtime.getRuntime().exit(0);
	}
	
	public static void main (String[] args) throws IOException{
		Game g=new Game();
		Engine1 eng1=new Engine1();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Boolean loop=true;
		
		while(loop) {
			System.out.print("Escoje una dificultad o pon 0 (cero) para salir: ");
			String diff=eng1.initialQuery(g.accentStripper(br.readLine().toLowerCase()));
			
			if (diff.equals(String.valueOf(0))) {
				break;
			} else {
				g.mainGame(eng1.initialQuery(diff));
			}
		}
	}
}
