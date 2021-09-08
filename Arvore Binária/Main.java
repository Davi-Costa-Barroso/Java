package arvores;
//DAVI COSTA BARROSO
public class Main {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		System.out.println("Arvore:");

		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(25);
		arvore.inserir(75);
		arvore.inserir(28);
		
		System.out.println("---------------");
		arvore.imprimir();
		System.out.println("-----------------");
		System.out.println("profundidade: "+ arvore.profundidade());
//		System.out.println("Balanceada: "+ arvore.balanceado());
//		System.out.println(arvore.buscar(6).getDado());
	}
}