package visao;

import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;
import modelo.Tiro;
import modelo.util.Observador;

public class ImagemTiro extends Renderizador implements Observador{
	
	private static int n = 0;
	private Imagem img;
	public ImagemTiro(PaginaDix pagina, String codigo) {
		super(pagina);
		String[] valores = codigo.split("/");
		String a = valores[0];
		int x = Integer.parseInt(a);
		String b = valores[1];
		int y = Integer.parseInt(b);
		
		this.img = criarTiro(new Coordenadas(x,y), "tiro" + n );
		n++;
	}

	@Override
	public void atualizar(String codigo) {
		String[] valores = codigo.split("/");
		String a = valores[0];
		int x = Integer.parseInt(a);
		String b = valores[1];
		int y = Integer.parseInt(b);
		
		redesenhar(img, new Coordenadas(x,y));
		
	}
	
	

}
