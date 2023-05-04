package observer;

import java.util.Observable;

public class RevistaBarretuino extends Observable {

	private int edicao;

	public void setNovaEdicao(int novaEdicao) {
		this.edicao = novaEdicao;
		
		setChanged();
		notifyObservers();
	}
	
	public int getEdicao() {
		return this.edicao;
	}
	
	public static void main(String[] args) {
		//poderia receber a nova edicao atraves de um recurso externo
		int novaEdicao = 3;
		RevistaBarretuino revistaInformatica = new RevistaBarretuino();		
		Assinante assinante1 = new Assinante(revistaInformatica);
		
		revistaInformatica.setNovaEdicao(novaEdicao);
	}

}