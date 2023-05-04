package observer;

import java.util.Observable;
import java.util.Observer;

class Assinante implements Observer {
	
	Observable RevistaBarretuino;
	
	int edicaoNovaRevista;
	
	public Assinante(Observable RevistaBarretuino) {
		this.RevistaBarretuino = RevistaBarretuino;
		RevistaBarretuino.addObserver(this);
	}
	
	@Override
	public void update(Observable revistaInfSubject, Object arg1) {
		if (revistaInfSubject instanceof RevistaBarretuino) {
			RevistaBarretuino RevistaBarretuino = (RevistaBarretuino) revistaInfSubject;
			edicaoNovaRevista = RevistaBarretuino.getEdicao();
			System.out.println("Atenção, já chegou a mais uma edição da Revista Barretuino. " +
					"Esta é a sua edição número: " + edicaoNovaRevista);
		}
	}	
}