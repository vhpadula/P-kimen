
public class Merge implements Algoritmos {
	
	@Override
	public void sortInt(int[] vetor, int inicio, int fim) {
		int i;
		if (fim < 2) {
	        return;
	    }
	    int mid = fim / 2;
	    int[] l = new int[mid];
	    int[] r = new int[fim - mid];
	 
	    for (i = 0; i < mid; i++) {
	        l[i] = vetor[i];
	    }
	    for (i = mid; i < fim; i++) {
	        r[i - mid] = vetor[i];
	    }
	    sortInt(l, 0, mid);
	    sortInt(r, 0, fim - mid);
	 
	    mergeInt(vetor, l, r, mid, fim - mid);
	
	}

	@Override
	public void sortFloat(float[] vetor, int inicio, int fim) {
		if (fim < 2) {
			return;
		}
		int mid = fim / 2;
		float[] l = new float[mid];
		float[] r = new float[fim - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = vetor[i];
		}
		for (int i = mid; i < fim; i++) {
			r[i - mid] = vetor[i];
		}
		sortFloat(l, 0, mid);
		sortFloat(r, 0, fim - mid);

		mergeFloat(vetor, l, r, mid, fim - mid);
	}

	@Override
	public void sortDouble(double[] vetor, int inicio, int fim) {
		if (fim < 2) {
			return;
		}
		int mid = fim / 2;
		double[] l = new double[mid];
		double[] r = new double[fim - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = vetor[i];
		}
		for (int i = mid; i < fim; i++) {
			r[i - mid] = vetor[i];
		}
		sortDouble(l, 0, mid);
		sortDouble(r, 0, fim - mid);

		mergeDouble(vetor, l, r, mid, fim - mid);
	}
	
	private void mergeInt(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}


	}
	
	private void mergeFloat(float[] a, float[] l, float[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}


	}
	
	private void mergeDouble(double[] a, double[] l, double[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}


	}
	
}