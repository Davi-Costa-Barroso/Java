package arvores;
//DAVI COSTA BARROSO
public class Main {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		System.out.println("Arvore:");
		arvore.inserir(6);
		arvore.inserir(3);
		arvore.inserir(9);
		arvore.inserir(10);
		
		arvore.imprimir();
		System.out.println("-----------------");
		System.out.println("profundidade: "+ arvore.profundidade());
		System.out.println("Balanceada: "+ arvore.balanceada());
//		System.out.println(arvore.buscar(6).getDado());
	}
}