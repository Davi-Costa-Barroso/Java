package arvores;
//DAVI COSTA BARROSO
public class No {
	private int dado;
	private No esquerdo;
	private No direito;

	public No (int dado) {
		this.dado = dado;
		this.esquerdo = null;
		this.direito = null;
	}

	public void imprimir() {
		//Em ordem
		if (esquerdo != null) esquerdo.imprimir();
		System.out.println(dado);
		if (direito != null)  direito.imprimir();
	}
	
	public void inserir(int valor) {
		if(dado > valor) {
			if(esquerdo == null) esquerdo = new No(valor);
			else esquerdo.inserir(valor);
		}
		else {
			if(direito == null) direito = new No(valor);
			else direito.inserir(valor);
		}
	}
	
	public No buscar(int valor) {
		if(valor == dado)return this;
		if(valor < dado) {
			if(esquerdo == null) return  null;
			else return esquerdo.buscar(valor);
		}
		else {
			if(direito == null) return  null;
			else return direito.buscar(valor);
		}
	}
	
	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}
}