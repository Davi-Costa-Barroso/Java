package SistemaBiblioteca;
//DAVI COSTA BARROSO
public class Livros {
	private String titulo = null;
	private String autor = null;
	private int ano;
	private int isbn;
	private String editora = null;
	private boolean emprestado = false;

	public Livros(String titulo, String autor, int ano, int isbn, String editora) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.isbn = isbn;
		this.editora = editora;
	}

	public void emprestar() {
		this.emprestado = true;
	}

	public void devolver() {
		this.emprestado = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
}
