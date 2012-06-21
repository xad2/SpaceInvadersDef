package controle;

import modelo.Alien;
import modelo.Asteroide;
import modelo.Fachada;
import modelo.Jogo;
import modelo.Nave;
import modelo.PontosDimensoes;
import visao.ImagemFundo;
import visao.ImagemRetangular;
import edugraf.jadix.fachada.PaginaDix;

public class ControladorDoJogo {

	private Jogo jogo;
	private PontosDimensoes pd = new PontosDimensoes();
	protected PaginaDix pagina;

	private static final long TICKS_PER_SECOND = 50;
	private static final long SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	private static final long MAX_FRAMESKIP = 5;
	private long nextGameTick = System.currentTimeMillis();

	public ControladorDoJogo(Jogo jogo, PaginaDix pagina) {

		this.pagina = pagina;
		this.jogo = jogo;

		Asteroide asteroide = jogo.asteroide();
		Nave nave = jogo.nave();
		Alien alien = jogo.alien();
		new ImagemFundo(pagina, "recursos/square.jpg");

		ImagemRetangular iAsteroide = new ImagemRetangular(pagina,
				pd.getpAsteroide(), "recursos/squareAlien.jpg");

		asteroide.adicionarObservador(iAsteroide);

		ImagemRetangular iNave = new ImagemRetangular(pagina, pd.getpNave(),
				"recursos/sm_square.gif");
		nave.adicionarObservador(iNave);

		new ControladorDaNave(nave, iNave);

		ImagemRetangular iAlien = new ImagemRetangular(pagina, pd.getpAlien(),
				"recursos/alien.gif");
		alien.adicionarObservador(iAlien);

		Fachada fachada = new Fachada(nave);
		new TratadorDoTeclado(pagina, fachada);

	}

	public void enviarTick() {

		int loops = 0;

		while (System.currentTimeMillis() > nextGameTick
				&& loops < MAX_FRAMESKIP) {

			jogo.receberTick();

			nextGameTick += SKIP_TICKS;
			loops++;
		}

	}

	

}
