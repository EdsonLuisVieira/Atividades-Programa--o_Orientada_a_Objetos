import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaEndCidades correios = new ListaEndCidades();
	    
		do{
			int x=lerinteiro();
			if (x==0){
				Endereco e =new Endereco("Minas Gerais","popular",288,"58301-070","0121","69849");
				correios.AdicionaEndereco(e);
			}else if (x==1){
				try{
				System.out.println("" +correios.BuscaEndPBairro("popular"));
				}catch (Exception end){System.out.println(""+end.getMessage());}
			}else if (x==2){
				try{
				System.out.println(""+correios.BuscaEndPGps("69849"));
				}catch (Exception end){System.out.println(""+end.getMessage());}
			}else if (x==3){
				System.out.println("" +correios.QtdEndPCep("58301-070"));
			}else if (x==4){
				try{
				correios.RemoveEndePGps("69849");
				}catch (Exception end){System.out.println(""+end.getMessage());}
			}else if (x==5){
				System.out.println(""+correios.toString());
			}else if (x==6){
				break;
			}
	   
		}while(true);
	    
	}
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
