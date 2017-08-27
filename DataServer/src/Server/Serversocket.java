package Server;
import java.awt.*;
import java.net.*;
import java.io.*;
public class Serversocket {

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // try {
		//	ServerSocket sock = new ServerSocket(5051);
			
			//agora, espera conexões
		/*	while(true) {
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
		}catch (IOException ioe) {System.err.println(ioe);}	*/
	
		try {
			// estabelece conexÃ£o com o socket do servidor
		//	PrintWriter outputStream = null; 
			//String line="";
			Socket sock = new Socket("192.168.10.108",5522);
			PrintWriter pout=new PrintWriter (sock.getOutputStream(),true);
			pout.println("1");
		//	sock.close();
			
		Socket soc = new Socket("192.168.10.108",5555);
			System.out.println("Conectado...");
		int filesize=6022386;
	    long start = System.currentTimeMillis();
	    int bytesRead;
	    int current = 0;
	   
	    // recebendo o arquivo
	    System.out.println("Coo");
	    byte [] mybytearray  = new byte [filesize];
	    InputStream is = soc.getInputStream();
	    FileOutputStream fos = new FileOutputStream("2teste3545.png");
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    bytesRead = is.read(mybytearray,0,mybytearray.length);
	    current = bytesRead;
	    System.out.println("Coo");
	    do {
	       bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
	       if(bytesRead >= 0) current += bytesRead;
	       System.out.println("Coo5");
	    } while(bytesRead > -1);
	    System.out.println("Cooih");
	    bos.write(mybytearray, 0 , current);
	    System.out.println("Cooi");
	    long end = System.currentTimeMillis();
	    System.out.println("Concluido"+(end-start));
	    bos.close();
	    soc.close();
		
			
			
			
		} catch (IOException ioe) {System.out.println(ioe);}
	
	}

}
