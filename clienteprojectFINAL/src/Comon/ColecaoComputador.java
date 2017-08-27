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
		listaComputador = new ArrayList<Computador>();
	}
	
	
	/** Metodo Adiciona Computador
	 * @param pc Computador
	 */
	public void addComputador(Computador pc) {
		listaComputador.add(pc);
	}
	
	
	/** Metodo Remover Computador por IP
	 * @param ip do Computador
	 * @throws Exception caso nao consiga remover
	 */
	public void removerComputadorPip(String ip) throws Exception {
		try {
			listaComputador.remove(pesquisarComputadorPip(ip));
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	/** Metodo Pesquisar Computador por IP
	 * @param ip do Computador
	 * @return Computador
	 * @throws Exception caso nao exita computador com o ip informado
	 */
	public Computador pesquisarComputadorPip(String ip) throws Exception {
		for (Computador pc: listaComputador)
			if (pc.getIP().equals(ip))
				return pc;
		throw new Exception("Nao exite computador com este IP");
	}
	
	
	/** Metodo Pesquisar Computador por IP
	 * @param ip do Computador
	 * @return verdadeiro ou falso
	 */
	public boolean boleanPCporIp (String ip) {
	for (Computador pc: listaComputador)
		if (pc.getIP().equals(ip))
			return true;
	return false;
	}
	
	
	/** Metodo Listar Computadores imprime todos os Computadores da Colecao */
	public void listarComputadores(){
		for (Computador pc : listaComputador)
			System.out.println(pc);
	}
	
	
	/** Metodo Retornar Lista de Computadores 
	 * @return lista
	 */
	public ArrayList<String> retornarListaComputadores(){
		ArrayList<String> lista = new ArrayList<String>();
		for (Computador pc : listaComputador)
			lista.add(pc.toString());
		return lista;
	}
	
	
	/**
	 * Metodo que retorna o tamanho da Colecao de Computadores
	 * @return int
	 */
	public int size() {
		return listaComputador.size();
	}
}
