public class gerenciaConta {
	
	private int conta;
	private int agencia;
	private int codigoConta; //0-corrente 1-popupança 2-corrente/poupança 3-salário
	private String dataCriacao;
	private double saldo;
	private String codClienteAssociado;
	
	//Criar uma nova conta
	public gerenciaConta(int conta, int agencia, int codigoConta, String dataCriacao, double saldo, String codClienteAssociado) {
		this.conta = conta;
		this.agencia = agencia;
		this.codigoConta = codigoConta;
		this.dataCriacao = dataCriacao;
		this.saldo = saldo;
		this.codClienteAssociado = codClienteAssociado;
	}
	
	String novaLinha = System.getProperty("line.separator");
	
	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getCodigoConta() {
		return codigoConta;
	}

	public void setCodigoConta(int codigoConta) {
		this.codigoConta = codigoConta;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCodClienteAssociado() {
		return codClienteAssociado;
	}

	public void setCodClienteAssociado(String codClienteAssociado) {
		this.codClienteAssociado = codClienteAssociado;
	}
	
	//Retorna dados completos da conta
	public void consultaConta() {	
		System.out.println("Conta: " + this.conta + novaLinha + "Agência: " + this.agencia + novaLinha +
				"Data da conta: " + this.dataCriacao + novaLinha + "Saldo: R$" + this.saldo);				
	}
	
	//Retorna somente o saldo da conta
	public void consultaSaldo() {	
		System.out.println("Saldo: R$" + this.saldo);		
	}

	//Saque
	public void realizarSaque(double valorSaque) {		
		if (saldo > 0 && saldo >= valorSaque) {
			this.saldo = saldo - valorSaque;
			System.out.println("Saque de R$" + valorSaque + " realizado com sucesso.");
			System.out.println("Novo saldo: R$" + this.saldo);
		} else {
			System.out.println("Saldo insuficiente!");
		}		
	}
	
	//Deposito
	public void realizarDeposito(double valorDeposito) {		
		if (valorDeposito > 0) {
			this.saldo = saldo + valorDeposito;
			System.out.println("Deposito realizado com sucesso. Novo saldo R$" + this.saldo);
		} else {
			System.out.println("Valor inválido!");
		}
	}
	}
	
}
