package apliques;

import modelo.Jogo;
import controle.ControladorDoJogo;
import edugraf.jadix.Aplique;

public class UmAplique extends Aplique {
	

	@Override
	public void iniciar() {

		Jogo jogo = new Jogo();
		ControladorDoJogo controladorJogo = new ControladorDoJogo(jogo,
				obterPaginaDix());
		
		boolean jogoEmAndamento = true;
		while (jogoEmAndamento ) {

			controladorJogo.enviarTick();

		}
		
		
		
	}
}