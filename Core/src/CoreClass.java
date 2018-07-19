import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class CoreClass {
	static int portNumber = 7;
	
	public static void main(String args[]) throws ClassNotFoundException {
		try
		{
			ServerSocket ss = new ServerSocket(portNumber,10);
			System.out.println("created socket server ");
			while (true) {
				Socket cs = ss.accept();
				System.out.println("Connected to new client");
				ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
				new SocketHandler(is).start();
				System.out.println("New thread running!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
