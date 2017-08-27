package Comon;
/**
 * Classe que manipula um conjunto de computadores conectados na rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */

import java.util.ArrayList;

public class ColecaoComputador {
	
	/** Atributos */
	
	/** Lista de Computadores */
	ArrayList <Computador> listaComputador;
	
	
	/** Metodo Construtor */
	
	public ColecaoComputador() {
		listaComputador = new ArrayList <Computador>();
	}
	
	
	/** Metodo Adiciona Computador
	 * @param pc
	 */
	public void addComputador(Computador pc) {
		listaComputador.add(pc);
	}
	
	
	/** Metodo Remover Computador por IP
	 * @param ip
	 * @throws Exception
	 */
	public void removerComputadorPip(String ip) throws Exception {
		try {
			listaComputador.remove(pesquisarComputadorPip(ip));
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/** Metodo Pesquisar Computador por IP
	 * @param ip
	 * @return Computador
	 * @throws Exception
	 */
	public Computador pesquisarComputadorPip(String ip) throws Exception {
		for (Computador pc: listaComputador)
			if (pc.getIP().equals(ip))
				return pc;
		throw new Exception("Nao exite computador com este IP");
	}
	
	
	/** Metodo Pesquisar Computador por IP
	 * @param ip
	 * @return verdadeiro ou falso
	 */
	public boolean boleanPCporIp (String ip) {
	for (Computador pc: listaComputador)
		if (pc.getIP().equals(ip))
			return true;
	return false;
	}
	
	public void listarComputadores(){
		for (Computador pc : listaComputador)
			System.out.println(pc);
	}
	
}