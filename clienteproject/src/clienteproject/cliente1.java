package clienteproject;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.imageio.ImageIO;

import Comon.Computador;

public class cliente1 {
	
	private static  String OS = System.getProperty("os.name").toLowerCase();
	private static ServerSocket servsock;
	private static Robot robot;
	private static byte[] macAddressBytes;
	
	public static void main(String[] args) throws IOException {
		
		
		servsock = new ServerSocket(8888);
		while(true){
			Socket sock = servsock.accept();
		
			try {
				InputStream in = sock.getInputStream();
				BufferedReader bin = new BufferedReader(new InputStreamReader(in));
				String controle="";
				String aux;
				while ( (aux = bin.readLine()) != null )
					controle=aux;
				if (controle.equals("1")) { infoDisp(sock); }
				else if (controle.equals("2")) { printDisp(sock); }	
				else if (controle.equals("3")) { cmdDisp(sock); }	
				else if (controle.equals("4")) { DesligarDisp(sock); }	
              
			} catch (IOException ioe) {System.out.println(ioe);}
		}
	}
		

	private static void infoDisp(Socket sock) {			
					try {
						Computador pc;
						String dataFile="data.dat";
						Properties p = System.getProperties();
						InetAddress hostlocal = InetAddress.getLocalHost();
						NetworkInterface netInter = NetworkInterface.getByInetAddress(hostlocal);
						macAddressBytes = netInter.getHardwareAddress();			      
					    String macAddress =  String.format ( "%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
					    macAddressBytes[0], macAddressBytes[1],
					    macAddressBytes[2], macAddressBytes[3],
					    macAddressBytes[4], macAddressBytes[5] ).toUpperCase();
						pc = new Computador(hostlocal.getHostName(), macAddress, hostlocal.getHostName(),  p.getProperty("user.home"), p.getProperty("os.name"), p.getProperty("os.version"), p.getProperty("user.name"));	
						
						ObjectOutputStream out =new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream(dataFile)));
						out.writeObject(pc);
						out.close();
						
						byte [] mybytearray  = new byte [(int)dataFile.length()];
						FileInputStream fis = new FileInputStream(dataFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						bis.read(mybytearray,0,mybytearray.length);
						OutputStream os = sock.getOutputStream();
						System.out.println("Enviando...");
						os.write(mybytearray,0,mybytearray.length);
						os.flush();
						bis.close();
						sock.close();
						
					}catch (Exception ioe ) {System.out.println(ioe.getMessage());}
				
	}
	
	private static void printDisp(Socket sock) {		
					try {
						
						robot = new Robot();
						File myFile = new File ("log.txt");
						BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, 1400, 800)); 
						ImageIO.write(bi, "png", myFile);
						byte [] mybytearray  = new byte [(int)myFile.length()];
						FileInputStream fis = new FileInputStream(myFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						bis.read(mybytearray,0,mybytearray.length);
						OutputStream os = sock.getOutputStream();
						System.out.println("Enviando...");
						os.write(mybytearray,0,mybytearray.length);
						os.flush();
						bis.close();
						sock.close();
				
					}catch (Exception ioe) {System.out.println(ioe.getMessage());}
					
	}
	private static void cmdDisp(Socket sock) {
					try	{
	
						Runtime.getRuntime().exec("cmd /c netstat > netstat.txt");
						File myFile = new File ("netstat.txt");
						byte [] mybytearray  = new byte [(int)myFile.length()];
						FileInputStream fis = new FileInputStream(myFile);
						BufferedInputStream bis = new BufferedInputStream(fis);
						bis.read(mybytearray,0,mybytearray.length);
						OutputStream os = sock.getOutputStream();
						System.out.println("Enviando...");
						os.write(mybytearray,0,mybytearray.length);
						os.flush();
						bis.close();
						sock.close();
						
				    }catch (Exception ioe) {System.out.println(ioe.getMessage());}
	}
	
	private static void DesligarDisp(Socket sock) {
					try {
						if (isWindows()){
				    		String[] commandWin = new String[3];
				    		commandWin[0] = "cmd";
				    		commandWin[1] = "/c";
				    		commandWin[2] = "shutdown -s";
				    		Runtime.getRuntime().exec (commandWin);
				        }
				    	else if (isMac()) {
				    		String commandMac = "shutdown";
				    		Runtime.getRuntime().exec (commandMac);
				        }
				    	else if (isUnix()){
				    		String commandLin = "poweroff";
				    		Runtime.getRuntime().exec (commandLin);
				        }
						sock.close();
						
					}catch (Exception ioe) {System.out.println(ioe.getMessage());}		
				
				}		
	
	
	
		   public static boolean isWindows(){
		        return (OS.indexOf("win") >= 0);
		    }
		    public static boolean isMac()
		    {
		        return (OS.indexOf("mac") >= 0);
		    }
		    public static boolean isUnix()
		    {
		        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		    }
	
}
