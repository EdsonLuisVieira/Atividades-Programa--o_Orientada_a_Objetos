package Cadastro;

public class teste {

	public static void main(String[] args) {
		medico edson = new medico("12345689","edson","minas gerais","993939");
		System.out.println(""+edson.toString());
		
		Funcionario miguel = new medico("12345689","miguel","minas gerais","993939");
		System.out.println(""+miguel.toString());
		
	
		Funcionario jorge = new Funcionario("12345689","jorge","minas gerais");
		System.out.println(""+jorge.toString());
	}

}
