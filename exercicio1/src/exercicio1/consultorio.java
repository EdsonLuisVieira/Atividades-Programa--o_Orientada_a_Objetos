package exercicio1;

import java.util.*;

public class consultorio {



	private static int i;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		Scanner scan= new Scanner (System.in);
		
		String[] nome = new String[100];
		String[] sexo = new String[100];
		int[] idade = new int[100];
		double[] valor = new double[100];
		int cont =0;
		
		System.out.println("-----------CADASTRO DE PACIENTES----------");


		String abort;
		while(true){
			System.out.printf("Digite o nome do paciente: ");
		    nome[cont]=lerpaciente();
	    	System.out.printf("Digite o sexo do paciente: ");
		    sexo[cont]=lersexo();
		    System.out.printf("Digite a idade do paciente: ");
		    idade[cont]=lerinteiro();
			System.out.printf("Digite o valor da consulta R$: ");
			valor[cont]=lervalor();
			cont++;
			System.out.println("");
			System.out.printf("Deseja continuar cadastrando pacientes?");
			abort=lerstring();
				if((abort.equals("nao"))||(abort.equals("n"))){
					break;
				}
			
		}
		  
		
	    
		while(true){
			System.out.println("");
			System.out.println("---------------------CONNSULTA DADOS-------------------------");
			System.out.println("1 - Imprimir na tela os dados armazenados");
			System.out.println("2 - Imprimir a média do valor das consultas realizadas");
			System.out.println("3 - Imprimir os dados das pessoas do sexo masculino");
			System.out.println("4 - Imprimir o maior valor de consulta realizado por uma pessoa do sexo feminino");
			int x = lerinteiro();		
			if (x==1){
				imprimirdados(nome, sexo, idade, valor, cont);
			}else if(x == 2){
				imprimirmedia(valor,cont);
			}else if(x==3){
				imprimirmasculino(nome,sexo,idade,valor,cont);
			}else if(x==4){
				imprimirMvalorfeminino(sexo,valor,cont);
			}else{
				System.out.println("");
				System.out.println("Digite um valor valido, ");	
			}
			System.out.println("");
			System.out.printf("Deseja continuar?");
	    abort=lerstring();
		if((abort.equals("nao"))||(abort.equals("n"))){
			break;
		}
		}
	
			 
	}
	
	
	
	/**
	 * Função que ler o nome do paciente  (ler e retorna string)
	 * 
	 *
	 */
	
	public static String lerpaciente(){
		Scanner scan= new Scanner (System.in);
		while(!scan.hasNextLine()){
		     scan.nextLine();
		     System.out.println("Valor invalido,Digite o nome do paciente:");	
		}
			String nome= scan.nextLine();
	return (nome);
	}
	
	
	/**
	 * Função que ler o sexo do paciente (ler e retorna string) 
	 */
	
    public static String lersexo(){
    	Scanner scan= new Scanner (System.in);
		while(!scan.hasNextLine()){
		     scan.nextLine();
		     System.out.println("Valor invalido,Digite o sexo do paciente:");	
		}
		String sexo= scan.nextLine();
	return (sexo);
	}
    
          
    /**
	 * Função que ler o valor da consulta (ler e retorna double)  
	 */
    
    public static double lervalor(){
    	Scanner scan= new Scanner (System.in);
    	while(!scan.hasNextDouble()){
		     scan.nextLine();
		     System.out.println("Valor invalido,Digite o valor da consulta do paciente:");	
		}
		double valor = scan.nextDouble();
	return (valor);
	}
    
    /**
 	 * Função que ler um inteiro e serve para qualquer chamada que necessite de um int com tratamento.  
 	 */
    
    public static int lerinteiro(){
    	Scanner scan= new Scanner (System.in);
    	while(!scan.hasNextInt()){
		     scan.nextLine();
		     System.out.println("Valor invalido, digite um valor inteiro");	
		}
		int x = scan.nextInt();
	return (x);
	}
    
    /**
 	 * Função que ler uma string e serve para qualquer chamada que necessite de uma string.  
 	 */
    
    public static String lerstring(){
    	Scanner scan= new Scanner (System.in);
		String z = scan.nextLine();
	return (z);
	}
    
    
    /**
  	 * Função que imprime todos os dados de um paciente.  
  	 */ 
    
    private static void imprimirdados(String[] nome, String[] sexo, int[] idade, double[] valor, int cont){
		for (int i=0;i<cont;i++){
			System.out.println("");
			System.out.println("Paciente N°:"+(i+1));
			System.out.println("Nome :"+nome[i]);
			System.out.println("Sexo :"+sexo[i]);
			System.out.println("Idade :"+idade[i]);
			System.out.println("Valor da consulta R$:"+valor[i]);
		}
  
	}
    
    
    /**
  	 * Imprime a média das consulta realizadass.  
  	 */

    private static void  imprimirmedia(double[] valor, int cont){
		double R=0;
    	for (int i=0;i<cont;i++){
			R= R+valor[i];
		}
    	System.out.println("O valor medio das consultas foi: "+(R/cont));
	}
    
    
    /**
  	 * Imprime os dados dos clientes masculinos.  
  	 */
    
    private static void  imprimirmasculino(String[] nome, String[] sexo, int[] idade, double[] valor, int cont){
    	for (int i=0;i<cont;i++){
			if((sexo[i].equals("masculino"))||(sexo[i].equals("MASCULINO"))||(sexo[i].equals("M"))||(sexo[i].equals("m"))){
				System.out.println("");
				System.out.println("Paciente N°:"+(i+1));
    			System.out.println("Nome :"+nome[i]);
    			System.out.println("Sexo :"+sexo[i]);
    			System.out.println("Idade :"+idade[i]);
    			System.out.println("Valor da consulta R$:"+valor[i]);
		
			}
    	}
	}

    
    /**
  	 * Imprime o Maior valor de uma consulta do sexo feminino.  
  	 */
    
    private static void imprimirMvalorfeminino(String[] sexo, double[] valor, int cont){
    	double comp=Double.MIN_VALUE;
    	for (int i=0;i<cont;i++){
			if((sexo[i].equals("feminino"))||(sexo[i].equals("FEMININO"))||(sexo[i].equals("F"))||(sexo[i].equals("f"))){
    			if(valor[i]>comp){
    				comp=valor[i];
    			}
		
			}
    	}
    	System.out.println("");
    	System.out.println("O maior valor de consulta para o sexo feminino foi R$ "+comp);
	}

}
