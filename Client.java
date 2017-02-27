import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int filesize=1022386;
		int filesize=6022386;
		int bytesRead; 
		int currentTot = 0; 
		try {
				
			Socket socket = new Socket("127.0.0.1",15123);
			
		
			byte [] bytearray  = new byte [filesize];
			
			InputStream is = socket.getInputStream();
			
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("copy.pdf"));
				long start = System.currentTimeMillis();
				bytesRead = is.read(bytearray,0,bytearray.length);
			    currentTot = bytesRead;
			    do { 
			    	bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
			    if(bytesRead >= 0) 
			    	currentTot += bytesRead; 
			    double cost = System.currentTimeMillis() - start;
			    if (cost > 0 ) {
	 				System.out.println("Read " + currentTot + " bytes, speed: " + (currentTot / (1024.0*1024)) / (cost / 1000.0) + " MB/s");
	 				}
			    
			    }
			   while(bytesRead > -1);
			    
			 	/*for(int i=1;;i++){
			 		bytesRead = is.read(bytearray,0,bytearray.length);
			 		if(bytesRead<0)break;
			 		if(bytesRead >= 0) {
				    	currentTot += bytesRead; 
				    }
			 		System.out.println(System.currentTimeMillis() - start);
			 		double cost = System.currentTimeMillis() - start;
			 			System.out.println(cost);
			 			if (cost > 0 ) {
			 				System.out.println("Read " + currentTot + " bytes, speed: " + (currentTot / (1024.0*1024)) / (cost / 1000.0) + " MB/s");
			 			}
			 		
			 	}*/	
			    bos.write(bytearray, 0 , currentTot);
			    bos.flush();
			    bos.close();
			    socket.close();

			    
			    	
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
