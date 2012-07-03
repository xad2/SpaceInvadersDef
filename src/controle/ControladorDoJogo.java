package controle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Alien;
import modelo.Asteroide;
import modelo.Fachada;
import modelo.Jogo;
import modelo.Nave;
import modelo.util.Observavel;
import static modelo.constantes.PontosIniciais.*;
import visao.ImagemFundo;
import visao.ImagemObjetoMovel;
import edugraf.jadix.fachada.PaginaDix;

public class ControladorDoJogo {

	private Jogo jogo;
	private TratadorDoTeclado teclado;

	private static final long TICKS_PER_SECOND = 50;
	private static final long SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	private static final long MAX_FRAMESKIP = 5;
	private long nextGameTick = System.currentTimeMillis();

	public ControladorDoJogo(Jogo jogo, TratadorDoTeclado tratador) {

		this.jogo = jogo;

		this.teclado = tratador;

	}

	public boolean enviarTick() {

		int loops = 0;
		while (System.currentTimeMillis() > nextGameTick
				&& loops < MAX_FRAMESKIP) {

			boolean jogoAndando = jogo.receberTick();

			if (!jogoAndando) {
				JOptionPane.showMessageDialog(null, "");
				return false;
			}
			nextGameTick += SKIP_TICKS;
			loops++;

		}

		return true;
	}

	
}
