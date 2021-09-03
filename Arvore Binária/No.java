package arvores;
//DAVI COSTA BARROSO
public class No {
	private int dado;
	private No esquerdo;
	private No direito;
	int profundidade=1;

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
		//Memorizar profundidade
		if(esquerdo == null) profundidade = direito.profundidade()+1;
		else if(direito == null) profundidade = esquerdo.profundidade()+1;
		else profundidade = Math.max(direito.profundidade(), esquerdo.profundidade())+1;
		
	}
	
	public boolean balanceada() {
		if(esquerdo == null && direito == null) return true;
		else if(direito == null && esquerdo.profundidade < 2) return false;
		else if(esquerdo == null && direito.profundidade < 2) return false;
		else if(Math.abs(direito.profundidade - esquerdo.profundidade) < 2) return true;
		else return false;
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
	
	public int profundidade() {
//		if(esquerdo == null && direito == null) return 1;
//		if(esquerdo == null) return direito.profundidade()+1;
//		if(direito == null) return esquerdo.profundidade()+1;
//		return Math.max(direito.profundidade(), esquerdo.profundidade())+1;
		return profundidade;
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