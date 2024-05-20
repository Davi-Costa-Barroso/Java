public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        No raiz = new No('A');
        arvore.definirRaiz(raiz);

        // Lado do Nó B
        No noB = new No('B');
        No noC = new No('C');
        arvore.definirEsquerdo(raiz, noB);
        arvore.definirDireito(raiz, noC);

        No noD = new No('D');
        No noE = new No('E');
        arvore.definirEsquerdo(noB, noD);
        arvore.definirDireito(noB, noE);

        No noH = new No('H');
        No noI = new No('I');
        arvore.definirEsquerdo(noD, noH);
        arvore.definirEsquerdo(noD, noI);

        No noJ = new No('J');
        arvore.definirEsquerdo(noE, noJ);

        No noL = new No('L');
        arvore.definirEsquerdo(noJ, noL);

        // Lado do Nó C
        No noF = new No('F');
        No noG = new No('G');
        arvore.definirEsquerdo(noC, noF);
        arvore.definirDireito(noC, noG);

        No noK = new No('K');
        arvore.definirEsquerdo(noG, noK);

        System.out.println("Profundidade da árvore: " + arvore.calcularProfundidade());

        Arvore.ResultadoBusca resultado = arvore.buscaEmProfundidade('F');
        if (resultado.encontrado) {
            System.out.println("Valor encontrado na profundidade " + resultado.profundidade);
            System.out.println("Caminho: " + resultado.caminho);
        } else {
            System.out.println("Não encontrado.");
        }

        // System.out.print("Ordem:");
        // arvore.imprimir();
    }
}
