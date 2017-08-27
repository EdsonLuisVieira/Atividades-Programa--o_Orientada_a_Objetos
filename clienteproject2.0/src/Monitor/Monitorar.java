package Monitor;

/**
 * Classe auxiliar que roda no sistema monitor
 * @author Edson Vieira
 * @author Miguel Cabral
 */

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import Comon.ColecaoComputador;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import Comon.Computador;

public class Monitorar {
	public static int[] porta = {5432, 5433, 5434, 5435}; // comp, img, porta, desligar
	public static ColecaoComputador laboratorio;
	
	public static ColecaoComputador DispConectados(String rede) {
		laboratorio = new ColecaoComputador();
		int i;
		String host = new String("10.0.2.180");
		String campo[] = rede.split("\\.");
		try {
			for (i=100;i<=200;i++){
				System.out.println("tentei...\n");
				host=campo[0]+"."+campo[1]+"."+campo[2]+".";
				if (InetAddress.getByName(host+i).isReachable(1000)) {
					Socket sock = new Socket(host+i,5432);
					ObjectInputStream is = new ObjectInputStream(sock.getInputStream());
		            Computador pc = (Computador) is.readObject();
					laboratorio.addComputador(pc);
		            sock.close();
				}
			}
		} catch (Exception e) {System.err.println(e);};
		return laboratorio ;
	}

	public static <SerializeiDocument> Computador infoUmDisp(String ip) {
		 try{
			 ObjectOutputStream oos = null;
			 SerializeiDocument serialDoc = null;
			 
			    Socket sock = new Socket ( ip, 6661 );
			    oos = new ObjectOutputStream( sock.getOutputStream() );
			    //Supondo que serialDoc j� esteja setado...
			    oos.writeObject( serialDoc );
			    oos.flush();
			       oos.close(); 
			        sock.close();
			    }catch( Exception e ){ };
				return null;
	}
	
	public ArrayList<String> intruso(String rede) {
		ArrayList <String> intruso = new ArrayList <String>();
		String campo[] = rede.split("\\.");
		String host;
		int i;
		try {
			for (i=0;i<=255;i++){
				host=campo[0]+"."+campo[1]+"."+campo[2]+"."+i;
				if (InetAddress.getByName(host).isReachable(1000)) {
					if (!this.laboratorio.boleanPCporIp(host)) {
						intruso.add(host);
					}
				}
			}	
		}catch (Exception e) {};
		return intruso;
	}
	
	public void salvaArquivo(String caminho, String rede) {
		try {
			ArrayList <String> intruso=intruso(rede);
			BufferedWriter fr = new BufferedWriter(new FileWriter("C:\\"+caminho,true));
			fr.write(intruso.toString());
			fr.write(this.laboratorio.toString());
			fr.newLine();
			fr.flush();
			fr.close();
		}catch (Exception e) {};
	}
		
	public static void capturaTela(String ip, String arquivo) {
		try {  
			System.out.println("Conectado...");
	int filesize=6022386;
    long start = System.currentTimeMillis();
    int bytesRead;
    int current = 0;
    Socket sock = new Socket("10.0.2.180",2424);
    System.out.println("Conectado");
    // recebendo o arquivo
    byte [] mybytearray  = new byte [filesize];
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream(arquivo);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(mybytearray,0,mybytearray.length);
    current = bytesRead;
    do {
       bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
       if(bytesRead >= 0) current += bytesRead;
    } while(bytesRead > -1);
    bos.write(mybytearray, 0 , current);
    long end = System.currentTimeMillis();
    System.out.println("Concluido"+(end-start));
    bos.close();
    sock.close();
	}catch (Exception e){} 
	}
	
	public static void capturaProcessos(String ip, String nome) {
		try {  
			int filesize=6022386;
			long start = System.currentTimeMillis();
			int bytesRead;
			int current = 0;
			Socket sock = new Socket(ip,5434);
           	byte [] mybytearray  = new byte [filesize];
           	InputStream is = sock.getInputStream();
           	FileOutputStream fos = new FileOutputStream(nome+".txt");
           	BufferedOutputStream bos = new BufferedOutputStream(fos);
           	bytesRead = is.read(mybytearray,0,mybytearray.length);
           	current = bytesRead;
           	do {
           		bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
           		if(bytesRead >= 0) current += bytesRead;
           	} while(bytesRead > -1);
           	bos.write(mybytearray, 0 , current);
           	long end = System.currentTimeMillis();
           	bos.close();
           	sock.close();
		}catch (Exception e){};
	}

	
	public void salvaEmXML(){
		String rede="";
		
		XStream xStream = new XStream(new StaxDriver());
        xStream.alias("computador", Computador.class);
        xStream.alias("laboratorio", List.class);
        File arquivo = new File("pcs.xml");
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(this.laboratorio).getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
		
	} 
	
	public ColecaoComputador lerDoXML(){
		try {
			ColecaoComputador laboratorio1;
			XStream xStream = new XStream(new StaxDriver());
			//Questões de segurança
			XStream.setupDefaultSecurity(xStream);
			xStream.addPermission(AnyTypePermission.ANY); 
			xStream.alias("computador", Computador.class);
			xStream.alias("laboratorio", List.class);
			xStream.processAnnotations(Computador.class);
			BufferedInputStream input = new BufferedInputStream(new FileInputStream("pcs.xml"));
		    laboratorio1 = (ColecaoComputador) xStream.fromXML(input);
			input.close();
			return laboratorio1;
			
		}catch (IOException e) {e.printStackTrace();};
		return null;
	}
	
   public static void desligarPIp(String ip) {
	   try {
		   Socket sock = new Socket(ip,9999);
		  // sock.close();
   
	   }catch (Exception ioe) {System.out.println(ioe.getMessage());};
   }
   
   /*
   public void desligarTdDisp(String rede, int porta) {
	   ColecaoComputador lab = new ColecaoComputador();
	   lab = DispConectados(rede);
	   try {
		   for (Computador pc : lab) {
			   Socket sock = new Socket(pc.getIP(),porta);
		   	   sock.close();
		   }
	   }catch (Exception ioe) {System.out.println(ioe.getMessage());};
	   
   }*/
}