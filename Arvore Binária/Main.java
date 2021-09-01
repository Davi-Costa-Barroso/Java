package arvores;
//DAVI COSTA BARROSO
public class Main {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		System.out.println("Arvore:");
		
		arvore.inserir(6);
		arvore.inserir(3);
		arvore.inserir(1);
		arvore.inserir(4);
		
		/* Quando os elementos são inseridos de forma ordenada (1, 2, 3...)
		 * é como se tivesse apenas um unico galho, todos os novos valores 
		 * serão inseridos no lado direito da arvore por ser sempre maior que
		 * a raiz. Dessa forma, a arvore se torna muito profunda e nao é bem
		 * repartida, teremos muitos niveis e apenas uma folha.
		*/
		arvore.imprimir();
		System.out.println("-----------------");
		System.out.println(arvore.buscar(6).getDado());
	}
}