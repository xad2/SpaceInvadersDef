package visao;

import java.awt.Point;

import javax.swing.JOptionPane;

import modelo.util.Observador;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.Pichador;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class ImagemObjetoMovel extends Renderizador implements Observador {

	private Imagem img;
	private static int n = 0;
	private static int n2 = 0;
	private Pichador pichador = new Pichador();

	public ImagemObjetoMovel(PaginaDix pagina, Point p, String caminho) {
		super(pagina);

		Coordenadas coordenadas = new Coordenadas(p.x, p.y);

		img = criarImagem("RetanguloMovel_" + n, coordenadas, caminho);
		n++;
	}

	public void desabilitar() {
		img.tornarInvisivel();
		img.desabilitar();
	}

	@Override
	public void atualizar(String codigo) {
		String[] valores = codigo.split("/");

		String a = valores[0];
		int x = Integer.parseInt(a);
		String b = valores[1];
		int y = Integer.parseInt(b);
		String c = valores[2];

		redesenhar(img, new Coordenadas(x, y));

		if (c.equals("COLIDIU")) {

			this.desabilitar();
			Imagem colisao = criarColisao(new Coordenadas(x, y),
					"Colisao" + n2, 1);
			n2++;
			pichador.descansar(1);
			colisao.tornarInvisivel();
			colisao.desabilitar();

		}

	}
}
