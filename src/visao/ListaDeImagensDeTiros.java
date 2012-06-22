package visao;

import java.util.ArrayList;
import java.util.List;

import modelo.util.Observador;

public class ListaDeImagensDeTiros implements Observador {

	public static List<ImagemTiro> imgs = new ArrayList<ImagemTiro>();

	
	public void adicionar(ImagemTiro it){
		imgs.add(it);
	}
	
	@Override
	public void atualizar(String codigo) {

	}

}
