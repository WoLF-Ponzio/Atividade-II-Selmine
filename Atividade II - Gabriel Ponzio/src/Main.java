import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	Metodos metodos = new Metodos();
	Scanner teclado = new Scanner(System.in);
	int aux;
		
	System.out.println("Sistema de Supermercado");
		metodos.criar();
		for(int i = 0; i < 1;) {
			System.out.println("Lista de Operações");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Consultar Produto");
			System.out.println("3 - Listar todos os Produto");
			System.out.println("4 - Excluir Produto");
			System.out.println("5 - Finalizar");
			System.out.print("Digite o número correspondente da operação desejada: ");
			
			do {
				aux = teclado.nextInt();
				System.out.println("\n");
				if(aux > 5 || aux < 1) {
				System.out.println("tente novamente");
				System.out.print("Digite o número correspondente da operação desejada: ");
				
				}
				
			}while(aux > 5 || aux < 1);
			
				if(aux == 1) {
					metodos.cadastro();
				}else if(aux == 2) {
					metodos.consulta();
				}else if(aux == 3){
					metodos.lista();
				}else if(aux == 4) {
					metodos.excluir();
				}else if(aux == 5) {
					System.out.println("Operação Encerrada!");
					i++;
				}
		}
	}
}

