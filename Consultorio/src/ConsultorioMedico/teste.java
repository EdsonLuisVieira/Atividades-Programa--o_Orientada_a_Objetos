package ConsultorioMedico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ColecaoConsultas consultas =new ColecaoConsultas();
           ColecaoMedico medicos =new ColecaoMedico();
           ColecaoPaciente pacientes =new ColecaoPaciente();
          
           int options=0;                   		
           do{
        	menu();
           	options=lerinteiro();
           	
           	if (options==1){
           		
           		int var=0;                   		
           		do{
           			menupacientes();
           			var=lerinteiro();
           			if (var==1){
           				Paciente pacient=lerPaciente();
           				pacientes.adicionaPaciente(pacient);
           				
           			}
           			else if (var==2){
           				System.out.printf("Digite o CPF do paciente: ");
           				String cpf=lerstring();
           				try {
           					pacientes.removePeloDocumento(cpf);
           				}catch (Exception end){System.out.println(""+end.getMessage());}
           			}   
           			else if (var==3){
           				System.out.printf("Digite o CPF paciente: ");
           				String doc=lerstring();
           				try {
           					System.out.print("Paciente: "+pacientes.pesquisaPeloDocumento(doc));
           				}catch (Exception end){System.out.println(""+end.getMessage());}
           			}           
           			else if (var==4){
           				System.out.printf("Digite o sexo[masculino ou feminino]: ");
           				String sexo=lerstring();
           				if(sexo.equals("masculino")||sexo.equals("feminino")){
           					System.out.println("\nQuantidade de Pacientes com este sexo: "+pacientes.qtdPacientesPorSexo(sexo));
           				}
           				else{
           					System.out.println("sexo digitado invalido");
           				}
           			}
           			else if (var==5){
           				Endereco aux_end = lerEndereco();
           				try {
           					System.out.println("\nPacientes com este Endereco: \n"+pacientes.listagemPacientesComEndereco(aux_end));
           				}catch (Exception end){System.out.println(""+end.getMessage());}
           			}
           			else if (var==6){
           				try {
           					System.out.println("\nPacientes com mais de 60 anos: \n"+pacientes.listagemDePacienteM60Anos());
           				}catch (Exception end){System.out.println(""+end.getMessage());}
           			}
           			else if (var==7){
           				break;
           			}
           			else
           				System.out.println("Opção invalida");
           		}while(true);
           }else if (options==2){
        	   int x;
        	   do{
        		   menumedicos();
        		   x=lerinteiro();
        		   if(x==1){
        			   Medico doctor=lerMedico();
        			   medicos.adicionaMedico(doctor);
        		   }else if(x==2){
        			   System.out.printf("Digite o CRM: ");
        			   int crm=lerinteiro();
        			   try{
        				   medicos.removePeloCRM(crm);
        			   }catch(Exception end){System.out.println(""+end.getMessage());}
        		   }else if(x==3){
        			   System.out.printf("Digite o CRM: ");
        			   int crm=lerinteiro();
        			   try{
        				   System.out.println(""+medicos.pesquisaPCrm(crm));
        			   }catch(Exception end){System.out.println(""+end.getMessage());}
        		   }else if(x==4){
        			   System.out.printf("Digite o nome ou parte dele: ");
        			   String pnome=lerstring();
        			   try{
        				   System.out.println(""+medicos.pesquisaMedicoPParteNome(pnome));
        			   }catch(Exception end){System.out.println(""+end.getMessage());}	   
        		   }else if(x==5){
        			   break;
        		   }else{
        			   System.out.println("Digite uma opcao valida");
        		   }         			
           		}while(true);        	
           }else if (options==3){
        	    int x;
           		do{
           			menuconsultas();
           			x=lerinteiro();
           			if(x==1){
           				Paciente pacient=lerPaciente();
           				Medico doctor=lerMedico();
           				System.out.printf("Digite o dia de Consulta:");
           				int dia =lerinteiro();
           				System.out.printf("Digite o mês da Consulta:");
           				int mes =lerinteiro();
           				System.out.printf("Digite o ano da Consulta:");
           				int ano =lerinteiro();
           				LocalDate data = LocalDate.of(ano, mes, dia);	
           				LocalTime hora=lerHora();
           				Consulta consult =new Consulta(pacient,doctor,data,hora);
           				consultas.adicionaConsulta(consult);
           				
           			}else if(x==2){
           				try{
           				 System.out.println("----Consultas----");
           				 System.out.println(""+consultas.listagemConsultas());
           				}catch(Exception end){System.out.println(""+end.getMessage());}	   
           			}else if(x==3){
           				System.out.printf("Digite o dia de Consulta:");
           				int dia =lerinteiro();
           				System.out.printf("Digite o mês da Consulta:");
           				int mes =lerinteiro();
           				System.out.printf("Digite o ano da Consulta:");
           				int ano =lerinteiro();
           				LocalDate data = LocalDate.of(ano, mes, dia);
           				 System.out.println("Quantidade de Consultas por data:"+consultas.qtdConsultaData(data));
           			}else if(x==4){
           				Medico medico=lerMedico();
          				 System.out.println("Quantidade de Consultas deste Medico:"+consultas.qtdConsultasPMedico(medico));
           			}else if(x==5){
           				Paciente paciente=lerPaciente();
           				try{
           					System.out.println("Consultas Deste Paciente: "+consultas.listaConsultasPPaciente(paciente));
           				}catch(Exception end){System.out.println(""+end.getMessage());};
           			}else if(x==6){
           				break;
           			}else{
           				System.out.println("Digite uma Opcao valida");
           			}				
           		}while(true);
           }else if (options==4)
           		break;
           	else
           		System.out.println("Opção invalida");
           }while(true);

	}
	
	private static void menu(){
		System.out.println("\n----------Consultorio Medico-----------\n");
		System.out.println("1- Cadastro de Pacientes");
		System.out.println("2- Cadastro de Medicos");
		System.out.println("3- Cadastro de Consultas ");
		System.out.println("4- sair");
		System.out.printf("opcao:");
        
	}
	
	
	private static void menupacientes(){
		System.out.println("\n----------Menu Pacientes-----------\n");
		System.out.println("1- Adicionar Pacientes");
		System.out.println("2- Remover Paciente por documento");
		System.out.println("3- Pesquisar Paciente por Documento ");
		System.out.println("4- Quantidade de pacientes por sexo");
		System.out.println("5- Listar Pacientes por endereco");
		System.out.println("6- Listar Pacientes com mais de 60 anos");
		System.out.println("7- sair");
		System.out.printf("opcao:");
		
	}
	
	private static void menumedicos(){
		System.out.println("\n----------Menu Medicos-----------\n");
		System.out.println("1- Adicionar Medico");
		System.out.println("2- Remover Medico por CRM");
		System.out.println("3- Pesquisar Medico por CRM ");
		System.out.println("4- Pesquisar Medico por parte do nome");
		System.out.println("5- Sair");
		System.out.printf("opcao:");
	}
	
	private static void menuconsultas(){
		System.out.println("\n----------Menu Consultas-----------\n");
		System.out.println("1- Adicionar nova consulta");
		System.out.println("2- Listar Consultas ");
		System.out.println("3- Quantidde de  Consultas por data ");
		System.out.println("4- Quantidade de Consultas por Medico");
		System.out.println("5- Listar Consultas por paciente");
		System.out.printf("6- sair");
		System.out.printf("opcao:");
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
		 System.out.printf("Digite o dia de nascimento:");
			int dia =lerinteiro();
			System.out.printf("Digite o mês do nascimento:");
			int mes =lerinteiro();
			System.out.printf("Digite o ano do nascimento:");
			int ano =lerinteiro();
			LocalDate data = LocalDate.of(ano, mes, dia);		 
		 return data;
	 }
	 
	 private static LocalTime lerHora(){
		    System.out.printf("Digite o hora da consulta(HH):");
			int hh =lerinteiro();
			System.out.printf("Digite o minuto:");
			int mm =lerinteiro();
			LocalTime hora= LocalTime.of(hh,mm);
		 return hora;
	 }
	 
	 private static Endereco lerEndereco(){
		 System.out.printf("Digite a Rua:");
			String rua =lerstring();
			System.out.printf("Digite o CEP:");
			String cep =lerstring();
			System.out.printf("Digite o Bairro:");
			String bairro =lerstring();
			System.out.printf("Digite o Complemento:");
			String comp =lerstring();
			Endereco endereco = new Endereco(cep,rua,bairro,comp);		 
		 return endereco;
	 }
	 
	 private static Medico lerMedico(){
		   System.out.printf("Digite o nome do Medico: ");
		   String nome=lerstring();
		   System.out.printf("Digite o CRM: ");
		   int crm=lerinteiro();
		   System.out.printf("Digite a especialidade: ");
		   String espec=lerstring();
		   Medico doctor=new Medico(nome,crm,espec);		 
	 return doctor;
	 }
	 
	private static Paciente lerPaciente(){
			System.out.printf("Digite o nome: ");
			String nome=lerstring();
			System.out.printf("Digite o CPF: ");
			String cpf=lerstring();
			System.out.printf("Digite o sexo: ");
			String sexo=lerstring();
			Endereco end=lerEndereco();
			LocalDate date=lerdata();
			Paciente pacient=new Paciente(nome,cpf,sexo,end,date);		 
	return pacient;
	}
}
