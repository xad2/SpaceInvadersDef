package visao;

import java.awt.Dimension;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class ImagemFundo extends Renderizador {

	

	public ImagemFundo(PaginaDix pagina, String caminho) {
	
		super(pagina);
		 Imagem fundo = criarImagem( "fundo", new Coordenadas(0,0), caminho);
		fundo.fixarProfundidade(0);
	}

	@Override
	public void atualizar(String codigo) {
		// TODO Auto-generated method stub
		
	}
	
	

}
