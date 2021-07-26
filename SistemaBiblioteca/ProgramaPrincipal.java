package SistemaBiblioteca;

import java.util.Scanner;

public class ProgramaPrincipal {
	static Scanner scan = new Scanner(System.in);

	public static void menu() {
		System.out.println("-----MENU-----");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Remover");
		System.out.println("3 - Emprestar");
		System.out.println("4 - Devolver");
		System.out.println("5 - Listar emprestados");
		System.out.println("6 - Listar dispiniveis");
		System.out.println("7 - Encerrar programa");
		System.out.println("--------------");
	}

	public static void main(String[] args) {
		Biblioteca biblioteca1 = new Biblioteca();
		int opcao = 0;
		boolean vazio = true;
		while (opcao != 7) {
			menu();
			System.out.println("Opção:");
			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {
			case 1:
				vazio = biblioteca1.verificaArmazenamento();
				if (vazio) {
					biblioteca1.cadastrar();
				} else {
					System.out.println("Biblioteca cheia");
				}
				break;
			case 2:
				biblioteca1.removerLivro();
				break;
			case 3:
				biblioteca1.emprestar();
				break;
			case 4:
				biblioteca1.devolver();
				break;
			case 5:
				biblioteca1.listarEmprestados();
				break;
			case 6:
				biblioteca1.listarDisponiveis();
				break;
			}
		}
		System.out.println("\n-----PROGRAMA ENCERRADO-----");
		scan.close();
	}
}