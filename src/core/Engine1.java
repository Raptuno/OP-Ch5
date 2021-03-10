package core;
import java.io.*;

public class Engine1 {
	Game g=new Game();
	public String initialQuery(String iqr) {
		return iqr;
	}
	
	public String stringInit(String[] word, int random) {
		return word[random];
	}
	
	public String gameInit(String s) {
		Game g=new Game();
		int initIndex=g.indexer(s.length());
		char[] cmpArray=s.toCharArray();
		
		for(int i=0; i<cmpArray.length; i++) {
			if(i!=initIndex) {
				cmpArray[i]='X';
			} else {
				cmpArray[i]=s.charAt(initIndex);
			}
		}
		
		return String.valueOf(cmpArray);
	}
	
	public boolean loopCheck(String s) {
		if(s.equals(String.valueOf(0))) {
			return false;
		} else {
			return true;
		}
	}
	
	public int arraySizer(String s, char c) {
		int result=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==c) {
				result++;
			}
		}
		return result;
	}
	
	public String guessEngine(String cmp, String guess, char letter) {
		char[] guessArray=guess.toCharArray();
		
		int sizer=arraySizer(cmp, letter);
		
		for(int i=0; i<cmp.length(); i++) {
			if(cmp.charAt(i)==letter) {
				guessArray[i]=letter;
			}
		}
		return String.valueOf(guessArray);
	}
	
	public void mainScript(String cmp, String guess, BufferedReader br) {
		Main m=new Main();
		System.out.println("Pista: "+guess);
		
		while(!guess.equals(cmp)) {
			try {
				System.out.print("Ingresa una letra: ");
				char letter=br.readLine().charAt(0);
				
				if(letter=='0') {
					m.exitTripper();
				} else {
					guess=guessEngine(cmp, guess, letter);
					if(guess.equals(cmp)) {
						System.out.println("¡Felicidades! Descubriste que la palabra es "+guess);
					} else {
						System.out.println("Tu palabra hasta ahora: "+guess);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
