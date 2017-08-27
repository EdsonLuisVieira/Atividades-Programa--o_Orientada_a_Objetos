package Monitor;

import Comon.Computador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import Comon.colecaoComputador;
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
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;
public class metodosMonitorar {
	
	private colecaoComputador laboratorio;
	
	
	public void DispConectados(String rede) {
		laboratorio = new colecaoComputador();
		int i;
		String host;
		String campo[] = rede.split("\\.");
		
	
		
		
		try {
			for (i=0;i<=255;i++){
				host=campo[0]+"."+campo[1]+"."+campo[2]+".";
				if (InetAddress.getByName(host+i).isReachable(1000)) {
					Socket sock = new Socket("10.0.25."+i,8888);
					PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);//adicionei isso
					pout.println("1");//e isso
					ObjectInputStream is = new ObjectInputStream(sock.getInputStream());
		            Computador pc = (Computador) is.readObject();
					laboratorio.addComputador(pc);
		            sock.close();
				}
				
			}	
		}catch (Exception ioe) {}
	}


	public Computador infoUmDisp(String ip){
		try {
		if (InetAddress.getByName(ip).isReachable(1000)) {
			Socket sock = new Socket(ip,8888);
			
			//envia a flag
			
			PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);
			pout.println("1");
			
			//recebe o arquivo que contem oobjeto
			
			String dataFile ="dataFile.dat";
			int filesize=6022386;
			long start = System.currentTimeMillis();
			int bytesRead;
			int current = 0;
		
           	byte [] mybytearray  = new byte [filesize];
           	InputStream is = sock.getInputStream();
           	FileOutputStream fos = new FileOutputStream(dataFile);
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
          
           	
           	//extrai o objeto do arquivo e salva na variavel
           
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            Computador pc = (Computador) in.readObject();
            in.close();
			sock.close();
			return pc;
		}
		}catch(Exception io) {System.out.println(io.getMessage());};
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
					if (!laboratorio.boleanPCporIp(host)) {
						intruso.add(host);
					}
				}
			}	
		}catch (Exception ioe) {};
		return intruso;
	}
	
	public void Salvarquivo(String caminho, String rede) {
		try {
			ArrayList <String> intruso=intruso(rede);
			colecaoComputador dispositivos=laboratorio;
		
			BufferedWriter fr = new BufferedWriter(new FileWriter("C:\\"+caminho,true));
			fr.write(intruso.toString());
			fr.write(dispositivos.toString());
			fr.newLine();
			fr.flush();
			fr.close();
		}catch (Exception ioe) {};
	}
		
	public void capturaTela(String ip, String nome) {
		try {  
			int filesize=6022386;
			long start = System.currentTimeMillis();
			int bytesRead;
			int current = 0;
			Socket sock = new Socket(ip,8888);
			
			PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);//adicionei isso
			pout.println("2");//e isso
			
           	byte [] mybytearray  = new byte [filesize];
           	InputStream is = sock.getInputStream();
           	FileOutputStream fos = new FileOutputStream(nome+".png");
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
	
	public void capturaprocessos(String ip, String nome) {
		try {  
			int filesize=6022386;
			long start = System.currentTimeMillis();
			int bytesRead;
			int current = 0;
			Socket sock = new Socket(ip,8888);
			
			PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);
			pout.println("3");
			
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
            gravar.write(xStream.toXML(laboratorio).getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
		
	} 
	
	public colecaoComputador lerDoXML(){
		try {
			colecaoComputador laboratorio1;
			XStream xStream = new XStream(new StaxDriver());
			//Questões de segurança
			XStream.setupDefaultSecurity(xStream);
			xStream.addPermission(AnyTypePermission.ANY); 
			xStream.alias("computador", Computador.class);
			xStream.alias("laboratorio", List.class);
			xStream.processAnnotations(Computador.class);
			BufferedInputStream input = new BufferedInputStream(new FileInputStream("pcs.xml"));
		    laboratorio1 = (colecaoComputador) xStream.fromXML(input);
			input.close();
			return laboratorio1;
			
		}catch (IOException ex) {ex.printStackTrace();};
		return null;
	}
	
   public void desligarPIp(String ip) {
	   try {
		   Socket sock = new Socket(ip,8888);
		   
			PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);
			pout.println("4");
			
		   sock.close();
   
	   }catch (Exception ioe) {System.out.println(ioe.getMessage());};
   }
   
   
   public void desligarTdDisp(String rede) {
	   try {
		   colecaoComputador lab= new colecaoComputador();
		   for (Computador pc : laboratorio) {
			   Socket sock = new Socket(pc.getIP(),8888);
				PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);
				pout.println("4");
		   	   sock.close();
		   }
	   }catch (Exception ioe) {System.out.println(ioe.getMessage());};
	   
   }


}




