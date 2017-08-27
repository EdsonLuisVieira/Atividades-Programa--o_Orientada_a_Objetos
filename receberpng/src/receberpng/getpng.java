package receberpng;

import java.net.*;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
//CODIGO ADAPTADO
//Fontes: http://www.guj.com.br/t/transferir-arquivos-via-socket/100935/6
//        http://www.guj.com.br/t/print-screen-em-java/68884

public class getpng {

	public static void main(String[] args) throws IOException {
		
	    //enviarPrint();
		receberPrint();
		//txtprofessor();
		
	}	
	
	
	public static void enviarPrint(){
		try {
		    // cria o nosso socket
			System.out.println("ligou o servidor!");
		    ServerSocket servsock = new ServerSocket(5555);
		    Robot robot = new Robot();
		    
		    while (true) {
		      Socket sock = servsock.accept();
		      System.out.println("Conexão aceita: " + sock);
		      File myFile = new File ("C:\\Users\\Edson\\Pictures\\edkkkksd.png");
		      
		      BufferedImage bi = robot.createScreenCapture(new // Captura a tela na àrea definida pelo retângulo
		  	  Rectangle(0, 0, 1400, 800)); // aqui vc configura as posições xy e o tam da área que quer capturar
		  	  ImageIO.write(bi, "png", myFile);// Salva a ima
		      // envia o arquivo (transforma em byte array)
		      
		     // File myFile = new File ("C:\\Users\\Edson\\Pictures\\edsd.png");
		      byte [] mybytearray  = new byte [(int)myFile.length()];
		      FileInputStream fis = new FileInputStream(myFile);
		      BufferedInputStream bis = new BufferedInputStream(fis);
		      bis.read(mybytearray,0,mybytearray.length);
		      OutputStream os = sock.getOutputStream();
		      System.out.println("Enviando...");
		      os.write(mybytearray,0,mybytearray.length);
		      os.flush();
		      sock.close();
		      }
		    
		}catch(Exception ioe) {System.out.println(ioe.getMessage());}
   }	
		
	public static void receberPrint() {	
		
			try {  
				System.out.println("Conectado...");
		int filesize=6022386;
	    long start = System.currentTimeMillis();
	    int bytesRead;
	    int current = 0;
	    System.out.println("Conectado...");
	    
	    Socket sock = new Socket("10.0.2.180",5555);
	    sock.setSoTimeout(1222);
	    System.out.println("Conectado");
	    // recebendo o arquivo
	    byte [] mybytearray  = new byte [filesize];
	    InputStream is = sock.getInputStream();
	    FileOutputStream fos = new FileOutputStream("2teste3.png");
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
			
		public static void txtprofessor() throws IOException {
			
			BufferedReader inputStream = null;
		      PrintWriter outputStream = null;
		 
		      try {
		         inputStream = new BufferedReader(new FileReader("edson.txt"));
		         outputStream = new PrintWriter(new BufferedWriter(new FileWriter("linesoutput.txt")));
		 
		         String line;
		         while ((line = inputStream.readLine()) != null) {
		            outputStream.println(line);
		         }
		      } finally {
		         if (inputStream != null) {
		            inputStream.close();
		         }
		         if (outputStream != null) {
		            outputStream.close();
		         }
		      }
			
		}
		
	
	
}
