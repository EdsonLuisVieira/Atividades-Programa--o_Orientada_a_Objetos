package exercicio1;

import java.util.Scanner;

public class consultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		Scanner sc = new Scanner (System.in);
		
		System.out.println("---Cadastro de paciente----");
		System.out.println("Caso deseje sair tecle CTRL+Z");

		
		while(1){
			System.out.printf("Digite o nome do paciente: ");
		    String nome =lerpaciente();
	    	System.out.printf("Digite o sexo do paciente: ");
		    String sexo	= lersexo();
		    System.out.printf("Digite a idade do paciente: ");
		    int idade = leridade();
			System.out.printf("Digite o valor da consulta: ");
			double valor = lervalor();
		}
	    

		System.out.println("1 - Imprimir na tela os dados armazenados");
		System.out.println("2 - Imprimir a média do valor das consultas realizadas");
		System.out.println("3 - Imprimir os dados das pessoas do sexo masculino");
		System.out.println("4 - Imprimir o maior valor de consulta realizadopor uma pessoa do sexo feminino");
        int x =lerinteiro;		
	    if (x==1){
	    	imprimirdados;
	    }else if(x == 2){
	    	 imprimirmedia;
	    }else if(x==3){
	    	 imprimirmasculino;
	    }else if(x==3){
	    	
	    }else if(x==4){
	    	  imprimirMvalorfeminino;
	    }else{
	    	System.out.println("Digite um valor valido");
	    }
			 
	}
	
	
	private static String lerpaciente(String paciente){
		
		return (paciente);	
	}
	
    private static String lersexo(String sexo){
	
    	return (sexo);
	}
    
    private static int leridade (int idade){
		
    	return (idade);
	}
    
    private static double lervalor(double valor){
		
    	return (valor);
	}
    
    private static void imprimirdados(){
		
  
	}

    private static void  imprimirmedia(){
		
    	
	}

    private static void  imprimirmasculino(){
		
    
	}

    private static void imprimirMvalorfeminino(){
		
	}

}
