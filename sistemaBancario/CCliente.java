package sistemaBancario;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CCliente 
{
	private String Nome=null;
	private String Email=null;
	List<CConta> lista_contas = new LinkedList<CConta>();
	
    CCliente() 
    {
		Nome = "";
		Email = "";
	}

	CCliente(String n, String t) 
    {
		this.Nome = n;
		this.Email = t;
	}
	
	public void incluirConta(CConta tipo_conta) 
    {		
		lista_contas.add(tipo_conta);
	}
	
	public double getSaldoGeral() 
    {
		Iterator it = lista_contas.iterator();
		float soma_saldo=0;
		while (it.hasNext()) 
	    {
	            CConta c = (CConta) it.next();
	            soma_saldo = soma_saldo + c.getSaldo();
	    }
		return soma_saldo;
	}
	
	public void setNome(String nome) 
    {
		this.Nome = nome;
	}

	public void seEmail(String Email) 
    {
		this.Email = Email;
	}

	public String getNome() 
    {
		return Nome;
	}

	public String getEmail() 
    {
		return Email;
	}
}