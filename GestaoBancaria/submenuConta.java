import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

public class submenuConta {
	
	private static int input;
	
	@SuppressWarnings("resource")
	static Scanner scan = new Scanner(System.in);
	
	static BufferedReader read = new BufferedReader(new InputStreamReader(System.in)); 

	static Random numRandom = new Random();
	
	static LocalDateTime dataAtual = LocalDateTime.now(); 
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	protected static int numConta;
	protected static int numAgencia;
	protected static int codConta;
	protected static String dataConta;
	protected static double saldoConta;
	protected static String codClienteConta;
	
	protected static int aux;
	protected static int aux2;
	protected static int auxConta;
	protected static int auxAgencia;
	protected static double auxSacar;
	protected static double auxDepositar;
	
	protected static int auxConta2;
	protected static int auxAgencia2;
	protected static double auxTransferir;
	
	protected static boolean found = false;
	protected static boolean found2 = false;
	
	public final static List<gerenciaConta> listaConta = new ArrayList<gerenciaConta>();
	
	public static gerenciaConta contaCadastrada = null;
	public static gerenciaConta contaCadastrada2 = null;
	
	public static void menuConta() throws IOException {
		
		do {
			
			@SuppressWarnings("resource")
			Scanner tecla = new Scanner(System.in);
			
			System.out.println("|-------------------------------------|");
			System.out.println("|      TECLA        OPERAÇÃO          |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        1         CRIAR CONTA        |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        2        SACAR DINHEIRO      |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        3      DEPOSITAR DINHEIRO    |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        4       VERIFICAR SALDO      |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        5      TRANSFERIR DINHEIRO   |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        6      VOLTAR MENU INICIAL   |");
			System.out.println("|-------------------------------------|");
			
			System.out.println("Escolha uma opção: ");
			input = tecla.nextInt();	
			
			if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6) {
				System.out.println("Opção inválida! Digite uma opção do menu.");
				System.in.read();	
			}
		} while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6);
		
		switch(input) {
		
		//Cria a conta e a armazena numa lista temporaria
		case 1:
			contaCadastrada = new gerenciaConta(numConta, numAgencia, codConta, dataConta, saldoConta, codClienteConta);
			numConta = 100000 + numRandom.nextInt(900000);
			contaCadastrada.setConta(numConta);
			System.out.println("Digite a agência: ");
			numAgencia = scan.nextInt();
			contaCadastrada.setAgencia(numAgencia);
			System.out.println("Digite o código da conta (0-corrente 1-popupança 2-corrente/poupança 3-salário): ");
			codConta = scan.nextInt();
			contaCadastrada.setCodigoConta(codConta);
			contaCadastrada.setDataCriacao(formato.format(dataAtual));
			System.out.println("Digite o saldo inicial da conta: ");
			saldoConta = scan.nextDouble();
			contaCadastrada.setSaldo(saldoConta);
			System.out.println("Digite o código do cliente titular da conta: ");
			codClienteConta = read.readLine();
			contaCadastrada.setCodClienteAssociado(codClienteConta);
			
			contaCadastrada2 = contaCadastrada;
			listaConta.add(contaCadastrada);
			System.out.println("Conta " + numConta + " cadastrada com sucesso.");
			System.in.read();
			submenuConta.menuConta();
			break;
			
		//Valida se os dados inseridos são de uma conta existente e só então realiza a operação.
		//Caso não exista a conta, há a mensagem "conta não encontrada"		
		case 2:
			System.out.println("Digite a agência da conta: ");
			auxAgencia = scan.nextInt();
			System.out.println("Digite o número da conta: ");
			auxConta = scan.nextInt();
			
		for(gerenciaConta contaCadastrada : listaConta) {
			if(listaConta != null && contaCadastrada.getConta() == auxConta && contaCadastrada.getAgencia() == auxAgencia) {
				found = true;
			}
				if(found == true) {
					aux = listaConta.indexOf(contaCadastrada);
					System.out.println("Conta selecionada: ");
					listaConta.get(aux).consultaConta();					
					System.out.println("Digite o valor que deseja sacar: ");
					auxSacar = scan.nextDouble();
					listaConta.get(aux).realizarSaque(auxSacar);
				} else if(found == false) {
					System.out.println("Conta não encontrada!");
				}
				found = false;
			}
			
			System.in.read();
			submenuConta.menuConta();
			break;

		//Valida se os dados inseridos são de uma conta existente e só então realiza a operação.
		//Caso não exista a conta, há a mensagem "conta não encontrada"	
		case 3:
			System.out.println("Digite a agência da conta: ");
			auxAgencia = scan.nextInt();
			System.out.println("Digite o número da conta: ");
			auxConta = scan.nextInt();
			
			for(gerenciaConta contaCadastrada : listaConta) {
			if(listaConta != null && contaCadastrada.getConta() == auxConta && contaCadastrada.getAgencia() == auxAgencia) {
				found = true;
			}
				if(found == true) {
					aux = listaConta.indexOf(contaCadastrada);
					System.out.println("Conta selecionada: ");
					listaConta.get(aux).consultaConta();					
					System.out.println("Digite o valor que deseja depositar: ");
					auxDepositar = scan.nextDouble();
					listaConta.get(aux).realizarDeposito(auxDepositar);
				} else if(found == false) {
					System.out.println("Conta não encontrada!");
				}
				found = false;
			}	
			System.in.read();
			submenuConta.menuConta();
			break;
			
		//Valida se os dados inseridos são de uma conta existente e só então realiza a operação.
		//Caso não exista a conta, há a mensagem "conta não encontrada"		
		case 4:
			System.out.println("Digite a agência da conta: ");
			auxAgencia = scan.nextInt();
			System.out.println("Digite o número da conta: ");
			auxConta = scan.nextInt();
			
			for(gerenciaConta contaCadastrada : listaConta) {
				if(listaConta != null && contaCadastrada.getConta() == auxConta && contaCadastrada.getAgencia() == auxAgencia) {
					found = true;
				}
					if(found == true) {
						aux = listaConta.indexOf(contaCadastrada);
						listaConta.get(aux).consultaSaldo();		
					} else if(found == false) {
						System.out.println("Conta não encontrada!");
					}
					found = false;					
			}
			System.in.read();
			submenuConta.menuConta();
			break;
			
		//Pendente reescrita da lógica	
		case 5:
			System.out.println("Digite a agência da conta que irá realizar a transferência: ");
			auxAgencia = scan.nextInt();
			System.out.println("Digite o número da conta que irá realizar a transferência: ");
			auxConta = scan.nextInt();		
			for(gerenciaConta contaCadastrada : listaConta) {
				if(listaConta != null && contaCadastrada.getConta() == auxConta && contaCadastrada.getAgencia() == auxAgencia) {
					found = true;
					if(found == true) {
						aux = listaConta.indexOf(contaCadastrada);
						System.out.println("Dados da conta selecionada: ");
						listaConta.get(aux).consultaConta();		
					} else if(found == false) {
						System.out.println("Conta não encontrada!");
						}
				} 
			}
				
			if(found == true) {
				System.out.println("Digite a agência da conta que irá receber a transferência: ");
				auxAgencia2 = scan.nextInt();
				System.out.println("Digite o número da conta que irá receber a transferência: ");
				auxConta2 = scan.nextInt();	
				for(gerenciaConta contaCadastrada2 : listaConta) {
					if(contaCadastrada2.getConta() == auxConta2 && contaCadastrada2.getAgencia() == auxAgencia2) {
						found2 = true;
						if(found2 == true) {
							aux2 = listaConta.indexOf(contaCadastrada2);
							System.out.println("Conta selecionada: ");
							listaConta.get(aux2).consultaConta();
							System.out.println("Digite o valor que deseja transferir: ");
							auxTransferir = scan.nextDouble();
							if(saldoConta > 0 && saldoConta >= auxTransferir) {
								listaConta.get(aux).realizarTransferencia(auxTransferir);
								listaConta.get(aux2).recebeTransferencia(auxTransferir);
								System.out.println("Transferencia de R$" + auxTransferir + " realizada com sucesso!");	
								} else {
									System.out.println("Saldo insuficiente!");
								}
							} else if(found2 == false){
								System.out.println("Transferência não realizada!");
							}
					}
						
				}
			}							
			System.in.read();
			submenuConta.menuConta();
			break;
			
		case 6:
			MENU.menuOperacao();
		}
}
}
