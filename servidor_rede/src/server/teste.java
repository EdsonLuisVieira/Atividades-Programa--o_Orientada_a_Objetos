package server;

import java.util.*;
import java.time.*;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList <servidor_rede> user = new ArrayList <servidor_rede>();
		int x;
		do{
			menu();
			x =lerinteiro();
	    
			if (x==1){
				do{
				
					System.out.printf("Digite o codigo de identificação:");
					String code=lerstring();
					System.out.printf("Digite a marca do servidor:");
					String marca=lerstring();
					LocalDate data = lerdata();
					System.out.printf("Digite o nome do funcionario que realizou a compra:");
					String nome=lerstring();
					System.out.printf("Digite o cpf do funcionario que realizou a compra:");
					String cpf=lerstring();
					System.out.printf("Digite a função do funcionario que realizou a compra:");
					String funcao=lerstring();
					responsavel resp =new responsavel(cpf,nome,funcao);
					servidor_rede var = new servidor_rede(code,marca,data,resp);
					user.add(var);
					System.out.printf("\nDeseja realizar novo cadastro? ");
					String abort = lerstring();
					if (!(abort.equals("sim"))||!(abort.equals("sim"))){
						break;
					}
				}while(true);
				
			}else if (x==2){
				int controle = 0;
				for(servidor_rede var: user){
					System.out.printf(" "+var.toString());
					controle++;
				}
				if (controle ==0){
					System.out.println("\nNenhuma informação cadastrada\n");
				}
				
			}else if (x==3){
				int controle=0;
				System.out.printf("Digite o codigo de identificação do cadastro :");
				String codigo=lerstring();
				for(servidor_rede var: user){
					if (codigo.equals(var.getcod_Identificacao())){
						System.out.printf(" "+var.toString());
						controle++;
					}
				}
				if (controle ==0){
					System.out.println("\nNenhuma informação com esse codigo cadastrada\n");
				}
			}else if (x==4){
				int controle=0;
				System.out.printf("Digite o codigo de identificação do cadastro: ");
				String codigo=lerstring();
				for(servidor_rede var: user){
					if (codigo.equals(var.getcod_Identificacao())){
						System.out.printf("Digite o novo codigo de identificação:");
						String code=lerstring();
						System.out.printf("Digite a marca do servidor:");
						String marca=lerstring();
						LocalDate data = lerdata();
						System.out.printf("Digite o nome do funcionario que realizou a compra :");
						String nome=lerstring();
						System.out.printf("Digite o cpf do funcionario que realizou a compra:");
						String cpf=lerstring();
						System.out.printf("Digite a função do funcionario que realizou a compra:");
						String funcao=lerstring();
						responsavel resp =new responsavel(cpf,nome,funcao);
						var.set_Tudo(code,marca,data,resp);
						controle++;
						System.out.println("\n##Alteração realizada com sucesso###");
					}
				}
				if (controle ==0){
					System.out.println("\nNenhuma informação com esse codigo cadastrada\n");
				}
			}else if(x==5){
				int controle=0;
				System.out.printf("Digite o codigo de identificação do cadastro ");
				String codigo=lerstring();
				for(servidor_rede var: user){
					if (codigo.equals(var.getcod_Identificacao())){
						System.out.println("Tempo de aquisição deste servidor[em dias]: "+var.conta_Dias());
						controle++;
					}
				}
				if (controle ==0){
					System.out.println("\nNenhuma informação com esse codigo cadastrada\n");
				}
			
			}else if (x==6){
				int controle=0;
				System.out.printf("Digite o codigo de identificação do cadastro para realizar remoção: ");
				String codigo=lerstring();
				for(servidor_rede var: user){
					if (codigo.equals(var.getcod_Identificacao())){
						user.remove(var);
						System.out.println("Cadastro removido com Sucesso");
						controle++;
						break;
					}
				}
				if (controle==0){
					System.out.println("\nNenhuma informação com esse codigo cadastrada\n");
				}
			
			}else if (x==7){
				break;
			}else{
				System.out.println("Opção invalida digite um valor entre 1 e 7");
			}			
		}while(true);	
	}
	

	private static void menu (){
		 System.out.println("\n--------Cadastro de Servidor-------");
		 System.out.println("1 - Armazenar Dados");
		 System.out.println("2 - Exibir todos os dados");
		 System.out.println("3 - Exibir apenas um cadastro");
		 System.out.println("4 - Alterar um cadastro");
		 System.out.println("5 - Tempo de compra de um servidor[em dias]");
		 System.out.println("6 - Remover um cadastro");
		 System.out.println("7 - Encerrar Aplicação");
		 System.out.printf("Opção:");
       }
	
	 /**
	  * Função que le um inteiro com tratamento
	  * @return retorna o inteiro que foi lido
	  */
	
	 private static int lerinteiro(){
	    	Scanner scan= new Scanner (System.in);
	    	while(!scan.hasNextInt()){
			     scan.nextLine();
			     System.out.println("Valor invalido, digite um valor inteiro");	
			}
				int inteiro = scan.nextInt();
		return (inteiro);
		}
	 
	 /**
	  * Função que le uma string com tratamento
	  * @return retorna a string que foi lida
	  */
	 
	 private static String lerstring(){
	    	Scanner scan= new Scanner (System.in);
			while(!scan.hasNextLine()){
			     scan.nextLine();
			     System.out.println("Valor invalido");	
			}
			String string= scan.nextLine();
		return (string);
		}
	 
	 /**
	  * Função que lê tres valores inteiros e transforma em um tipo LocalDate
	  *
	  * @return Um valor do tipo LocalDate
	  */
	 private static LocalDate lerdata(){
		 System.out.printf("Digite o dia da compra[aa]:");
			int dia =lerinteiro();
			System.out.printf("Digite o mês da compra[mm]:");
			int mes =lerinteiro();
			System.out.printf("Digite o ano da compra[aaaa]:");
			int ano =lerinteiro();
			LocalDate data = LocalDate.of(ano, mes, dia);		 
		 return data;
	 }

}
