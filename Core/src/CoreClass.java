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
			
//			za pomoc¹ JPQL
//			mamy interwa³ czasowy t
//			tank measures zawiera "prawid³owe wartoœci"
//			obliczamy wartoœæ koñcow¹ po interwale i porównujemy z wartoœci¹ koñcow¹ z tank measures
//			dla ka¿dego z tanków osobno!
//			
//			dla danego tanka w danej chwili czasu startowej, to samo bêdzie dla koñcowego tylko z inn¹ dat¹
//			double startFuelVolume = em.createQuery("SELECT t.fuelVolume from TankMeasures t WHERE t.tankId=:tankId AND t.date=:date").setParameter("tankId",tankId).setParameter("date",date).getSingleResult();
//			
//			musimy uzwglêdniæ sprzeda¿ (sales) w tym okresie czasu. 
//			status - 1 od³o¿ony, 0 podniesiony
//			literCounter - bie¿¹cy licznik transkacji (status 0)
//			totalCounter - koñcowy licznik transakcji (status 1)
//			podczas 0 musimy zwracaæ uwagê na poprzedni stan aby odj¹æ dobr¹ wartoœæ: literCounter - poprzedni_literCounter z pomiaru (mo¿e byæ ze statusu 1 gdy to pierwszy raz w serii), 
//			podczas 1 jesli mamy totalCounter to odejmujemy ostatni literCounter ze statusem 0
//			dopiero t¹ wartoœæ mo¿emy odj¹æ od wartoœci startowej
//			
//			przy dostawach paliwa podobny problem - po pierwsze w jakiej jednostce jest szybkoœc tankowania?!
//			musimy sami na podstawie szybkoœci obliczyæ czy paliwo zosta³o ju¿ wpompowane i ile  i czy jest jeszcze co pompowaæ
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
