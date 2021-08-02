package SistemaBiblioteca;
//DAVI COSTA BARROSO
import java.util.Scanner;

public class Biblioteca {
	static Scanner scan = new Scanner(System.in);
	Livros[] livros = new Livros[100];
	int tam;

	public int tamanho() {
		return tam;
	}

	public void cadastrar() {
		int i;

		System.out.println("Digite titulo: ");
		String titulo = scan.nextLine();

		System.out.println("Digite autor: ");
		String autor = scan.nextLine();

		System.out.println("Digite ano: ");
		int ano = scan.nextInt();
		scan.nextLine();

		System.out.println("Digite ISBN: ");
		int isbn = scan.nextInt();
		scan.nextLine();

		System.out.println("Digite editora: ");
		String editora = scan.nextLine();

		for (i = 0; i < livros.length; i++) {
			if (livros[i] == null) {
				livros[i] = new Livros(titulo, autor, ano, isbn, editora);
				tam++;
				break;
			}
		}
	}

	public void removerLivro() {
		System.out.println("-----REMOVER LIVRO-----\n");
		int indice;

		System.out.println("Digite indice do livro para remover: ");
		indice = scan.nextInt();
		scan.nextLine();

		if (livros[indice] != null && livros[indice].isEmprestado() == false) {
			System.out.println("\nLivro removido!\n");
			livros[indice] = null;
			tam--;
		} else {
			System.out.println("\nNão foi possivel remover livro!\n");
		}
	}

	public void emprestar() {
		System.out.println("-----EMPRESTAR LIVRO-----\n");
		int indice;

		System.out.println("Digite indice do livro para emprestar: ");
		indice = scan.nextInt();
		scan.nextLine();

		if (livros[indice] != null && livros[indice].isEmprestado() == false) {
			System.out.println("\nLivro emprestado!\n");
			livros[indice].emprestar();
		} else {
			System.out.println("\nNão foi possivel emprestar livro!\n");
		}
	}

	public void devolver() {
		System.out.println("-----DEVOLVER LIVRO-----\n");
		int indice;

		System.out.println("Digite indice do livro para devolver: ");
		indice = scan.nextInt();
		scan.nextLine();

		if (livros[indice] != null && livros[indice].isEmprestado() == true) {
			System.out.println("\nLivro devolvido!\n");
			livros[indice].devolver();
		} else {
			System.out.println("\nNão foi possivel devolver livro!\n");
		}
	}

	public void listarEmprestados() {
		int i;
		System.out.println("-----LIVROS EMPRESTADOS-----\n");

		for (i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].isEmprestado() == true)) {
				System.out.println("\nINDICE:" + i);
				System.out.println("Titulo: " + livros[i].getTitulo());
				System.out.println("Autor: " + livros[i].getAutor());
				System.out.println("Ano:" + livros[i].getAno());
				System.out.println("ISBN:" + livros[i].getIsbn());
				System.out.println("Editora: " + livros[i].getEditora());
			}
		}
	}

	public void listarDisponiveis() {
		int i;
		System.out.println("-----LIVROS DISPONIVEIS-----\n");
		for (i = 0; i < livros.length; i++) {
			if ((livros[i] != null) && (livros[i].isEmprestado() == false)) {
				System.out.println("\nINDICE:" + i);
				System.out.println("Titulo: " + livros[i].getTitulo());
				System.out.println("Autor: " + livros[i].getAutor());
				System.out.println("Ano:" + livros[i].getAno());
				System.out.println("ISBN:" + livros[i].getIsbn());
				System.out.println("Editora: " + livros[i].getEditora());
			}
		}
	}

}
