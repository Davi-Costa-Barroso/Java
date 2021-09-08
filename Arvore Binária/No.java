package arvores;
//DAVI COSTA BARROSO
public class No {
	private int dado;
	private No esquerdo;
	private No direito;
	int profundidade=1;
	int balanceado=0;

	public No (int dado) {
		this.dado = dado;
		this.esquerdo = null;
		this.direito = null;
	}

	public void imprimir() {
		//Em ordem
		System.out.println(dado);
		if (esquerdo != null) esquerdo.imprimir();
		if (direito != null)  direito.imprimir();
	}
	
	public void inserir (int valor) {
		if (getDado () > valor) {
			if (esquerdo == null) esquerdo = new No (valor);
			else esquerdo.inserir (valor);
		}
		else {
			if (direito == null) direito = new No (valor);
			else direito.inserir (valor);
		}

		memorizarProfundidade();
		verificaBalanceamento();
		memorizarProfundidade();
		
	}
	
	public void verificaBalanceamento() {
		if(esquerdo != null && esquerdo.balanceado() != 0) {
			int esqBal = esquerdo.balanceado();
			if(esqBal == 1) 	 rotacaoDireita();
			else if(esqBal == 2 )rotacaoDuplaDireita();
			else if(esqBal == 3) rotacaoEsquerda();
			else if(esqBal == 4) rotacaoDuplaEsquerda();
		}
		
		if(direito!= null && direito.balanceado() !=0) {
			int dirBal = direito.balanceado();
			if(dirBal == 1) 	 rotacaoDireita();
			else if(dirBal == 2 )rotacaoDuplaDireita();
			else if(dirBal == 3) rotacaoEsquerda();
			else if(dirBal == 4) rotacaoDuplaEsquerda();
		}
	}

	public void memorizarProfundidade() {
		if(esquerdo!=null) esquerdo.memorizarProfundidade();
		if(direito!=null)  direito.memorizarProfundidade();
		
		if(esquerdo == null && direito == null) profundidade = 1;
		else if (esquerdo == null) profundidade = direito.profundidade + 1;
		else if (direito == null) profundidade = esquerdo.profundidade + 1;
		else profundidade = Math.max (direito.profundidade, esquerdo.profundidade) + 1;
	}

	public int balanceado() {
		if (direito == null && esquerdo == null) balanceado = 0;
		else if (esquerdo == null) balanceado =  0 - direito.profundidade;
		else if (direito == null)  balanceado = esquerdo.profundidade - 0;
		else balanceado = esquerdo.profundidade - direito.profundidade;

		if(balanceado == 2) {
			if(esquerdo.balanceado == 1) return 1;
			if(esquerdo.balanceado == -1) return 2;
		}
		
		if(balanceado == -2) {
			if(direito.balanceado == -1) return 3;
			if(direito.balanceado == 1)  return 4;
		}
		return 0;
		
	}
	
//	public boolean balanceado() {
//		if (direito == null && esquerdo == null) return true;
//		else if (esquerdo == null && direito.profundidade < 2) return true;
//		else if (direito == null && esquerdo.profundidade < 2) return true;
//		else if (direito != null && esquerdo != null && Math.abs (direito.profundidade - esquerdo.profundidade) < 2) return true;
//		return false;
//	}
	
	public void rotacaoEsquerda() {
		System.out.println("RE");
		No tmpDir = direito;
		No tmpDirDir = direito.direito;
		No tmpDirEsqEsq = direito.direito.esquerdo;
		direito = tmpDirDir;
		direito.esquerdo = tmpDir;
		direito.esquerdo.direito = tmpDirEsqEsq;
	}
	
	public void rotacaoDireita() {
		System.out.println("RD");
		No tmpEsq = esquerdo;
		No tmpEsqEsq = esquerdo.esquerdo;
		No tmpEsqEsqDir = esquerdo.esquerdo.direito;
		esquerdo = tmpEsqEsq;
		esquerdo.direito = tmpEsq;
		esquerdo.direito.esquerdo = tmpEsqEsqDir;
	}
	
	public void rotacaoDuplaDireita() {
		System.out.println("RDD");
		No EsqEsq = esquerdo.esquerdo;
		No esqEsqDir = esquerdo.esquerdo.direito;
		No esqEsqDirEsq = esquerdo.esquerdo.direito.esquerdo;
		
		esquerdo.esquerdo = esqEsqDir;
		esquerdo.esquerdo.esquerdo = EsqEsq;
		esquerdo.esquerdo.esquerdo.direito = esqEsqDirEsq;
		
		No esq = esquerdo;
		No novoEsqEsqDir = esquerdo.esquerdo.direito;
		esquerdo = esquerdo.esquerdo;
		esquerdo.direito = esq;
		esquerdo.direito.esquerdo = novoEsqEsqDir;
	}
	
	public void rotacaoDuplaEsquerda() {
		System.out.println("RDE");
		No dirDir = direito.direito;
		No dirDirEsq = direito.direito.esquerdo;
		No dirDirEsqDir = direito.direito.esquerdo.direito;
		
		direito.direito = dirDirEsq;
		direito.direito.direito = dirDir;
		direito.direito.direito.esquerdo = dirDirEsqDir;
		
		No tmpDir = direito;
		No tmpDirDir = direito.direito;
		No tmpDirEsqEsq = direito.direito.esquerdo;
		direito = tmpDirDir;
		direito.esquerdo = tmpDir;
		direito.esquerdo.direito = tmpDirEsqEsq;
	}

	public No buscar (int valor) {
		if (valor == getDado ()) return this;
		if (valor < getDado ()) {
			if (esquerdo == null) return null;
			else return esquerdo.buscar (valor); 
		}
		else {
			if (direito == null) return null;
			else return direito.buscar (valor);
		}
	}
	
	public int profundidade () {
//		if (esquerdo == null && direito == null) return 1;
//		if (esquerdo == null) return direito.profundidade () + 1;
//		if (direito == null) return esquerdo.profundidade () + 1;
//		return Math.max (esquerdo.profundidade (), direito.profundidade ()) + 1;
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