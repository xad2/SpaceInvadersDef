package modelo.util;

import java.util.ArrayList;
import java.util.Random;

public class TratadorDeInteiros {

	public static int retornarNmrAleatorio(int max) {

		Random random = new Random();
		return (int) ((int) 1 + random.nextDouble() * max);

	}

}
