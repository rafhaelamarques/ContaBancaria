//cadastra um cliente e também consulta suas informações
public class cadastroCliente {
	
	private int codigo;
	private String nome;
	private String CPF;
	private String contato;
	private String endereco;
	
	public cadastroCliente(int codigo, String nome, String CPF, String contato, String endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.CPF = CPF;
		this.contato = contato;
		this.endereco = endereco;
	}
	
	String novaLinha = System.getProperty("line.separator");
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void consultaCliente() {
		System.out.println("Código Cliente: " + this.codigo + novaLinha + "Nome: " + this.nome + 
				novaLinha + "CPF: " + this.CPF + novaLinha + "Endereço: " + this.endereco);
	}
}
