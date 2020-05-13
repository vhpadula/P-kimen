
public class ChecaVetorOrdenado {
	boolean checaVetorInt(int []vet) {
		int x, status = 0;
		x = vet[0];

		if (vet.length > 1) {
			if (x > vet[1])
				status = -1;
			else
				status = 1;
		}

		for (int i = 0; i < vet.length; i++) {
			if (x <= vet[i] && status == 1) {
				x = vet[i];
				continue;
			} else if (x >= vet[i] && status == -1) {
				x = vet[i];
				continue;
			} else {
				status = -1;
				break;
			}
		}
		if(status == 1)
			return true;
		else
			return false;
	}
	
	boolean checaVetorFloat(float []vet) {
		float x;
		int status = 0;
		x = vet[0];

		if (vet.length > 1) {
			if (x > vet[1])
				status = -1;
			else
				status = 1;
		}

		for (int i = 0; i < vet.length; i++) {
			if (x <= vet[i] && status == 1) {
				x = vet[i];
				continue;
			} else if (x >= vet[i] && status == -1) {
				x = vet[i];
				continue;
			} else {
				status = -1;
				break;
			}
		}
		if(status == 1)
			return true;
		else
			return false;
	}
	
	boolean checaVetorDouble(double []vet) {
		double x;
		int status = 0;
		x = vet[0];

		if (vet.length > 1) {
			if (x > vet[1])
				status = -1;
			else
				status = 1;
		}

		for (int i = 0; i < vet.length; i++) {
			if (x <= vet[i] && status == 1) {
				x = vet[i];
				continue;
			} else if (x >= vet[i] && status == -1) {
				x = vet[i];
				continue;
			} else {
				status = -1;
				break;
			}
		}
		if(status == 1)
			return true;
		else
			return false;
	}
}