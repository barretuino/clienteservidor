package observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Observando implements Observer{
	
	public Observando() {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		
	}
	
	public static void main(String[] args) {
		Observar observar = new Observar();
		
		do{
			Scanner digito = new Scanner(System.in);
			observar.setNome(digito.nextLine());
		}while(!observar.getNome().equals("-1"));
		
		System.out.println("Processo encerrado");
	}

}
