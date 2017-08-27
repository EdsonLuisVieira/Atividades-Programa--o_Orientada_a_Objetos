package Monitor;
import Comon.colecaoResponsavel;

import java.util.Scanner;

import Comon.colecaoComputador;
import Comon.Computador;

public class monitor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		colecaoComputador pcs = new colecaoComputador();
		colecaoResponsavel resp =new colecaoResponsavel();
		Computador host;
		int x;
		while(true) {
			menu();
			x=lerinteiro();
			if (x==1) {
				while(true){
					menuInfo();
					x=lerinteiro();
					if(x==1) { //detectar dispositivos
						System.out.println("Digite o ip da Rede:");
						String ip=lerstring();
						System.out.println("Digite a mascar da rede");
						String mask=lerstring();
					}else if(x==2) { //detectar um unico dispositivo
						System.out.println("Digite o ip da Rede:");
						String ip=lerstring();

						
					}else if(x==3) {//ip intruso
						
					}else if(x==4) {//log arquivo
						
					}else if(x==5) {//menu
						break;
					}else {
						System.out.println("Digite um Valor entre 1 e 5");
				    }
				}
			}else if(x==2) {
				while(true){ 
					menuProcesso();
					x=lerinteiro();
					if(x==1) { //capturar um processo p ip
						
					}else if(x==2) {//capturar todos processos p ip
						
					}else if(x==3) {//salvar processos
						
					}else if(x==4) {//resgatar processos
						
					}else if(x==5) {//menu
						break;
					}else {
						System.out.println("Digite um Valor entre 1 e 5");
				    }
				}
			}else if(x==3) {
				while(true) {
					menuCaptura();
					x=lerinteiro();
					if(x==1) {//um unico
					
					}else if(x==2) {//todos
						
					}else if(x==3) {// menu
						break;
					}else {
						System.out.println("Digite um Valor entre 1 e 5");
			        }
			    }
				
			}else if(x==4) {
				while(true) {
					menuDesligar();
					x=lerinteiro();
					if(x==1) {//desligar um
					
					}else if(x==2) {//desligar todos
						
					}else if(x==3) {
						break;
					}else {
						System.out.println("Digite um Valor entre 1 e 5");
			        }
			    }
			}else if(x==5) {
					break;
			}else {
				System.out.println("Digite um Valor entre 1 e 5");
			}
			
			
			
			
		}
	}
	
	private static void menu(){
		System.out.println("\n---------MONITOR DE REDE-----------\n");
		System.out.println("1- Buscar Informacoes de Dispositivos Conectados");
		System.out.println("2- Capturar Processos de Rede aTivos em Dispositivo Conectado");
		System.out.println("3- Capturar tela de Dispositivos Conectados ");
		System.out.println("4- Desligar Dispositivos Conectados");
		System.out.println("5- Encerrar programa");
		System.out.printf("opcao:");
        
	}
	
	
	private static void menuInfo(){
		System.out.println("\n----------Menu Informacoes-----------\n");
		System.out.println("1- Listar Informacoes de Dispositivos Conectados");
		System.out.println("2- Buscar Informacoes de um Dispositivo por IP");
		System.out.println("3- Listar IP de dispositivos intrusos");
		System.out.println("4- Salvar log de informacoes em arquivo");
		System.out.println("5- Retornar ao menu principal");
		System.out.printf("opcao:");
		
	}
	
	private static void menuProcesso(){
		System.out.println("\n----------Menu Processos-----------\n");
		System.out.println("1- Capturar Processos de um Dispositivo IP");
		System.out.println("2- Capturar Processos de Todos os Dispositivos de uma rede");
		System.out.println("4- Processos Salvos da ultima inicialização");
		System.out.println("5- Retornar ao menu principal");
		System.out.printf("opcao:");
	}
	
	private static void menuCaptura(){
		System.out.println("\n----------Menu Consultas-----------\n");
		System.out.println("1- Capturar tela de um unico Dispositivo por ip");
		System.out.println("2- Retornar ao menu Principal");
		System.out.printf("opcao:");
	}
	
	private static void menuDesligar(){
		System.out.println("\n----------Menu Desligar-----------\n");
		System.out.println("1- Desligar Dispositivo por ip");
		System.out.println("2- Desligar todos os Dispositivos de uma Rede");
		System.out.println("3- Retornar ao menu Principal");
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
}
