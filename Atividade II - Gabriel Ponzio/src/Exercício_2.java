import java.util.Scanner;
import java.util.Random;
public class Exerc�cio_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[]numero = new int[10];
		int valor;
	
		System.out.println("Gerador e Ordenador de n�meros");
		preencher(numero);
		imprimir(numero);
		ordenar(numero);
		System.out.println("\n N�mero Ordenado");
		imprimir(numero);
		System.out.print("\nDigite um valor para busca: ");
		valor = teclado.nextInt();
		checagem(numero, valor);
	}

	public static void preencher(int[]numero) {
		Random gerador = new Random();
		int checador;
		
		for(int i = 0; i < numero.length; i++){
            checador = gerador.nextInt(0,101);
            for(int j = 0; j < numero.length; j++){
                  if(checador == numero[j] && j != i){
                        checador = gerador.nextInt(0,101);
                  }else{
                       numero[i] = checador;
                  }
            }
       }
		
	}
	
	public static void imprimir(int[]numero) {
		
		for(int i = 0; i < numero.length; i++) {
			System.out.print(numero[i] + "\t");
		}
	}
	
	public static void ordenar(int[]numero) {
		  for (int i = 0; i < numero.length - 1; i++)
		    for (int j = 0; j < numero.length - i - 1; j++)
		      if (numero[j] > numero[j + 1]) {
		        int aux = numero[j];
		        numero[j] = numero[j + 1];
		        numero[j + 1] = aux;
		      }
		
	}
	
	public static void checagem(int[]numero, int valor) {
		int aux, indice;
		boolean teste = false;
		indice = (numero.length/2) - 1;
		aux = (numero[indice]);
		if(valor == aux) {
			teste = true;
			System.out.println(teste + ", o n�mero est� na " + (indice + 1) + "� posi��o");
		}else {
			if(valor > aux){
				for(int i = (indice+1); i < numero.length; i++) {
					if(numero[i] == valor) {
						teste = true;
						System.out.println(teste + ", o n�mero est� na " + (i + 1) + "� posi��o");
						return;
					}else {
						teste = false;
					}
				}
					if(teste == false) {
						System.out.println(teste + ", o n�mero n�o se encontra na lista");
					}
					
			}else if(valor < aux){
				for(int i = (indice-1); i > -1; i--) {
					if(numero[i] == valor) {
						teste = true;
						System.out.println(teste + ", o n�mero est� na " + (i + 1) + "� posi��o");
					}else {
						teste = false;
					}
				}
				if(teste == false) {
					System.out.println(teste + ", o n�mero n�o se encontra na lista");
				}
			}
		}
	}

}
