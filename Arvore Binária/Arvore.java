package arvores;
//DAVI COSTA BARROSO
public class Arvore {
	No raiz;

	public void imprimir() {
		raiz.imprimir();
	}
	
	public No buscar(int valor) {
		if(raiz == null) return null;
		return raiz.buscar(valor);
	}

	public void inserir(int valor) {
		No novo = new No(valor);
		if (raiz == null) raiz = novo;
		else raiz.inserir(novo.getDado());
	}
	
	public int profundidade() {
		if(raiz == null) return 0;
		else return raiz.profundidade();
	}
	
	public boolean balanceada() {
		return raiz.balanceada();
	}
}