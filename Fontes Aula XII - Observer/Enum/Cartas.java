package enumeracao;

public enum Cartas {
	J(11),Q(12),K(13),A(14);

	public int valorCarta;
	Cartas(int valor) {
		valorCarta = valor;
	}
}