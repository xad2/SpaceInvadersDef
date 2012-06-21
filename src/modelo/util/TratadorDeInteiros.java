package modelo.util;

import java.util.ArrayList;
import java.util.Random;

public class TratadorDeInteiros {

	public static ArrayList<Integer> criarArrayDeInteirosDiferentes(int qtd,
			int tamMax, int tamMin, int dy) {

		ArrayList<Integer> lista = new ArrayList<Integer>(qtd);
		// inicializei
		for (int z = 0; z < qtd; z++) {
			lista.add(z, -50);
		}

		for (int z = 0; z < qtd; z++) {

			int r = 0;
			do {
				Random random = new Random();
				r = (int) (tamMin + random.nextDouble() * (tamMax - tamMin));

			} while (nmrRepetido(z, r, lista, qtd, dy));

			lista.set(z, r);
		}

		return lista;
	}

	public static int retornarNmrAleatorio(int max) {

		Random random = new Random();
		return (int) ((int) 1 + random.nextDouble() * max);

	}

	public static boolean nmrRepetido(int p, int re, ArrayList<Integer> lista,
			int qtd, int dy) {

		for (int k = 0; k < qtd; k++) {

			if (re >= lista.get(k) - dy && re <= lista.get(k) + dy) {
				return true;
			}

		}

		return false;

	}

}
