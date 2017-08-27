package Pesquisaproject;

import java.util.*;
import java.awt.Rectangle;
import java.awt.Robot;
import java.net.*;

public class Pesqproject extends javax.servlet.http.HttpServlet{

	public static void main(String[] args)   {
		
		try {
			
			
			/**
			 * Capturar Informações da maquina
			 */
		      InetAddress hostlocal = InetAddress.getLocalHost();
		      NetworkInterface netInter = NetworkInterface.getByInetAddress(hostlocal);
		      byte[] macAddressBytes = netInter.getHardwareAddress();
		      
		      String macAddress =  String.format ( "%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
		      macAddressBytes[0], macAddressBytes[1],
		      macAddressBytes[2], macAddressBytes[3],
		      macAddressBytes[4], macAddressBytes[5] ).toUpperCase();
		   
		    
		      System.out.println("---Host Local---");
		      System.out.println("host: "+hostlocal.getHostName());
		      System.out.println("Ipv4 Local: "+hostlocal.getHostAddress());
		      System.out.println("Mac: "+macAddress);
		      System.out.println("Placa de saida: "+netInter.getDisplayName());
		      System.out.println("Interface de Saida: "+netInter.getName());
		      System.out.println("------------------------------"); 
		      
		    
		      
		      /**
			   * Capturar Informações de Urls ip de Endereços de serviços e tradução dns 
			   */
		      
		     
		      InetAddress service1 = InetAddress.getByName("216.58.202.4");
		      System.out.println("Servico1:" + service1.getCanonicalHostName());
		      System.out.println("EndereçoIp do Servico1:" + service1.getHostAddress());
		      InetAddress and = InetAddress.getByName("www.google.com"); 
		      System.out.println("end google: "+and.getHostAddress());
		      System.out.println("hostanme google: "+and.getHostName());
		      InetAddress service3 = InetAddress.getByName("www.facebook.com"); 
		      System.out.println("end facebbok: "+service3.getHostAddress());
		      System.out.println("hostanme facebook: "+service3.getHostName());
		      
		    
		       

		    }catch (Exception end){System.out.println(""+end.getMessage());}
		    
		 	
		
		 
		
		 try{
			 
			 /**
			  * Informações sobre a Rede que o Dispositivo está conectado
			  */
	
			 System.out.println("------------------------------"); 
			 InetAddress var =InetAddress.getByName("DESKTOP-3DS0N");
			 NetworkInterface end=NetworkInterface.getByInetAddress(var);
    		 List <InterfaceAddress> valuee = new ArrayList <InterfaceAddress>();
			 valuee = end.getInterfaceAddresses();
			 for (int i=0;i<valuee.size();i++) {
				 System.out.println("Info gerais host Local: "+valuee.get(i)); 
			 }
			 
		Rectangle ret=new Rectangle();	
		ret.add(100,100);
		System.out.println(""+ret.toString());
			 
		 }catch (Exception end){System.out.println(""+end.getMessage());}
		 System.out.println("------------------------------"); 
		 
		 

			/** PossÃ­veis dados que o cliente enviarÃ¡ */
			Properties p = System.getProperties();
			System.out.println("Sistema Operacional: " + p.getProperty("os.name") + "\tArquitetura: " + p.getProperty("os.arch") + "\tVersao: " + p.getProperty("os.version"));
			System.out.println("Usuarrio: " + p.getProperty("user.name") + "\tPasta: " + p.getProperty("user.home"));

	
	
			/** @author MiguelCabral */
			byte[] end = new byte[4];
			end[0] = (byte)10;
			end[1] = (byte)0;
			end[2] = (byte)2;
			for(short i=1; i<256; i++){
				end[3] = (byte)i;
				try{
					InetAddress host = InetAddress.getByAddress(end);
					if (host.isReachable(1000)) System.out.print("Ok");
					else System.out.print("TimeOut");
					System.out.println("\tNome: " + host.getHostName() + "\tIP: " + host.getHostAddress());
				}catch (Exception e){}
			
		}
	

	
	}	 
}


		      
		      
		      
	
	


