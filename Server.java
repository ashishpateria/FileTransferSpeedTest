import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			 ServerSocket serverSocket = new ServerSocket(15123);
			 Socket socket = serverSocket.accept();
			 File transferFile = new File ("CrackingtheCodingInterview.pdf");
			 byte [] bytearray=new  byte [(int)transferFile.length()]; 
			 BufferedInputStream bin=new BufferedInputStream(new FileInputStream(transferFile));
			 bin.read(bytearray, 0, bytearray.length);
			 OutputStream os = socket.getOutputStream();
			 System.out.println("Sending Files");
			 os.write(bytearray,0,bytearray.length);
			 os.flush();
			 socket.close();
			 serverSocket.close();
			 bin.close();
			System.out.println("File Sending done");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
