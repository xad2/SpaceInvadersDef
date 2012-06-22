package controle;

import javax.swing.JOptionPane;

import modelo.Fachada;
import edugraf.jadix.eventos.EventoDeTeclado;
import edugraf.jadix.fachada.ComponenteDix;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.fachada.TratadorDixAbstrato;

public class TratadorDoTeclado extends TratadorDixAbstrato  {

	private Fachada fachada;

	public TratadorDoTeclado(PaginaDix pag, Fachada fachada) {

		this.fachada = fachada;

		ComponenteDix teclado = pag.criarProcuradorDeComponente("teclado");
		teclado.adicionarTratadorDeEventos(this);
		
		

	}

	@Override
	public void seDito(EventoDeTeclado evento) {

		int tecla = evento.obterTecla();
		if (evento.obterNomeDoEvento().toString() == "TECLA_REPETIDA") {

			if (tecla == 37) // esq
				fachada.moverNaveNaHorizontal(-1);
			if (tecla == 39) // dir
				fachada.moverNaveNaHorizontal(1);
			if (tecla == 38) // cima
				fachada.moverNaveNaVertical(-1);
			if (tecla == 40)
				fachada.moverNaveNaVertical(1);
			
			
			if(tecla == 32)
				fachada.atirarComANave();
			
				

		}
		

	}

}
