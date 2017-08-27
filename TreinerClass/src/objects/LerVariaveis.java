package objects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class LerVariaveis {

	int dia;
	int mes;
	int ano;
	int hh;
	int mm;
	int inteiro;
	
	public LocalDate lerdata(){
		 System.out.printf("Digite o dia de nascimento:");
			this.dia=lerinteiro();
			System.out.printf("Digite o mês do nascimento:");
			this.mes =lerinteiro();
			System.out.printf("Digite o ano do nascimento:");
			this.ano =lerinteiro();
			LocalDate data = LocalDate.of(this.ano, this.mes, this.dia);		 
		 return data;
	 }
	 
	 public LocalTime lerHora(){
		    System.out.printf("Digite o hora da consulta(HH):");
			this.hh =lerinteiro();
			System.out.printf("Digite o minuto:");
			this.mm =lerinteiro();
			LocalTime hora= LocalTime.of(this.hh,this.mm);
		 return hora;
	 }
	 
	 public int lerinteiro(){
	    	Scanner scan= new Scanner (System.in);
	    	while(!scan.hasNextInt()){
			     scan.nextLine();
			     System.out.println("Valor invalido, digite um valor inteiro");	
			}
				this.inteiro = scan.nextInt();
		return (this.inteiro);
		}
	 
}
