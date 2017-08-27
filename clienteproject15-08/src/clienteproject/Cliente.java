package clienteproject;

import Comon.Computador;
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
import javax.swing.JOptionPane;

public class Cliente {

	private static  String OS = System.getProperty("os.name").toLowerCase();
	private static ServerSocket servsock;
	private static Robot robot;
	private static int porta = 8888;
	private static Computador pc = new Computador();
	
	public static void main(String[] args) throws Exception {
		
		servsock = new ServerSocket(porta);
		while(true){
			Socket sock = servsock.accept();
			System.out.println("conectado");
			try {
				InputStream in = sock.getInputStream();
				BufferedReader bin = new BufferedReader(new InputStreamReader(in));
				String controle="";
				String aux;
				
				
				controle= bin.readLine();
					
				System.out.println(controle);
				
				
				if      (controle.equals("1")) { infoDisp(sock);     }
				else if (controle.equals("2")) { printDisp(sock);    }	
				else if (controle.equals("3")) { cmdDisp(sock);      }	
				else if (controle.equals("4")) { DesligarDisp(sock); }	
              
			} catch (IOException e) {System.out.println(e);}
		}
	}
		

	private static void infoDisp(Socket sock) {			
		try {
			System.out.println("1");
			System.out.print(pc);
			ObjectOutputStream saida = new ObjectOutputStream(sock.getOutputStream());
			saida.writeObject(pc);
			saida.flush();
			System.out.println("Enviando...");	
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
	}
	
	private static void printDisp(Socket sock) {		
		try {
			System.out.println("2");
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
			System.out.println("comcluido...");
	
		} catch (Exception e) { System.out.println(e.getMessage()); }
	}
	private static void cmdDisp(Socket sock) {
		String comand="";
		File myFile = new File("netstat.txt");
		try	{
			myFile.createNewFile();
			System.out.println("3");
			if (isWindows())
				comand="cmd /c netstat > netstat.txt";
			else if (isMac()) 
				comand="touch arq ; netstat > arq";
			else if (isUnix()) 
				comand="touch arq ; netstat > arq";
			
			Runtime.getRuntime().exec(comand);
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
			System.out.println("comcluido...");
			
			
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	private static void DesligarDisp(Socket sock) {
		JOptionPane.showMessageDialog(null,"valores iguais","",JOptionPane.INFORMATION_MESSAGE);
		String command = "";
		System.out.println("4");
		if (isWindows())
    		command = "cmd /c shutdown /f /p";
    	else if (isMac())
    		command = "shutdown -h +0";
    	else if (isUnix())
    		command = "poweroff";
		try {
			Runtime.getRuntime().exec (command);
			sock.close();
			System.out.println("concluido...");
			
			
		} catch (Exception e) { System.out.println(e.getMessage()); }
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
