package sistemaBancario;
abstract class CConta {
    public abstract float getSaldo();
    public float saldo = 0;
    CConta()
    {
    	saldo = 0;
    }
    CConta(float saldo)
    {
	this.saldo = saldo;
    }

    public void depositar(float valor_depositado) 
    {
	this.saldo = saldo + valor_depositado;
    }
}

class ContaCorrente extends CConta{
    float limite;
    ContaCorrente(float limite)
    {
    	this.limite = limite;
    }
    public float getSaldo() 
    {
		try 
		{
			// 0.38 % de cpmf
			saldo = (saldo+limite) - ((saldo+limite)*0.0038f);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
        return saldo;
	}
}
class ContaPoupanca extends CConta {
    public float getSaldo() 
    {
	return saldo;	
    }
}