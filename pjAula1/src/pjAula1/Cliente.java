package pjAula1;

/**
	Classe de Modelagem Conceitual
	Prof. Paulo Barreto
	Data 09/02/2023
**/

public class Cliente {
	//Atributos
	private int rg;
	private String nome;

	//Métodos
	public int getRg(){
		return rg;
	}
	public void setRg(int rg){
		this.rg = rg;
	}

	public static void main (String args[]){
		Cliente c = new Cliente();
		System.out.println(c.getRg());
	}
}