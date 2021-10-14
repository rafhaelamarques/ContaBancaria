import java.io.IOException;
import java.util.Scanner;

public class MENU {
	
	private static int input;

	public static void menuOperacao() throws IOException {
		
		@SuppressWarnings("resource")
		Scanner tecla = new Scanner(System.in);
		
		do {
			
			System.out.println("|-------------------------------------|");
			System.out.println("|      TECLA        OPERAÇÃO          |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        1     GERENCIAR CLIENTES     |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        2      GERENCIAR CONTAS      |");
			System.out.println("|-------------------------------------|");
			System.out.println("|        3            SAIR            |");
			System.out.println("|-------------------------------------|");
			
			System.out.println("Escolha uma opção: ");
			input = tecla.nextInt();	
			
			if (input != 1 && input != 2 && input != 3) {
				System.out.println("Opção inválida! Digite uma opção do menu.");
				System.in.read();	
			}
		} while(input != 1 && input != 2 && input != 3);
		
        switch (input) {
        
        case 1:
        	submenuCliente.menuCliente();
        	break;
        	
        case 2:
        	submenuConta.menuConta();
        	break;
        
        case 3:
        	System.exit(0);
        	break;
	}

}
}
