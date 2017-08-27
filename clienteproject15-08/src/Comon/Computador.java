package Comon;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Properties;

/**
 * Classe que define informações do responsável por monitorar a rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */
 
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Computador")

public class Computador implements Serializable  {
	
	/** Atributos */
	

	/** Endereço Físico do Computador */
	private String mac;
	/** IP do Computador na rede */
	private String ip;
	/** Identificação do Computador na rede */
	private String host;
	/** Sistema Operacional do Computador */
	private String so;
	/** Versão do sistema operacional do Computador */
	private String versao;
	
	
	/** Metodos Construtores */
	public Computador() {
		Properties p = System.getProperties();
		this.so	= p.getProperty("os.name");
		this.versao	= p.getProperty("os.version");
		try {
			InetAddress h = InetAddress.getLocalHost();
			this.ip 	 = h.getHostAddress();
			this.host = h.getHostName();
			byte[] macBytes  = NetworkInterface.getByInetAddress(h).getHardwareAddress();
			this.mac = String.format ("%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x", macBytes[0], macBytes[1], macBytes[2], macBytes[3], macBytes[4], macBytes[5] ).toUpperCase();
		} catch (Exception e){ 
			this.ip 	 = new String("0.0.0.0");
			this.host = new String("Falha");
			this.mac	 = new String("00-00-00-00-00-00");
		}
	}
	/**
	 * @param computador
	 * @param mac
	 * @param ip
	 * @param host
	 */
	public Computador(String computador, String mac, String ip, String host) {
		this.mac        = mac;
		this.ip         = ip;
		this.host       = host;
	}

	
	/** Metodos Getters */

	/** getMac @return mac */
	public String getMac() {
		return mac;
	}
	/** getIP @return ip */
	public String getIP() {
		return ip;
	}
	/** getHost @return host */
	public String getHost() {
		return host;
	}
	/** getSO @return so */
	public String getSo() {
		return so;
	}
	/** getVersao @return versao */
	public String getVersao() {
		return versao;
	}
	

	
	/** Metodos Setters */

	/** setMac @param mac */
	public void setMac(String mac) {
		this.mac = mac;
	}
	/** setIp @param ip */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/** setHost @param host */
	public void setHost(String host) {
		this.host = host;
	}
	/** setSo @param so */
	public void setSo(String so) {
		this.so = so;
	}
	/** setVersao @param versao */
	public void setVersao(String versao) {
		this.versao = versao;
	}
	

	
	/** Metodo HashCode */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((so == null) ? 0 : so.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

	
	/** Metodo Equals */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computador other = (Computador) obj;
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
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Computador-IP=" +ip + ", MAC=" +mac + ", HOST=" + host + ", SO=" + so + ", VERSAO=" + versao + "\n";
	}

	
	
	
}
