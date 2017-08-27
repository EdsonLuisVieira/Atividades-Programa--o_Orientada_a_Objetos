import java.net.*;
import java.io.*;

public class DateClient{
	public static void main(String[] args){
	try {
		// estabelece conexão com o socket do servidor
		Socket sock = new Socket("10.0.25.114",5000);
		InputStream in = sock.getInputStream();
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));

		// lê a data no socket
		String line;
		while ( (line = bin.readLine()) != null )
			System.out.println(line);

		// fecha a conexão com o socket
		sock.close();
	} catch (IOException ioe) {
		System.out.println(ioe);
	  }
	}
}
