package controle;



import modelo.Nave;
import modelo.util.Observador;
import visao.ImagemRetangularMovel;
import edugraf.jadix.componentesDix.Imagem;
import edugraf.jadix.fachada.Pichador;
import edugraf.jadix.tiposPrimitivos.Coordenadas;


public class ControladorDaNave implements Observador {
	
	private ImagemRetangularMovel iNave;
	private Pichador pichador = new Pichador();
	
	public ControladorDaNave(Nave nave, ImagemRetangularMovel iNave) {
		
		this.iNave = iNave;		
		nave.adicionarObservador(this);
		
	}
	
	

	@Override
	public void atualizar(String codigo) {
		
		String[] valores = codigo.split("/");
		String a = valores[0];
		int x = Integer.parseInt(a);
		String b = valores[1];
		int y = Integer.parseInt(b);
		String c = valores[2];

		
		if (c.equals("COLIDIU")) {
			
			iNave.desabilitar();
			Imagem colisao = iNave.criarColisao(new Coordenadas(x,y),
					"ColisaoNave", 1);
			pichador.descansar(1);
			colisao.fixarProfundidade(-5);
			

		}
		
	}

}
