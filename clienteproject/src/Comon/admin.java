package Comon;

public class admin extends Computador {

	colecaoResponsavel administrador = new colecaoResponsavel();
	colecaoComputador computerLab = new colecaoComputador();
	
	public admin(String computador, String mac, String ip, String host) {
		super(computador, mac, ip, host);
	}

	
	
}
