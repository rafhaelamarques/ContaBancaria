import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class submenuCliente {

	private static int input;
	
	@SuppressWarnings("resource")
	static Scanner scan = new Scanner(System.in);
	
	static BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); 
	
	static Random codRandom = new Random();
	
	protected static int codCliente;
	protected static String nomeCliente;
	protected static String cpfCliente;
	protected static String contatoCliente;
	protected static String enderecoCliente;
	
	protected static String novoNome = null;
	protected static String novoCpf = null;
	protected static String novoContato = null;
	protected static String novoEndereco = null;
	
	public static cadastroCliente cliente = null;
	
	public static List<cadastroCliente> listaCliente = new ArrayList<cadastroCliente>();
	
	protected static int itemConsulta;
	
	protected static int aux;
	protected static int auxAtualizar;
	
	public static void menuCliente() throws IOException {
		
		do {
			
			@SuppressWarnings("resource")
			Scanner tecla = new Scanner(System.in);
			
			System.out.println("|-------------------------------------|");
			System.out.println("|      TECLA        OPERAÇÃO          |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        1      CADASTRAR CLIENTE     |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        2      CONSULTAR CLIENTE     |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        3      REMOVER CLIENTE       |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        4      ATUALIZAR CLIENTE     |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        5      VOLTAR MENU INICIAL   |");
			System.out.println("|-------------------------------------|");
			
			System.out.println("Escolha uma opção: ");
			input = tecla.nextInt();	
			
			if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
				System.out.println("Opção inválida! Digite uma opção do menu.");
				System.in.read();	
			}
		} while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5);
		
		switch(input) {
		
		case 1:		
			cliente = new cadastroCliente(codCliente, nomeCliente, cpfCliente, contatoCliente, enderecoCliente);
			codCliente = 1000 + codRandom.nextInt(9000); 
			cliente.setCodigo(codCliente);
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = read.readLine();
			cliente.setNome(nomeCliente);
			System.out.println("Digite o CPF do cliente: ");
			cpfCliente = read.readLine();
			cliente.setCPF(cpfCliente);
			System.out.println("Digite o contato do cliente: ");
			contatoCliente = read.readLine();
			cliente.setContato(contatoCliente);
			System.out.println("Digite o endereço do cliente: ");
			enderecoCliente = read.readLine();
			cliente.setEndereco(enderecoCliente);
			
			listaCliente.add(cliente);
			System.out.println("Cliente " + codCliente + " cadastrado com sucesso.");
			System.in.read();	
			submenuCliente.menuCliente();
			break;
			
		case 2:
  			System.out.println("Digite o código do cliente que deseja consultar: ");
			itemConsulta = scan.nextInt();
			
			for(cadastroCliente cliente : listaCliente) {
				if (listaCliente != null && cliente.getCodigo() == itemConsulta) {
					aux = listaCliente.indexOf(cliente);
					listaCliente.get(aux).consultaCliente();
				}
					else {
						System.out.println("Cliente não encontrado!");
					}
			}
			System.in.read();
			submenuCliente.menuCliente();
			break;
			
		case 3:
			System.out.println("Digite o código do cliente que deseja remover: ");
			itemConsulta = scan.nextInt();
			
			for(cadastroCliente cliente : listaCliente) {
				if(listaCliente != null && cliente.getCodigo() == itemConsulta) {
					aux = listaCliente.indexOf(cliente);
					listaCliente.remove(aux);
					System.out.println("Cliente " + itemConsulta + " removido do sistema com suscesso!");
				} else {
					System.out.println("Cliente não encontrado!");
				}
			}
			System.in.read();
			submenuCliente.menuCliente();
			break;
			
		case 4:
			System.out.println("Digite o código do cliente que deseja atualizar: ");
			itemConsulta = scan.nextInt();
			
			for(cadastroCliente cliente : listaCliente) {
				if(listaCliente != null && cliente.getCodigo() == itemConsulta) {
					aux = listaCliente.indexOf(cliente);
					System.out.println("Cliente selecionado: ");
					listaCliente.get(aux).consultaCliente();
					
					do {
						
						System.out.println("Qual item deseja atualizar? (1-Nome / 2-CPF / 3-Contato / 4-Endereço)");
						auxAtualizar = scan.nextInt();
						
						if(auxAtualizar == 1) {
							System.out.println("Digite o novo nome: ");
							novoNome = read.readLine();
							cliente.setNome(novoNome);
							System.out.println("Cliente atualizado!");
							listaCliente.get(aux).consultaCliente();
						}
						else if (auxAtualizar == 2) {
							System.out.println("Digite o novo CPF: ");
							novoCpf = read.readLine();
							cliente.setCPF(novoCpf);
							System.out.println("Cliente atualizado!");
							listaCliente.get(aux).consultaCliente();
						}
						else if (auxAtualizar == 3) {
							System.out.println("Digite o novo contato: ");
							novoContato = read.readLine();
							cliente.setCPF(novoContato);
							System.out.println("Cliente atualizado!");
							listaCliente.get(aux).consultaCliente();
						}
						else if (auxAtualizar == 4) {
							System.out.println("Digite o novo endereço: ");
							novoEndereco = read.readLine();
							cliente.setCPF(novoEndereco);
							System.out.println("Cliente atualizado!");
							listaCliente.get(aux).consultaCliente();
						} 
						if (auxAtualizar != 1 && auxAtualizar != 2 && auxAtualizar != 3 && auxAtualizar != 4) {
							System.out.println("Opção inválida! Digite uma opção válida.");
							System.in.read();	
						}
					} while (auxAtualizar != 1 && auxAtualizar != 2 && auxAtualizar != 3 && auxAtualizar != 4);
				} else {
					System.out.println("Cliente não encontrado!");
				}		
			}
			System.in.read();
			submenuCliente.menuCliente();
			break;			
		case 5:
			MENU.menuOperacao();
			}
	}
}
