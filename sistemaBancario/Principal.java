package sistemaBancario;
import java.util.*;

public class Principal {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<CCliente> clientes = new LinkedList<>();
        try 
        {
            System.out.println("Sistema bancario");
            System.out.println("Deseja fazer um cadastro?");
            System.out.println("0 - Nao\n1 - Sim");
            int leitor = sc.nextInt();
            String nome;
            String email;
            float limite;
            int opcao_conta;
            while (leitor != 0) 
            {
                System.out.println("Nome: ");
                nome = sc.next();
                System.out.println("Email: ");
                email = sc.next();
                CCliente cli = new CCliente();
                cli.setNome(nome);
                cli.seEmail(email);

                while (leitor != 0) 
                {
                    System.out.println("Escolha o tipo da conta");
                    System.out.println("1 - Conta corrente");
                    System.out.println("2 - Conta poupanca");
                    opcao_conta = sc.nextInt();
                    CConta c = null;
                    if (opcao_conta == 1) 
                    {
                        System.out.println("conta corrente");
                        System.out.println("Informe limite da conta:");
                        limite = sc.nextFloat();
                        c = new ContaCorrente(limite);        
                    } 
                    else if (opcao_conta == 2) 
                    {
                        System.out.println("Conta poupanca");
                        c = new ContaPoupanca();
                    } 
                    
                    cli.incluirConta(c);
                    
                    System.out.println("Deseja depositar quanto?");
            		float valor_deposito = sc.nextFloat();
            		c.depositar(valor_deposito);
                   
                    System.out.println("Deseja criar outra conta para " + cli.getNome() + " ?");
                    System.out.println("0 - Nao\n1 - Sim");
                    leitor = sc.nextInt();
                }
                clientes.add(cli);
                System.out.println("Sistema bancario");
                System.out.println("Desejas fazer um novo cadastro?");
                System.out.println("0 - Nao\n1 - Sim");
                leitor = sc.nextInt();
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        Iterator it = clientes.iterator();
        while (it.hasNext()) 
        {
            CCliente c = (CCliente) it.next();
            System.out.println("Nome: " + c.getNome());
            System.out.println("Saldo: " + c.getSaldoGeral());
        }
        System.out.println("Programa encerrado.");
    }
}