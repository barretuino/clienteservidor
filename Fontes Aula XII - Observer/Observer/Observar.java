package observer;

import java.util.Observable;

public class Observar extends Observable {
	
	private String nome = "Inicial";
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		setChanged();
		notifyObservers(nome);
	}

	public Observar(){
		super();
		addObserver(new Observando());
		setChanged();
		notifyObservers(nome);
	}
}
