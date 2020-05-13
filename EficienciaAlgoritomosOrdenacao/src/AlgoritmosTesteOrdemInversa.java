import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class AlgoritmosTesteOrdemInversa {
	int i, randomInt;
	float randomFloat;
	double randomDouble;
	long tempoInicial, tempoFinal;
	ChecaVetorOrdenado check = new ChecaVetorOrdenado();
	Insertion testeInsertion = new Insertion ();
	Bubble testeBubble = new Bubble();
	Merge testeMerge = new Merge();
	Quick testeQuick = new Quick();
	Random random = new Random();

	//Testes sao baseados em vetores da forma 10^p
	@Test
	void numerosOrdemInversaEmQuePVale1() {
		int []a = new int [10];
		float []b= new float [10];
		double []c = new double [10];
		int []auxA = new int [10];
		float []auxB = new float [10];
		double []auxC = new double [10];
		randomInt = random.nextInt(10);
		randomFloat = random.nextFloat() * 10;
		randomDouble = random.nextDouble() * 10;
		//preenche o vetor de forma inversa
		for(i = 9; i >= 0; i--) {
			a[i] = i + randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}
		//preencher vetores aux, que server para restaurar a ordem do vetor original
		for(i = 0; i < 10; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("TESTE PARA LISTA DE NUMEROS EM ORDEM DECRESCENTE");
		System.out.println();
		System.out.println("/------------------Teste para P = 1------------------/");

		//teste Bubble 
		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		//retornando vetores aos valores originais
		for(i = 0; i < 10; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 10; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Merge
		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 10);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 10; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Quick
		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 9);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 9);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 9);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

	@Test
	void numerosOrdemInversaEmQuePVale2() {
		int []a = new int [100];
		float []b= new float [100];
		double []c = new double [100];
		int []auxA = new int [100];
		float []auxB = new float [100];
		double []auxC = new double [100];
		randomInt = random.nextInt(100);
		randomFloat = random.nextFloat() * 100;
		randomDouble = random.nextDouble() * 100;

		for(i = 99; i >= 0; i--) {
			a[i] = i+ randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}

		for(i = random.nextInt(99); i < 100; i+=random.nextInt(10)) {	
			a[i] = random.nextInt(100);
			b[i] = random.nextFloat()*100;
			c[i] = random.nextDouble()*100;		
		}

		for(i = 0; i < 100; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("/------------------Teste para P = 2------------------/");

		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 100);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 99);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 99);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 99);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

	@Test
	void numerosOrdemInversaEmQuePVale3() {
		int []a = new int [1000];
		float []b= new float [1000];
		double []c = new double [1000];
		int []auxA = new int [1000];
		float []auxB = new float [1000];
		double []auxC = new double [1000];
		randomInt = random.nextInt(1000);
		randomFloat = random.nextFloat() * 100;
		randomDouble = random.nextDouble() * 100;

		for(i = 999; i >= 0; i--) {
			a[i] = i+ randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}

		for(i = random.nextInt(999); i < 1000; i+=random.nextInt(100)) {	
			a[i] = random.nextInt(1000);
			b[i] = random.nextFloat()*100;
			c[i] = random.nextDouble()*100;		
		}

		for(i = 0; i < 1000; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("/------------------Teste para P = 3------------------/");

		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 1000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

	@Test
	void numerosOrdemInversaEmQuePVale4() {
		int []a = new int [10000];
		float []b= new float [10000];
		double []c = new double [10000];
		int []auxA = new int [10000];
		float []auxB = new float [10000];
		double []auxC = new double [10000];
		randomInt = random.nextInt(10000);
		randomFloat = random.nextFloat() * 100;
		randomDouble = random.nextDouble() * 100;

		for(i = 9999; i >= 0; i--) {
			a[i] = i+ randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}

		for(i = random.nextInt(9999); i < 10000; i+=random.nextInt(1000)) {	
			a[i] = random.nextInt(10000);
			b[i] = random.nextFloat()*100;
			c[i] = random.nextDouble()*100;		
		}

		for(i = 0; i < 10000; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("/------------------Teste para P = 4------------------/");

		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 10000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 10000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 10000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 10000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 9999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 9999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 9999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

	@Test
	void numerosOrdemInversaEmQuePVale5() {
		int []a = new int [100000];
		float []b= new float [100000];
		double []c = new double [100000];
		int []auxA = new int [100000];
		float []auxB = new float [100000];
		double []auxC = new double [100000];
		randomInt = random.nextInt(100000);
		randomFloat = random.nextFloat() * 100;
		randomDouble = random.nextDouble() * 100;

		for(i = 99999; i >= 0; i--) {
			a[i] = i+ randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}

		for(i = random.nextInt(99999); i < 100000; i+=random.nextInt(10000)) {	
			a[i] = random.nextInt(100000);
			b[i] = random.nextFloat()*100;
			c[i] = random.nextDouble()*100;		
		}

		for(i = 0; i < 100000; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("/------------------Teste para P = 5------------------/");

		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 100000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 100000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 99999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 99999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 99999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

	@Test
	void numerosOrdemInversaEmQuePVale6() {
		int []a = new int [1000000];
		float []b= new float [1000000];
		double []c = new double [1000000];
		int []auxA = new int [1000000];
		float []auxB = new float [1000000];
		double []auxC = new double [1000000];
		randomInt = random.nextInt(1000000);
		randomFloat = random.nextFloat() * 100;
		randomDouble = random.nextDouble() * 100;

		for(i = 999999; i >= 0; i--) {
			a[i] = i+ randomInt;
			b[i] = (i + randomInt)*randomFloat;
			c[i] = (i+randomInt)*randomDouble;	
		}

		for(i = random.nextInt(999999); i < 1000000; i+=random.nextInt(100000)) {	
			a[i] = random.nextInt(1000000);
			b[i] = random.nextFloat()*100;
			c[i] = random.nextDouble()*100;		
		}

		for(i = 0; i < 1000000; i++) {
			auxA[i] = a[i]; 
			auxB[i] = b[i];
			auxC[i] = c[i];
		}
		System.out.println("/------------------Teste para P = 6------------------/");

		System.out.println("Teste BubbleSort");
		tempoInicial = System.currentTimeMillis();
		testeBubble.sortInt(a, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortFloat(b, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeBubble.sortDouble(c, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("BubbleSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		//teste Insertion
		System.out.println("Teste InsertionSort");
		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortInt(a, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortFloat(b, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeInsertion.sortDouble(c, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("InsertionSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste MergeSort");
		tempoInicial = System.currentTimeMillis();
		testeMerge.sortInt(a, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortFloat(b, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeMerge.sortDouble(c, 0, 1000000);
		tempoFinal = System.currentTimeMillis();
		System.out.println("MergeSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);

		for(i = 0; i < 1000000; i++) {
			a[i] = auxA[i]; 
			b[i] = auxB[i];
			c[i] = auxC[i];
		}
		System.out.println();

		System.out.println("Teste QuickSort");
		tempoInicial = System.currentTimeMillis();
		testeQuick.sortInt(a, 0, 999999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Int executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorInt(a), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortFloat(b, 0, 999999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Float executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorFloat(b), true);

		tempoInicial = System.currentTimeMillis();
		testeQuick.sortDouble(c, 0, 999999);
		tempoFinal = System.currentTimeMillis();
		System.out.println("QuickSort Double executado em: " + (tempoFinal - tempoInicial) + " ms");
		assertEquals(check.checaVetorDouble(c), true);
		System.out.println();
	}

}