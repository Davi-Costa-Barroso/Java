import java.util.ArrayList;
import java.util.List;

public class Arvore {
    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public void definirRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void definirEsquerdo(No pai, No esquerdo) {
        pai.esquerdo = esquerdo;
    }

    public void definirDireito(No pai, No direito) {
        pai.direito = direito;
    }

    public ResultadoBusca buscaEmProfundidade(char valor) {
        List<Character> caminho = new ArrayList<>();
        return buscaEmProfundidadeRecursiva(raiz, valor, caminho, 0);
    }

    private ResultadoBusca buscaEmProfundidadeRecursiva(No no, char valor, List<Character> caminho, int profundidade) {
        if (no == null) {
            return new ResultadoBusca(false, profundidade, caminho);
        }
        caminho.add(no.valor);
        if (no.valor == valor) {
            return new ResultadoBusca(true, profundidade, caminho);
        }
        ResultadoBusca resultadoEsquerdo = buscaEmProfundidadeRecursiva(no.esquerdo, valor, caminho, profundidade + 1);
        if (resultadoEsquerdo.encontrado) {
            return resultadoEsquerdo;
        }
        ResultadoBusca resultadoDireito = buscaEmProfundidadeRecursiva(no.direito, valor, caminho, profundidade + 1);
        if (resultadoDireito.encontrado) {
            return resultadoDireito;
        }
        caminho.remove(caminho.size() - 1);
        return new ResultadoBusca(false, profundidade, caminho);
    }

    public int calcularProfundidade() {
        return calcularProfundidadeRecursiva(raiz);
    }

    private int calcularProfundidadeRecursiva(No no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = calcularProfundidadeRecursiva(no.esquerdo);
        int alturaDireita = calcularProfundidadeRecursiva(no.direito);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public class ResultadoBusca {
        public boolean encontrado;
        public int profundidade;
        public List<Character> caminho;

        public ResultadoBusca(boolean encontrado, int profundidade, List<Character> caminho) {
            this.encontrado = encontrado;
            this.profundidade = profundidade;
            this.caminho = caminho;
        }
    }

    // public void imprimir() {
    //     imprimirRecursivo(raiz);
    // }

    // private void imprimirRecursivo(No no) {
    //     if (no != null) {
    //         imprimirRecursivo(no.esquerdo);
    //         System.out.print(no.valor + " ");
    //         imprimirRecursivo(no.direito);
    //     }
    // }
}
