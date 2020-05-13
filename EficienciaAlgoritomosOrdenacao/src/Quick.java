
public class Quick implements Algoritmos {

	@Override
	public void sortInt(int[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separarInt(vetor, inicio, fim);
			sortInt(vetor, inicio, posicaoPivo - 1);
			sortInt(vetor, posicaoPivo + 1, fim);
		}
	}

	@Override
	public void sortFloat(float[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separarFloat(vetor, inicio, fim);
			sortFloat(vetor, inicio, posicaoPivo - 1);
			sortFloat(vetor, posicaoPivo + 1, fim);
		}

	}

	@Override
	public void sortDouble(double [] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separarDouble(vetor, inicio, fim);
			sortDouble(vetor, inicio, posicaoPivo - 1);
			sortDouble(vetor, posicaoPivo + 1, fim);
		}
	}

	private int separarInt(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	private int separarFloat(float[] vetor, int inicio, int fim) {
		float pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				float troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	private int separarDouble(double[] vetor, int inicio, int fim) {
		double pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i] <= pivo)
				i++;
			else if (pivo < vetor[f])
				f--;
			else {
				double troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
}