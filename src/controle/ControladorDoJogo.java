package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Alien;
import modelo.Asteroide;
import modelo.Fachada;
import modelo.Jogo;
import modelo.ListaDeTiros;
import modelo.Nave;
import modelo.Tiro;
import modelo.constantes.PontosDimensoes;
import visao.ImagemFundo;
import visao.ImagemRetangular;
import visao.ImagemTiro;
import visao.ListaDeImagensDeTiros;
import edugraf.jadix.fachada.PaginaDix;

public class ControladorDoJogo {

	private Jogo jogo;
	private PontosDimensoes pd = new PontosDimensoes();
	private PaginaDix pagina;
	private ArrayList<Tiro> tiros;
	private ListaDeImagensDeTiros listaDeImagemTiros = new ListaDeImagensDeTiros();

	private static final long TICKS_PER_SECOND = 50;
	private static final long SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	private static final long MAX_FRAMESKIP = 1;
	private long nextGameTick = System.currentTimeMillis();

	public ControladorDoJogo(Jogo jogo, PaginaDix pagina) {

		this.pagina = pagina;
		this.jogo = jogo;
		this.tiros = jogo.getTiros();

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
			criarImagensTiros();
			nextGameTick += SKIP_TICKS;
			loops++;
		}

	}

	public void criarImagensTiros() {

		int tamanhoAnterior = ListaDeTiros.obterTamanhoAnterior();
		if (tamanhoAnterior < tiros.size()) {
			for (int i = tamanhoAnterior; i < tiros.size(); i++) {
				Tiro t = tiros.get(i);
				ImagemTiro it = new ImagemTiro(pagina, t.toString());
				listaDeImagemTiros.adicionar(it);
				t.adicionarObservador(it);

			}

		}

	}

}
