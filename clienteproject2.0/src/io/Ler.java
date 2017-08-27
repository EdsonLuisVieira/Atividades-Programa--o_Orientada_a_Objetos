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
	private static String regex = "^((25[0-5]|2[0-4]\\d|[01]\\d\\d)\\.){3}(25[0-5]|2[0-4]\\d|[01]\\d\\d)$";
	private static Scanner scan = new Scanner (System.in);
	
	
	 /**
	  * Fun��o que le um inteiro com tratamento
	  * @return retorna o inteiro que foi lido
	  */
	
	 public static int inteiro(){
	    //	Scanner scan= new Scanner (System.in);
	    	while(!scan.hasNextInt()){
			     scan.nextLine();
			     System.out.println("Valor invalido, digite um valor inteiro");	
			}
				int inteiro = scan.nextInt();
		return (inteiro);
		}
	 
	 /**
	  * Fun��o que le uma string com tratamento
	  * @return retorna a string que foi lida
	  */
	 
	 public static String string(){
	  //  	Scanner scan= new Scanner (System.in);
			while(!scan.hasNextLine()){
			     scan.nextLine();
			     System.out.println("Valor invalido");	
			}
			String string= scan.nextLine();
		return (string);
		}
	
	/**
	 *  Função que lê IP
	  * @return retorna o IP lido.
	 */
	public static String ip(){
		String ip;
		
			System.out.print("Digite o ip: ");
			ip = Ler.string();
		
		return ip;
	}
	
	
	/**
	 *  Função que lê máscara da rede
	  * @return retorna a máscara lida.
	 */
	public static String mascara(){
		System.out.print("Digite a mascar da rede: ");
		return (scan.nextLine());
	}
}