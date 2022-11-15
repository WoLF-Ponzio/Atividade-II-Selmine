import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Formatter.*;


public class Metodos {
	
	Produto[] produto = new Produto[10];
	
	public void criar() {
		for(int i = 0; i < produto.length; i++) {
			produto[i] = new Produto();
		}
	}
	
	public void cadastro() {
	Scanner teclado = new Scanner(System.in);
		int aux = 0;
		
		for(int i = 0; i < produto.length; i++) {
			if(!produto[i].nome.equals("")) {
				aux++;
			if(aux == produto.length) {
				JOptionPane.showMessageDialog(null, "Sistema cheio! Caso deseje adicionar um novo produto, exclua um existente e tente novamente!");
				return;
			}
				
			}else {
				System.out.println("Código do Produto: " + (i+1));
				System.out.print("Digite o nome do produto a cadastrar: ");
				produto[i].nome = teclado.nextLine();
				System.out.print("Digite o valor unitário do Produto em R$: ");
				produto[i].valor = teclado.nextDouble();
				System.out.print("Digite a quantidade em estoque: ");
				produto[i].quantidade = teclado.nextInt();
				System.out.println("Caso a caixa de confirmação não apareça, minimizar o (Eclipse/programa)");
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
				System.out.println();
				return;
			}
		}
	}
	
	public void consulta() {
		Scanner teclado = new Scanner(System.in);
		String aux;
		int aux2 = 0;
		for(int x = 0; x < 1;) {
			System.out.println("Sistema de consulta");
			System.out.print("Digite o nome do produto que deseja consultar (Obs: o nome deve ser igual ao cadastrado): ");
			aux = teclado.nextLine();
				for(int i = 0; i < produto.length; i++) {
				if(produto[i].nome.equals(aux)) {
					JOptionPane.showMessageDialog(null, "Produto encontrado!");
					System.out.println("Código do Produto: " + (i+1));
					System.out.println("Nome do Produto: " + produto[i].nome);
					System.out.println("Valor unitário do Produto: R$ " + String.format("%.2f", produto[i].valor));
					System.out.println("Quantidade disponível em estoque: " + produto[i].quantidade);
					System.out.println();
					return;
					
				}else {
					aux2++;
				}
				
				if(aux2 == 10){
						int botao = JOptionPane.YES_NO_OPTION;
						int teste = JOptionPane.showConfirmDialog(null, "Produto não encontrado! Deseja tentar novamente?","Atenção",botao);
						if(teste == JOptionPane.NO_OPTION) {
							System.out.println("\n");
							x = 2;
							return;
						
						}else  {
						System.out.println("Reiniciando");
						System.out.println("\n");
						}
					}
				
				}
				
			}
	}
	
	public void lista() {
		int aux = 0;
		System.out.println("Listando todos os produtos!");
		for(int i = 0; i < produto.length; i++) {
			if(produto[i].nome.equals("")) {
				aux++;
			}else {
				System.out.println("Código do Produto: " + (i+1));
				System.out.println("Nome do Produto: " + produto[i].nome);
				System.out.println("Valor unitário do Produto: R$ " + String.format("%.2f", produto[i].valor));
				System.out.println("Quantidade disponível em estoque: " + produto[i].quantidade);
				System.out.println();
			}
			if(aux == 10) {
				System.out.println("Não há produtos para listar!");
				System.out.println("Cadastre um produto na opção cadastro\n");
			}
		}
	}
	
	public void excluir() {
		Scanner teclado = new Scanner(System.in);
		String aux;
		int aux2 = 0, checador = 0;
		for(int i = 0; i < produto.length; i++) {
			if(produto[i].nome.equals("")) {
				checador++;
			}
		}
		if(checador == produto.length) {
		System.out.println("Não há produtos cadastrados para a exclusão!");
		return;
		}
		
		for(int x = 0; x < 1;) {
			System.out.println("Excuir Produto");
			System.out.print("Digite o nome do produto que deseja excluir (Obs: o nome deve ser igual ao cadastrado): ");
			aux = teclado.nextLine();
				for(int i = 0; i < produto.length; i++) {
				if(produto[i].nome.equals(aux)) {
					JOptionPane.showMessageDialog(null, "Produto encontrado!");
					int botao = JOptionPane.YES_NO_OPTION;
					int teste = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluír o Produto?","Atenção",botao);
					if(teste == JOptionPane.NO_OPTION) {
						System.out.println("\n");
						return;
					}else {
						produto[i].nome = "";
						produto[i].valor = 0;
						produto[i].quantidade = 0;
						return;
					}
				
				}else {
					aux2++;
				}
				
				if(aux2 == 10){
					int botao2 = JOptionPane.YES_NO_OPTION;
					int teste2 = JOptionPane.showConfirmDialog(null, "Produto não encontrado! Deseja tentar novamente?","Atenção",botao2);
						if(teste2 == JOptionPane.NO_OPTION) {
							System.out.println("\n");
							x = 2;
							return;
				
						}else  {
						System.out.println("Reiniciando");
						System.out.println("\n");
						
						}
				}
				
			}
		}
	}
}