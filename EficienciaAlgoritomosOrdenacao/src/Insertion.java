
public class Insertion implements Algoritmos {

	@Override
	public void sortInt(int []vetor, int inicio, int fim) {
		int j;
		int key;
		int i;

		for (j = 1; j < vetor.length; j++)
		{
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
			{
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

	@Override
	public void sortFloat(float []vetor, int inicio, int fim) {
		int j;
		int i;
		float key;

		for (j = 1; j < vetor.length; j++)
		{
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
			{
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

	@Override
	public void sortDouble(double []vetor, int inicio, int fim) {
		int j;
		int i;
		double key;

		for (j = 1; j < vetor.length; j++)
		{
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
			{
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

}