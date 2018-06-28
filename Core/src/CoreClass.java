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
	int portNumber = 7;
	
	public static void main(String args[]) throws ClassNotFoundException {
		try (
				ServerSocket ss = new ServerSocket(7);
				Socket cs = ss.accept();
				
				ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
				//PrintWriter out = new PrintWriter(cs.getOutputStream(),true);
				//BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				) 
		{
			System.out.println("connected");
//			String read;
//			while ((read = in.readLine())!=null) {
//				System.out.println(read);
//			}
			//boolean trued = true;
//			while (trued) {
//				System.out.println(is.available());
//				if (is.available()>0) trued=false;
//			}
			while (true) {
				NozzleMeasure temp = (NozzleMeasure)is.readObject();
//				int i = is.readInt();
//				System.out.println("received " + i);
				System.out.println(temp.date + " " + temp.locationId + " " + temp.gunId + " " + temp.tankId
						+ " "+ temp.literCounter + " " + temp.totalCounter + " " + temp.status);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
