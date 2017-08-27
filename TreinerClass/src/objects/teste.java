package objects;

import java.util.*;
import java.time.*;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LerVariaveis var= new LerVariaveis();
		
		int x=var.lerinteiro();
		LocalDate time=var.lerdata();
		System.out.println(""+x);
		System.out.println(""+time);
		
		
		
		
		
		
		
		
		
		
		/**int cont =0;
		String teste2 ="";
		String Aux2="";
	    String aux="miguel rodrigo belarmmmino da cabral";
	    StringTokenizer teste = new StringTokenizer(aux," ");
	    while(teste.hasMoreTokens()){       
	    	teste2 = teste.nextToken();
	    	if (cont==0)
	    		Aux2=Aux2.concat(", "+teste2.substring(0, 1));
	    	else
	    	    Aux2=Aux2.concat(". "+teste2.substring(0, 1));
	        cont++;
	    }
	    int tam=Aux2.length();
	    Aux2=Aux2.substring(0,tam-1);
	    String concli =teste2.concat(""+Aux2);
	    System.out.println(concli);
	
		

		
		
		
		Scanner scan= new Scanner (System.in);

		menu();
		
		System.out.printf("digite um valor:");
		int x=lerinteiro();
        if (x==1){
        	System.out.printf("Digite o nome:");
    		String nome=scan.nextLine();
    		System.out.printf("Digite o cpf:");
    		String cpf=scan.nextLine();
    		System.out.printf("Digite o endereço:");
    		String endereco=scan.nextLine();
        
		classecliente cliente1 = new classecliente(cpf,nome,endereco);
		System.out.printf(""+cliente1.toString());
        }
		
		
	}

	   public static int lerinteiro(){
	    	Scanner scan= new Scanner (System.in);
	    	while(!scan.hasNextInt()){
			     scan.nextLine();
			     System.out.println("Valor invalido, digite um valor inteiro");	
			}
				int inteiro = scan.nextInt();
		return (inteiro);
		}

	   

       public static void menu (){
    	   System.out.println("");
			System.out.println("---------------------opções-------------------------");
			System.out.println("1 - armazenar os dados");
			System.out.println("2 - exibir todos os dados");
			System.out.println("3 - exibir apenas um campo");
			System.out.println("4 - alterar um campo");
       }*/

	}
}
 	

