package Comon;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("computador")

public class Computador implements dispositivo {
	
	private String computador;
	private String mac;
	private String ip;
	private String host;
	private String so;
	private String versao;
	private String usuario;

	public Computador(String computador, String mac, String ip, String host, String so, String versao, String usuario) {
		this.computador=computador;
		this.mac=mac;
		this.ip=ip;
		this.host=host;
		this.so=so;
		this.versao=versao;
		this.usuario=usuario;
	}
	
	public Computador(String computador, String mac, String ip, String host) {
		this.computador=computador;
		this.mac=mac;
		this.ip=ip;
		this.host=host;
	}
	
	public Computador(String ip) {
		this.ip=ip;
		
	}

	public String getComputador() {
		return computador;
	}

	public void setComputador(String computador) {
		this.computador = computador;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getIP() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((computador == null) ? 0 : computador.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((so == null) ? 0 : so.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { // Ajeite isso mermão
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computador other = (Computador) obj;
		if (computador == null) {
			if (other.computador != null)
				return false;
		} else if (!computador.equals(other.computador))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (so == null) {
			if (other.so != null)
				return false;
		} else if (!so.equals(other.so))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computador=" + computador + "\n Mac=" + mac + "\n Host=" + host + "\n So=" + so + "\n Versao="
				+ versao + "\n Usuario=" + usuario ;
	}
	
	
	
}
