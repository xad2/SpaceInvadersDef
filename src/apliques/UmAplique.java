package apliques;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Date;

import javax.swing.JOptionPane;

import visao.ImagemFundo;
import visao.ImagemRetangularMovel;
import modelo.Alien;
import modelo.Espaco;
import modelo.Fachada;
import modelo.Nave;
import modelo.geometria.Retangulo;
import modelo.util.TratadorDeInteiros;
import controle.ControladorDaNave;
import controle.ControladorDoJogo;
import controle.TratadorDoTeclado;
import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class UmAplique extends Aplique {
	

	@Override
	public void iniciar() {

		ControladorDoJogo controladorJogo = new ControladorDoJogo(
				obterPaginaDix());
		int loops = 0;
		boolean jogoEmAndamento = true;
		while (jogoEmAndamento && loops >= 0) {

			loops = controladorJogo.receberTick(loops);

		}
		
		
		
	}
}