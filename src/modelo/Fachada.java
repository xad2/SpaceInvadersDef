package modelo;

public class Fachada {

	private Nave nave;

	public Fachada(Nave nave) {
		this.nave = nave;

	}

	public void moverNaveNaHorizontal(int d) {

		nave.andarNaHorizontal(d);

	}

	public void moverNaveNaVertical(int d) {
		nave.andarNaVertical(d);

	}

	public void atirarComANave() {
		nave.atirar();
	}

}
