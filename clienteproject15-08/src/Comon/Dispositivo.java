package Comon;


/**
 * Interface para manipular informações básicas de Dispositivos monitorados
 * @author Edson Vieira
 * @author Miguel Cabral
 */

 public interface Dispositivo{

	/** Método GetMAC
	 *  @return mac
	 */
	public String getMac();

	/** Método SetMAC
	 *  @param mac
	 */
	public void setMac(String mac);

	/** Método GetIP
	 *  @return ip
	 */
	public String getIP();
	
	/** Método SetIP
	 *  @param ip 
	 */
	public void setIp(String ip);
	
	/** Método GetHost
	 *  @return host 
	 */
	public String getHost();

	/** Método SetHost
	 *  @param host 
	 */
	public void setHost(String host);
}
