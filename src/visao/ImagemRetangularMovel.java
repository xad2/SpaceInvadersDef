package visao;

import java.awt.Point;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class ImagemRetangularMovel extends Renderizador {
	
	private Imagem img;
	private static int n = 0;

	public ImagemRetangularMovel(PaginaDix pagina, Point p, String caminho) {
		super(pagina);
		
		Coordenadas coordenadas = new Coordenadas(p.x, p.y);
		img = criarImagem("RetanguloMovel_" + n, coordenadas, caminho);
		n++;
	}
	
	public void desabilitar(){
		img.fixarProfundidade(-5);
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

		redesenhar(img, new Coordenadas(x, y));
	}
	
	
	
}
