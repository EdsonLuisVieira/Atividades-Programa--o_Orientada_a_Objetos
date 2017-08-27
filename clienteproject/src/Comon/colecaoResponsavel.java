package Comon;

import java.util.ArrayList;

public class colecaoResponsavel {

ArrayList <Responsavel> listaResponsavel ; 
	
	public colecaoResponsavel(){
		listaResponsavel = new ArrayList <Responsavel>();
	}
	
	public void addResponsavel (Responsavel resp) {
		listaResponsavel.add(resp);
	}
	
	public void removerPmatricula(String matricula) throws Exception {
		for (Responsavel p : listaResponsavel) {
			if (p.getMatricula().equals(matricula)) {
				listaResponsavel.remove(p);
			}
		}
		throw new Exception ("Sem Responsaveis com esta Matricula"); // Solucionar problema - N�o achar uma matr�cula igual n�o lan�a exce��o pois n�o gera um erro.
	}

	public String pesquisaPmatricula(String matricula) throws Exception {
		for (Responsavel p : listaResponsavel) {
			if (p.getMatricula().equals(matricula)) {
				return p.toString();
			}
		}
		throw new Exception ("Sem Responsaveis com esta Matricula"); // Solucionar problema - N�o achar uma matr�cula igual n�o lan�a exce��o pois n�o gera um erro.
	}


}

