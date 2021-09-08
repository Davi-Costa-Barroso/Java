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
		
		if(raiz.balanceado() != 0) {
			int raizBal = raiz.balanceado();
			if(raizBal == 1)      rotacaoDireita();
			else if(raizBal == 2) rotacaoDuplaDireita();
			else if(raizBal == 3) rotacaoEsquerda();
			else if(raizBal == 4) rotacaoDuplaEsquerda();
			raiz.memorizarProfundidade();
		}
	}

	public void rotacaoDireita() {
		System.out.println("RD - RAIZ");
		No tmpRaiz = raiz;
		No esq = raiz.getEsquerdo();
		No esqDir = esq.getDireito();
		No dir = raiz.getDireito();
		
		raiz = esq;
		raiz.setDireito(tmpRaiz);
		raiz.getDireito().setDireito(dir); 
		raiz.getDireito().setEsquerdo(esqDir);
		
	}
	
	public void rotacaoEsquerda() {
		System.out.println("RE - RAIZ");
		No tmpRaiz = raiz;
		No dir = raiz.getDireito();
		No dirEsq = dir.getEsquerdo();
		No esq = raiz.getEsquerdo();
		
		raiz = dir;
		raiz.setEsquerdo(tmpRaiz);
		raiz.getEsquerdo().setEsquerdo(esq); 
		raiz.getEsquerdo().setDireito(dirEsq);
	}
	
	public void rotacaoDuplaEsquerda() {
		System.out.println("RDE - RAIZ");
		
		No dir = raiz.getDireito();
		No dirEsq = raiz.getDireito().getEsquerdo();
		No dirEsqDir = raiz.getDireito().getEsquerdo().getDireito();
		
		raiz.setDireito(dirEsq);
		raiz.getDireito().setDireito(dir);
		raiz.getDireito().getDireito().setEsquerdo(dirEsqDir);

		No tmpRaiz = raiz;
		No novoDir = raiz.getDireito();
		No novoDirEsq = raiz.getDireito().getEsquerdo();
		
		raiz = novoDir;
		tmpRaiz.setDireito(novoDirEsq);
		raiz.setEsquerdo(tmpRaiz);
	}

	public void rotacaoDuplaDireita() {
		System.out.println("RDD - RAIZ");
		No esq = raiz.getEsquerdo();
		No esqDir = raiz.getEsquerdo().getDireito();
		No esqDirEsq = raiz.getEsquerdo().getDireito().getEsquerdo();
		
		raiz.setEsquerdo(esqDir);
		raiz.getEsquerdo().setEsquerdo(esq);
		raiz.getEsquerdo().getEsquerdo().setDireito(esqDirEsq);
		
		No tmpRaiz = raiz;
		No novoEsq = raiz.getEsquerdo();
		No novoEsqDir = raiz.getEsquerdo().getDireito();
		
		raiz = novoEsq;
		tmpRaiz.setEsquerdo(novoEsqDir);
		raiz.setDireito(tmpRaiz);

	}

	public int profundidade() {
		if(raiz == null) return 0;
		else return raiz.profundidade();
	}
	
//	public boolean balanceado() {
//		return raiz.balanceado();
//	}

	public int balanceado() {
		return raiz.balanceado();
	}
}