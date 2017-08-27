package Comon;

/**
 * Classe que define o Admnistrador da rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */
 
public class Admin extends Computador {

	/** Atributos */
	
	/** Lista de Responsáveis */
	ColecaoResponsavel administrador = new ColecaoResponsavel();
	/** Lista de Computadores */
	ColecaoComputador  computerLab   = new ColecaoComputador();
	
	/**
	 * Método Construtor
	 * @param computador
	 * @param mac
	 * @param ip
	 * @param host
	 */
	public Admin(String computador, String mac, String ip, String host) {
		super(computador, mac, ip, host);
	}
}
