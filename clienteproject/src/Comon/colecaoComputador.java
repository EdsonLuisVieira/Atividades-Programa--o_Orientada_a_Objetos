package Comon;

import java.util.*;

public class colecaoComputador {

	ArrayList <Computador> listaComputador;
	
	public colecaoComputador() {
		listaComputador = new ArrayList <Computador>();
	}
	
	public void addComputador(Computador pc){
		listaComputador.add(pc);
	}
	
	public void removerComputadorPip(String ip) throws Exception{ // Sugest�o - Retornar Boolean
		for (Computador pc: listaComputador) {
			if (pc.getIP().equals(ip)) {
				listaComputador.remove(pc);
			}
		}throw new Exception("Nao exite computador com este Ip");	// Solucionar problema - N�o achar um ip igual n�o lan�a exce��o pois n�o gera um erro.
		
	}

	public String pesquisarComputadorPip(String ip) throws Exception{
		for (Computador pc: listaComputador) {
			if (pc.getIP().equals(ip)) {
				return pc.toString();
			}
		}throw new Exception("Nao exite computador com este Ip");	// Solucionar problema - N�o achar um ip igual n�o lan�a exce��o pois n�o gera um erro.
		
	}

	public boolean boleanPCporIp (String ip) {
	for (Computador pc: listaComputador) {
		if (pc.getIP().equals(ip)) {
			return true;
		}
	}	
	return false;
}
}



