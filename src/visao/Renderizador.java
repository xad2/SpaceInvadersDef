package visao;

import modelo.util.Observador;
import modelo.util.Observavel;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.Pichador;
import edugraf.jadix.fachada.TiposDeComponentesDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public abstract class Renderizador  implements Observador {

	protected PaginaDix pagina;
	private Pichador pichador = new Pichador();

	public Renderizador(PaginaDix pagina) {

		this.pagina = pagina;
	}

	public ComponenteDix criarImagem(String nome, Coordenadas coordenadas,
			String caminho) {

		ComponenteDix imagem = pagina.criarComponente(
				TiposDeComponentesDix.IMAGEM, nome);
		imagem.fixarURI(caminho);
		imagem.fixarCoordenadas(coordenadas);
		return imagem;

	}

	public Imagem criarColisao(Coordenadas coord, String nome, int n) {

		Imagem img = criarImagem(nome, coord, "recursos/colisao1.gif");
		img.fixarProfundidade(2);
		pichador.descansar(0.1);
		return img;

	}

	public void redesenhar(Imagem imagem, Coordenadas coordenadas) {

		imagem.fixarCoordenadas(coordenadas);

	}

}
