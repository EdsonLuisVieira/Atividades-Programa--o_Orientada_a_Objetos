package io;
/**
 * Classe que manipula leitura dos dados pelo Teclado
 * @author Edson Vieira
 * @author Miguel Cabral
 */
 
import java.util.Scanner;
/**
 * Classe que auxilia a leitura de dados pelo teclado
 * @author Edson Vieira
 * @author Miguel Cabral
 */
public class Ler {
	private static String regexip = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])$";
	private static String regexmk = "^(3[01]|2[0-4]|1[0-9]|[0-9])$";
	private static Scanner scan = new Scanner (System.in);
	
	
	/**
	  * Função que lê um inteiro com tratamento
	  * @return retorna o inteiro que foi lido.
	  */
	public static int inteiro() {
		while(!scan.hasNextInt()){
			scan.nextLine();
			System.out.println("Valor invalido, digite um valor inteiro");	
		}
		int i = scan.nextInt();
		scan.nextLine();
		return (i);
	}
	
	/**
	  * Função que lê uma string
	  * @return retorna a string que foi lida.
	  */
	public static String string(){
		/*while(!scan.hasNextLine()){
		     scan.nextLine();
		     System.out.println("Valor invalido");	
		}
		String string= scan.nextLine();*/
		return (scan.nextLine());
	}
	
	
	/**
	 *  Função que lê IP
	  * @return retorna o IP lido.
	 */
	public static String ip(){
		String ip;
		do {
			System.out.print("Digite o ip: ");
			ip = Ler.string();
		} while (! ip.matches(regexip) );
		return ip;
	}
	
	
	/**
	 *  Função que lê máscara da rede
	  * @return retorna a máscara lida.
	 */
	public static String mascara(){
		String mask;
		do {
			System.out.print("Digite a mascara da rede(CIDR): ");
			mask = Ler.string();
		} while (! mask.matches(regexmk) );
		return mask;
	}
}