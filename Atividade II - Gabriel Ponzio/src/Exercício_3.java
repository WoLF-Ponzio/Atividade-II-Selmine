import java.util.Scanner;
import java.util.Random;
public class Exercício_3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[]numero = new int[10];
		int valor;
		boolean check;
	
		System.out.println("Gerador e Ordenador de números");
		preencher(numero);
		imprimir(numero);
		ordenar(numero);
		System.out.println("\n Número Ordenado");
		imprimir(numero);
		System.out.print("\nDigite um valor para busca: ");
		valor = teclado.nextInt();
		check = checagem(numero, valor, 0, (numero.length-1));
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
	
	public static boolean checagem(int[] numero, int valor, int i, int max){
		boolean teste = false;
		int m = (i + max)/2;
		if(i == max) {
			if(numero[max] == valor) {
			teste = true;
			System.out.println(teste + ", o número está na " + (i + 1) + "º posição");
			return teste;
			}else if(teste == false){
				System.out.print(teste + ", o número não está contido na lista");
				return teste;
			}
		}
		if(numero[m] == valor) {
			teste = true;
			System.out.println(teste + ", o número está na " + (m+1) + "º posição"); 
			return teste;	
		}else if(valor > numero[m]) {
			if(numero[i] == valor) {
				teste = true;
				System.out.println(teste + ", o número está na " + (i + 1) + "º posição");
				return teste;
			}else {
				checagem(numero,valor,m+1,max);
			}
		}else {
			if(numero[i] == valor) {
				teste = true;
				System.out.println(teste + ", o número está na " + (i + 1) + "º posição");
				return teste;
			}else {
				checagem(numero,valor,i,m);
			}
		}
		
		 return teste;
	}
}	
