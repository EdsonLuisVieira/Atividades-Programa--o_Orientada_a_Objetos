package textarqualquercoisa;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.lang.*;




public class teste {

	public static void main(String[] args) throws Exception {
		
		
		long start = System.currentTimeMillis();
	   
	    int i;
	    for (i=0;i<50;i++) {
	    System.out.println(i);
	    Thread.sleep(1000);
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("Concluido"+(end-start));
	    
	 }
	

}