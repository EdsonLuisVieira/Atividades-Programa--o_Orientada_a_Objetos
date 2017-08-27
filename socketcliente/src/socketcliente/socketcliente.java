package socketcliente;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

public class socketcliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {
		      Socket cliente = new Socket("Edson",12345);
		      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		      Date data_atual = (Date)entrada.readObject();
		      JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
		      entrada.close();
		      System.out.println("Conex�o encerrada");
		      cliente.close();
		    }
		    catch(Exception e) {
		      System.out.println("Erro: " + e.getMessage());
		    }
		 
		 /** Possíveis dados que o cliente enviará */
			Properties p = System.getProperties();
			System.out.println("Sistema Operacional: " + p.getProperty("os.name") + "\tArquitetura: " + p.getProperty("os.arch") + "\tVersao: " + p.getProperty("os.version"));
			System.out.println("Usuario: " + p.getProperty("user.name") + "\tPasta: " + p.getProperty("user.home"));

		 hostsRede(); 
	}


			
			public static void hostsRede(){
			/** @author MiguelCabral */
			byte[] end = new byte[4];
			end[0] = (byte)10;
			end[1] = (byte)0;
			end[2] = (byte)2;
			for(short i=100; i<106; i++){
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

