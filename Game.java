import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Receituario {

	public static int receituario(String arquivoReceitas) {//recebe o arquivo com os txts
		PossiveisAlimentos ler = new PossiveisAlimentos();
		QuantidadeAlimentos qte = new QuantidadeAlimentos();
		ListaCompras lista = new ListaCompras();
		GeraPDF PDF = new GeraPDF();
		@SuppressWarnings("unused")//nao ha como a variavel nao ser usada pq ainda que ocorra erro no try, a variavel erro recebe 1 no catch
		int erro = 0;// serve p monitorar as classes

		ArrayList<String> possiveisAlimentos = new ArrayList<>();


		try(BufferedReader lerArqIngredientes = new BufferedReader(new FileReader("Ingredientes.txt"));) {//pega o arquivo com os ingredientes possiveis

			possiveisAlimentos = ler.getListaAlimentos(lerArqIngredientes);//retorna lista com os possiveis alimentos
			int quantidade[] = new int [possiveisAlimentos.size()];
			erro = qte.getListaAlimentos(arquivoReceitas, possiveisAlimentos, quantidade);//modifica a lista de quantidade e ja checa se os
			//ingredientes da receita pertencem a lista de possiveis 
			erro = lista.geraListaCompras(quantidade, "Ingredientes.txt");// gera lista de compras da semana 

			erro = PDF.geraPDF(arquivoReceitas,"Ingredientes.txt");//gera pdf com as receitas da semana
			return erro;
		}
		catch(IOException e){
			System.out.println("Erro: " + e.getMessage());
			erro = 3;
			return erro;
		}
	}

}