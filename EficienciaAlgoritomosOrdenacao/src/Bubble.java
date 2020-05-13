
public class Bubble implements Algoritmos {

	@Override
	public void sortInt(int[] vetor, int inicio, int fim) {
		boolean troca = true;
        int aux, i;
      
        while (troca) {
            troca = false;
            for (i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
	}

	@Override
	public void sortFloat(float[] vetor, int inicio, int fim) {
		boolean troca = true;
        float aux;
        int i;
        while (troca) {
            troca = false;
            for (i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
	}

	@Override
	public void sortDouble(double[] vetor, int inicio, int fim) {
		boolean troca = true;
        double aux;
        int i;
        while (troca) {
            troca = false;
            for (i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
	}

}